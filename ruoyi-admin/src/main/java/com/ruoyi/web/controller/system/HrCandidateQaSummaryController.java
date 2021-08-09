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
import com.ruoyi.system.domain.HrCandidateQaSummary;
import com.ruoyi.system.service.IHrCandidateQaSummaryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 候选人答题结果汇总Controller
 * 
 * @author DK
 * @date 2021-08-04
 */
@Controller
@RequestMapping("/system/candidate/qa/summary")
public class HrCandidateQaSummaryController extends BaseController
{
    private String prefix = "system/candidate/qa/summary";

    @Autowired
    private IHrCandidateQaSummaryService hrCandidateQaSummaryService;

    @GetMapping()
    public String candidate_qa_summary()
    {
        return prefix + "/summary";
    }

    /**
     * 查询候选人答题结果汇总列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrCandidateQaSummary hrCandidateQaSummary)
    {
        startPage();
        List<HrCandidateQaSummary> list = hrCandidateQaSummaryService.selectHrCandidateQaSummaryList(hrCandidateQaSummary);
        return getDataTable(list);
    }

    /**
     * 导出候选人答题结果汇总列表
     */
    @Log(title = "候选人答题结果汇总", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrCandidateQaSummary hrCandidateQaSummary)
    {
        List<HrCandidateQaSummary> list = hrCandidateQaSummaryService.selectHrCandidateQaSummaryList(hrCandidateQaSummary);
        ExcelUtil<HrCandidateQaSummary> util = new ExcelUtil<HrCandidateQaSummary>(HrCandidateQaSummary.class);
        return util.exportExcel(list, "候选人答题结果汇总数据");
    }

    /**
     * 新增候选人答题结果汇总
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存候选人答题结果汇总
     */
    @Log(title = "候选人答题结果汇总", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrCandidateQaSummary hrCandidateQaSummary)
    {
        return toAjax(hrCandidateQaSummaryService.insertHrCandidateQaSummary(hrCandidateQaSummary));
    }

    /**
     * 修改候选人答题结果汇总
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HrCandidateQaSummary hrCandidateQaSummary = hrCandidateQaSummaryService.selectHrCandidateQaSummaryById(id);
        mmap.put("hrCandidateQaSummary", hrCandidateQaSummary);
        return prefix + "/edit";
    }

    /**
     * 修改保存候选人答题结果汇总
     */
    @Log(title = "候选人答题结果汇总", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrCandidateQaSummary hrCandidateQaSummary)
    {
        return toAjax(hrCandidateQaSummaryService.updateHrCandidateQaSummary(hrCandidateQaSummary));
    }

    /**
     * 删除候选人答题结果汇总
     */
    @Log(title = "候选人答题结果汇总", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrCandidateQaSummaryService.deleteHrCandidateQaSummaryByIds(ids));
    }
}
