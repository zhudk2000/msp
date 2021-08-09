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
import com.ruoyi.system.service.IHrInterviewQuestionsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题库维护Controller
 * 
 * @author DK
 * @date 2021-07-28
 */
@Controller
@RequestMapping("/system/questions")
public class HrInterviewQuestionsController extends BaseController
{
    private String prefix = "system/questions";

    @Autowired
    private IHrInterviewQuestionsService hrInterviewQuestionsService;

    @RequiresPermissions("system:questions:view")
    @GetMapping()
    public String questions()
    {
        return prefix + "/questions";
    }

    /**
     * 查询题库维护列表
     */
    @RequiresPermissions("system:questions:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrInterviewQuestions hrInterviewQuestions)
    {
        startPage();
        List<HrInterviewQuestions> list = hrInterviewQuestionsService.selectHrInterviewQuestionsList(hrInterviewQuestions);
        return getDataTable(list);
    }
    
    @PostMapping("/catequiz")
    @ResponseBody
    public TableDataInfo catequiz(HrInterviewQuestions hrInterviewQuestions)
    {
    	startPage();
    	List<HrInterviewQuestions> list = hrInterviewQuestionsService.selectHrInterviewQuestionsList(hrInterviewQuestions);
        return getDataTable(list);
    }
    
    @PostMapping("/getQuizById")
    @ResponseBody
    public HrInterviewQuestions getQuizById(String id) {
    	HrInterviewQuestions obj = new HrInterviewQuestions();
    	obj.setId(id);
    	List<HrInterviewQuestions> list = hrInterviewQuestionsService.selectHrInterviewQuestionsList(obj);
    	if (list.size() > 0) {
    		return list.get(0);
    	}else {
    		return null;
    	}
    }

    /**
     * 导出题库维护列表
     */
    @RequiresPermissions("system:questions:export")
    @Log(title = "题库维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrInterviewQuestions hrInterviewQuestions)
    {
        List<HrInterviewQuestions> list = hrInterviewQuestionsService.selectHrInterviewQuestionsList(hrInterviewQuestions);
        ExcelUtil<HrInterviewQuestions> util = new ExcelUtil<HrInterviewQuestions>(HrInterviewQuestions.class);
        return util.exportExcel(list, "题库维护数据");
    }

    /**
     * 新增题库维护
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存题库维护
     */
    @RequiresPermissions("system:questions:add")
    @Log(title = "题库维护", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrInterviewQuestions hrInterviewQuestions)
    {
        return toAjax(hrInterviewQuestionsService.insertHrInterviewQuestions(hrInterviewQuestions));
    }

    /**
     * 修改题库维护
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HrInterviewQuestions hrInterviewQuestions = hrInterviewQuestionsService.selectHrInterviewQuestionsById(id);
        mmap.put("hrInterviewQuestions", hrInterviewQuestions);
        return prefix + "/edit";
    }

    /**
     * 修改保存题库维护
     */
    @RequiresPermissions("system:questions:edit")
    @Log(title = "题库维护", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrInterviewQuestions hrInterviewQuestions)
    {
        return toAjax(hrInterviewQuestionsService.updateHrInterviewQuestions(hrInterviewQuestions));
    }

    /**
     * 删除题库维护
     */
    @RequiresPermissions("system:questions:remove")
    @Log(title = "题库维护", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrInterviewQuestionsService.deleteHrInterviewQuestionsByIds(ids));
    }
}
