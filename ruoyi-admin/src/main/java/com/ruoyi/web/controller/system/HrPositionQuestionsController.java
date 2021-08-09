package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.HrInterviewQuestions;
import com.ruoyi.system.domain.HrPositionQuestions;
import com.ruoyi.system.service.IHrInterviewQuestionsService;
import com.ruoyi.system.service.IHrPositionQuestionsService;
import com.ruoyi.system.service.IHrPositionsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 岗位考题维护Controller
 * 
 * @author DK
 * @date 2021-07-28
 */
@Controller
@RequestMapping("/system/position_quiz")
public class HrPositionQuestionsController extends BaseController
{
    private String prefix = "system/position_quiz";

    @Autowired
    private IHrPositionQuestionsService hrPositionQuestionsService;
    
    @Autowired
    private IHrPositionsService hrPositionServicel;
    
    @Autowired
    private IHrInterviewQuestionsService hrInterviewQuestionsService;
    
    @Autowired
    private IHrPositionsService hrPositionsService;

    @RequiresPermissions("system:position_quiz:view")
    @GetMapping()
    public String position_quiz()
    {
        return prefix + "/position_quiz";
    }

    /**
     * 查询岗位考题维护列表
     */
    @RequiresPermissions("system:position_quiz:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrPositionQuestions hrPositionQuestions, ModelMap mmap)
    {
        startPage();
        List<HrPositionQuestions> list = hrPositionQuestionsService.selectHrPositionQuestionsList(hrPositionQuestions);
        mmap.put("hrPositions", hrPositionsService.selectHrPositionsAll());
        return getDataTable(list);
    }
    
    @PostMapping("/getQuizListByPQid")
    @ResponseBody
    public TableDataInfo list(String id) {
    	List<HrInterviewQuestions> list = hrInterviewQuestionsService.selectHrInterviewQuestionsByPQId(id);
    	return getDataTable(list);
    }

    /**
     * 导出岗位考题维护列表
     */
    @RequiresPermissions("system:position_quiz:export")
    @Log(title = "岗位考题维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrPositionQuestions hrPositionQuestions)
    {
        List<HrPositionQuestions> list = hrPositionQuestionsService.selectHrPositionQuestionsList(hrPositionQuestions);
        ExcelUtil<HrPositionQuestions> util = new ExcelUtil<HrPositionQuestions>(HrPositionQuestions.class);
        return util.exportExcel(list, "岗位考题维护数据");
    }

    /**
     * 新增岗位考题维护
     */
    @GetMapping("/add/{positionId}")
    public String add(@PathVariable("positionId") String positionId, ModelMap mmap)
    {
    	mmap.put("hr_position", hrPositionServicel.selectHrPositionsById(positionId));
    	mmap.put("quiz_category", hrInterviewQuestionsService.selectAllCateSubCate());
        return prefix + "/add";
    }
   
    /**
     * 新增保存岗位考题维护
     */
    @RequiresPermissions("system:position_quiz:add")
    @Log(title = "岗位考题维护", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrPositionQuestions hrPositionQuestions)
    {
        return toAjax(hrPositionQuestionsService.insertHrPositionQuestions(hrPositionQuestions));
    }

    /**
     * 修改岗位考题维护
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HrPositionQuestions hrPositionQuestions = hrPositionQuestionsService.selectHrPositionQuestionsById(id);
        mmap.put("hr_position", hrPositionServicel.selectHrPositionsById(hrPositionQuestions.getPositionId()));
    	mmap.put("quiz_category", hrInterviewQuestionsService.selectAllCateSubCate());
        mmap.put("hrPositionQuestions", hrPositionQuestions);
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位考题维护
     */
    @RequiresPermissions("system:position_quiz:edit")
    @Log(title = "岗位考题维护", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrPositionQuestions hrPositionQuestions)
    {
        return toAjax(hrPositionQuestionsService.updateHrPositionQuestions(hrPositionQuestions));
    }

    /**
     * 删除岗位考题维护
     */
    @RequiresPermissions("system:position_quiz:remove")
    @Log(title = "岗位考题维护", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrPositionQuestionsService.deleteHrPositionQuestionsByIds(ids));
    }
}
