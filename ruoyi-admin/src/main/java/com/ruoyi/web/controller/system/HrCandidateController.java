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
import com.ruoyi.system.domain.HrCandidate;
import com.ruoyi.system.service.IHrCandidateService;
import com.ruoyi.system.service.IHrPositionsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 候选人信息Controller
 * 
 * @author DK
 * @date 2021-07-27
 */
@Controller
@RequestMapping("/system/candidate")
public class HrCandidateController extends BaseController
{
    private String prefix = "system/candidate";

    @Autowired
    private IHrCandidateService hrCandidateService;
    
    @Autowired
    private IHrPositionsService hrPositionService;

    @RequiresPermissions("system:candidate:view")
    @GetMapping()
    public String candidate()
    {
        return prefix + "/candidate";
    }

    /**
     * 查询候选人信息列表
     */
    @RequiresPermissions("system:candidate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HrCandidate hrCandidate)
    {
        startPage();
        List<HrCandidate> list = hrCandidateService.selectHrCandidateList(hrCandidate);
        return getDataTable(list);
    }

    /**
     * 导出候选人信息列表
     */
    @RequiresPermissions("system:candidate:export")
    @Log(title = "候选人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HrCandidate hrCandidate)
    {
        List<HrCandidate> list = hrCandidateService.selectHrCandidateList(hrCandidate);
        ExcelUtil<HrCandidate> util = new ExcelUtil<HrCandidate>(HrCandidate.class);
        return util.exportExcel(list, "候选人信息数据");
    }

    /**
     * 新增候选人信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	mmap.put("hr_position", hrPositionService.selectHrPositionsAll());
        return prefix + "/add";
    }

    /**
     * 新增保存候选人信息
     */
    @RequiresPermissions("system:candidate:add")
    @Log(title = "候选人信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HrCandidate hrCandidate)
    {
        return toAjax(hrCandidateService.insertHrCandidate(hrCandidate));
    }

    /**
     * 修改候选人信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HrCandidate hrCandidate = hrCandidateService.selectHrCandidateById(id);
        mmap.put("hrCandidate", hrCandidate);
        mmap.put("hr_position", hrPositionService.selectHrPositionsAll());
        return prefix + "/edit";
    }

    /**
     * 修改保存候选人信息
     */
    @RequiresPermissions("system:candidate:edit")
    @Log(title = "候选人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HrCandidate hrCandidate)
    {
        return toAjax(hrCandidateService.updateHrCandidate(hrCandidate));
    }

    /**
     * 删除候选人信息
     */
    @RequiresPermissions("system:candidate:remove")
    @Log(title = "候选人信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hrCandidateService.deleteHrCandidateByIds(ids));
    }
}
