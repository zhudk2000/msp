package com.ruoyi.web.controller.system;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HrCandidate;
import com.ruoyi.system.domain.HrCandidateQaDetail;
import com.ruoyi.system.domain.HrCandidateQaSum_Customize;
import com.ruoyi.system.domain.HrInterviewQuestions;
import com.ruoyi.system.domain.HrPositionQuestions;
import com.ruoyi.system.domain.HrPositions;
import com.ruoyi.system.service.IHrCandidateQaDetailService;
import com.ruoyi.system.service.IHrCandidateService;
import com.ruoyi.system.service.IHrInterviewQuestionsService;
import com.ruoyi.system.service.IHrPositionQuestionsService;
import com.ruoyi.system.service.IHrPositionsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.common.core.page.TableDataInfo;
import com.alibaba.fastjson.*;
/**
 * 候选人答题结果Controller
 * 
 * @author DK
 * @date 2021-08-04
 */
@Controller
@RequestMapping("/system/candidate/qa/detail")
public class HrCandidateQaDetailController extends BaseController
{
    private String prefix = "system/candidate/qa/detail";

    @Autowired
    private IHrCandidateQaDetailService hrCandidateQaDetailService;
    
    @Autowired
    private IHrCandidateService hrCandidateService;
    
    @Autowired
    private IHrPositionQuestionsService hrPositionQuestionService;
    
    @Autowired
    private IHrInterviewQuestionsService hrInterviewQuestionsService;
    
    @Autowired
    private IHrPositionsService hrPositionService;

    @GetMapping()
    public String candidate_qa_detail()
    {
        return prefix + "/detail";
    }

    /**
     * 查询候选人答题结果列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrCandidateQaDetail hrCandidateQaDetail)
    {
        startPage();
        List<HrCandidateQaDetail> list = hrCandidateQaDetailService.selectHrCandidateQaDetailList(hrCandidateQaDetail);
        return getDataTable(list);
    }

    /**
     * 导出候选人答题结果列表
     */
    @Log(title = "候选人答题结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrCandidateQaDetail hrCandidateQaDetail)
    {
        List<HrCandidateQaDetail> list = hrCandidateQaDetailService.selectHrCandidateQaDetailList(hrCandidateQaDetail);
        ExcelUtil<HrCandidateQaDetail> util = new ExcelUtil<HrCandidateQaDetail>(HrCandidateQaDetail.class);
        return util.exportExcel(list, "候选人答题结果数据");
    }

    /**
     * 新增候选人答题结果
     * @param 候选人id
     * @return 前端网址
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap)
    {
    	HrCandidate hrCandidate = hrCandidateService.selectHrCandidateById(id);
    	List<HrPositionQuestions> list = hrPositionQuestionService.selectHrPositionQuestionsByPositionId(hrCandidate.getInterviewPosition1Id());
    	HrPositions hrPosition = hrPositionService.selectHrPositionsById(hrCandidate.getInterviewPosition1Id());
    	
    	mmap.put("quiz", list);
    	mmap.put("candidate", hrCandidate);
    	mmap.put("position", hrPosition);
    	mmap.put("answerBatch", DateUtils.dateTimeNow());
    	
    	HashSet<String> h = new HashSet<String>();
    	for(HrPositionQuestions q: list){
    		h.add(q.getQuestionCategory());
    	}
    	List<String> categorys = new ArrayList<String>();
    	categorys.addAll(h);
    	mmap.put("quiz_category", h);
    	
        return prefix + "/add";
    }
    
    /**
     * 保存候选人答题结果
     * @param answer前端组合成的JSON答题字符串
     * @return 成功saved 失败failed
     */
    @PostMapping("/saveAnswer")
    @ResponseBody
    public String saveAnswer(String answer) {
    	String result = "saved";
    	String deocdeString = "";
    	try{
    		deocdeString = URLDecoder.decode(answer, "UTF-8");
    		JSONArray ja = JSONObject.parseArray(deocdeString);
    		for(int i=0; i<ja.size(); i++) {
    			JSONObject o = ja.getJSONObject(i);
    			HrCandidateQaDetail qa = new HrCandidateQaDetail();
    			qa.setId(UUID.randomUUID().toString());
    			qa.setAnswerBatch(o.getString("answerBatch"));
    			qa.setCandidateAnswer(o.getString("candidateAnswer"));
    			qa.setCandidateId(o.getString("candidateId"));
    			qa.setCandidateName(o.getString("candidateName"));
    			HrInterviewQuestions quiz = hrInterviewQuestionsService.selectHrInterviewQuestionsById(o.getString("questionId"));
    			//判断分数 选择题或判断题自动批改，填空题需要手工改分
    			if (quiz.getQuestionFormat().equals("1")) { //选择题或判断题
    				if(quiz.getCorrectAnswer().equals(qa.getCandidateAnswer())) {
    					qa.setCandidateScore(quiz.getQuestionScore());  //正确答案得分
    				}else {
    					Long l = new Long("0");
    					qa.setCandidateScore(l); //错误答案不得分
    				}
    			}
    			qa.setQuestionScore(quiz.getQuestionScore());
    			try {
    				qa.setCreateBy(ShiroUtils.getLoginName());
    			}catch(Exception e) {
    				qa.setCreateBy("external" + DateUtils.getNowDate());
    			}
    			qa.setCreateTime(DateUtils.getNowDate());
    			qa.setPositionId(o.getString("positionId"));
    			qa.setPositionName(o.getString("positionName"));
    			qa.setPositionQuestionId(o.getString("positionQuestionId"));
    			qa.setQuestion(o.getString("questionDesc"));
    			qa.setQuestionCategory(o.getString("questionCategory"));
    			qa.setQuestionId(o.getString("questionId"));
    			qa.setQuestionSubCategory(o.getString("questionSubCategory"));
    			
    			hrCandidateQaDetailService.insertHrCandidateQaDetail(qa);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		result = "failed";
    	}
    	
    	return result;
    }

    /**
     * 新增保存候选人答题结果
     */
    @Log(title = "候选人答题结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrCandidateQaDetail hrCandidateQaDetail)
    {
        return toAjax(hrCandidateQaDetailService.insertHrCandidateQaDetail(hrCandidateQaDetail));
    }

    /**
     * 修改候选人答题结果
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        // 根据候选人ID获得最新的问卷答案
    	List<HrCandidateQaDetail> list = hrCandidateQaDetailService.selectHrCandidateQaDetailByCandidateId(id);
        mmap.put("answers", list);

        HrCandidate candidate = hrCandidateService.selectHrCandidateById(id);
        mmap.put("candidate", candidate);
        
        String answered = "1";
    	HashSet<String> h = new HashSet<String>();
    	for(HrCandidateQaDetail q: list){
    		h.add(q.getQuestionCategory());
    		if (q.getCandidateScore() == null) {
    			answered = "0";
    		}
    	}
    	
    	mmap.put("all_answered", answered);
    	
    	if (answered.equals("1")) {
    		HrCandidateQaSum_Customize obj = new HrCandidateQaSum_Customize();
    		obj.setCandidateId(id);
    		obj.setAnswerBatch(list.get(0).getAnswerBatch());
    		List<HrCandidateQaSum_Customize> lstScore = hrCandidateQaDetailService.selectScoreSummaryByCategoryByCan_Batch(obj);
    		// 构造雷达图所需的数据
    		String indicator = "", indicatorMax = "", indicator_all100 = "", data = "", data_all100 = "";
    		for(int i=0; i< lstScore.size(); i++) {
    			HrCandidateQaSum_Customize t = lstScore.get(i);
    			indicator += t.getQuestionCategory();
    			indicatorMax += t.getMaxScore();
    			indicator_all100 += t.getQuestionCategory();
    			data += t.getScore();
    			Double c = new Double( (1.0 * t.getScore() / t.getMaxScore()) * 100);
    			data_all100 += Math.round(c);
    			
    			if (i < lstScore.size() - 1) {
    				indicator += ";";
    				indicatorMax += ";";
    				indicator_all100 += ";";
    				data += ";";
    				data_all100 += ";";
    			}
    		}
			
			List<String> chartData = new ArrayList<String>();
			chartData.add(indicator);
			chartData.add(indicatorMax);
			chartData.add(indicator_all100);
			chartData.add(data);
			chartData.add(data_all100);
			mmap.put("chartData", chartData);
    	}
    	
    	List<String> categorys = new ArrayList<String>();
    	categorys.addAll(h);
    	mmap.put("quiz_category", h);
        
        return prefix + "/edit";
    }
    
    @PostMapping("/updateScore")
    @ResponseBody
    public String updateScore(String scores) {
    	String result = "saved";
    	try {
    		String decodeString = URLDecoder.decode(scores, "UTF-8");
    		JSONArray ja = JSONObject.parseArray(decodeString);
    		for(int i=0; i<ja.size(); i++) {
    			JSONObject o = ja.getJSONObject(i);
    			HrCandidateQaDetail qa = new HrCandidateQaDetail();
    			qa.setId(o.getString("id"));
    			Long score = new Long(o.getString("value"));
    			qa.setCandidateScore(score);
    			hrCandidateQaDetailService.updateHrCandidateQaDetail(qa);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		result = "failed";
    	}
    	
    	return result;
    }
    

    /**
     * 修改保存候选人答题结果
     */
    @Log(title = "候选人答题结果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrCandidateQaDetail hrCandidateQaDetail)
    {
        return toAjax(hrCandidateQaDetailService.updateHrCandidateQaDetail(hrCandidateQaDetail));
    }

    /**
     * 删除候选人答题结果
     */
    @Log(title = "候选人答题结果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrCandidateQaDetailService.deleteHrCandidateQaDetailByIds(ids));
    }
}
