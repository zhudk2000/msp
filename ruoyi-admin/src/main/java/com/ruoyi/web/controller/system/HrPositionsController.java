package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.HrPositionQuestions;
import com.ruoyi.system.domain.HrPositions;
import com.ruoyi.system.service.IHrPositionQuestionsService;
import com.ruoyi.system.service.IHrPositionsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 岗位信息Controller
 * 
 * @author DK
 * @date 2021-07-28
 */
@Controller
@RequestMapping("/system/positions")
public class HrPositionsController extends BaseController
{
    private String prefix = "system/positions";

    @Autowired
    private IHrPositionsService hrPositionsService;
    
    @Autowired
    private IHrPositionQuestionsService hrPositionQuestionService;

    @RequiresPermissions("system:positions:view")
    @GetMapping()
    public String positions()
    {
        return prefix + "/positions";
    }

    /**
     * 查询岗位信息列表
     */
    @RequiresPermissions("system:positions:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrPositions hrPositions)
    {
        startPage();
        List<HrPositions> list = hrPositionsService.selectHrPositionsList(hrPositions);
        return getDataTable(list);
    }
    
    @PostMapping("/all")
    @ResponseBody
    public TableDataInfo selectHrPositionsAll() {
    	startPage();
    	List<HrPositions> list = hrPositionsService.selectHrPositionsAll();
    	return getDataTable(list);
    }
    
    @GetMapping("/preview_quiz/{id}")
    public String previewQuiz(@PathVariable("id") String id, ModelMap mmap) {
    	List<HrPositionQuestions> list = hrPositionQuestionService.selectHrPositionQuestionsByPositionId(id);
    	HrPositions position = hrPositionsService.selectHrPositionsById(id);
    	mmap.put("questions", list);
    	mmap.put("position", position);
    	
    	HashSet<String> h = new HashSet<String>();
    	for(HrPositionQuestions q: list){
    		h.add(q.getQuestionCategory());
    	}
    	List<String> categorys = new ArrayList<String>();
    	categorys.addAll(h);
    	mmap.put("quiz_category", h);
    	
    	return "system/position_quiz/preview_quiz";
    }
    
    /**
     * 导出岗位信息列表
     */
    @RequiresPermissions("system:positions:export")
    @Log(title = "岗位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrPositions hrPositions)
    {
        List<HrPositions> list = hrPositionsService.selectHrPositionsList(hrPositions);
        ExcelUtil<HrPositions> util = new ExcelUtil<HrPositions>(HrPositions.class);
        return util.exportExcel(list, "岗位信息数据");
    }

    /**
     * 新增岗位信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存岗位信息
     */
    @RequiresPermissions("system:positions:add")
    @Log(title = "岗位信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrPositions hrPositions)
    {
        return toAjax(hrPositionsService.insertHrPositions(hrPositions));
    }

    /**
     * 修改岗位信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HrPositions hrPositions = hrPositionsService.selectHrPositionsById(id);
        mmap.put("hrPositions", hrPositions);
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位信息
     */
    @RequiresPermissions("system:positions:edit")
    @Log(title = "岗位信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrPositions hrPositions)
    {
        return toAjax(hrPositionsService.updateHrPositions(hrPositions));
    }

    /**
     * 删除岗位信息
     */
    @RequiresPermissions("system:positions:remove")
    @Log(title = "岗位信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrPositionsService.deleteHrPositionsByIds(ids));
    }
    
    
    /**
     * 查询岗位题库详细信息
     */
    @RequiresPermissions("system:positions:edit")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String postionId, ModelMap mmap)
    {
    	HrPositions obj = hrPositionsService.selectHrPositionsById(postionId);
        mmap.put("hrPositions", hrPositionsService.selectHrPositionsAll());
        mmap.put("hrPositionQuiz", hrPositionQuestionService.selectHrPositionQuestionsByPositionId(postionId));
        mmap.put("postionId", postionId);
        mmap.put("postionName", obj.getPositionName());
        return "system/position_quiz/position_quiz";
    }
    
}
