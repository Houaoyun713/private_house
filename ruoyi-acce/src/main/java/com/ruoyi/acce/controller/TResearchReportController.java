package com.ruoyi.acce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.acce.domain.TResearchReport;
import com.ruoyi.acce.service.ITResearchReportService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 调研报告材料Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/repo/repo")
public class TResearchReportController extends BaseController
{
    @Autowired
    private ITResearchReportService tResearchReportService;

    /**
     * 查询调研报告材料列表
     */
    @PreAuthorize("@ss.hasPermi('repo:repo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TResearchReport tResearchReport)
    {
        startPage();
        List<TResearchReport> list = tResearchReportService.selectTResearchReportList(tResearchReport);
        return getDataTable(list);
    }

    /**
     * 导出调研报告材料列表
     */
    @PreAuthorize("@ss.hasPermi('repo:repo:export')")
    @Log(title = "调研报告材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TResearchReport tResearchReport)
    {
        List<TResearchReport> list = tResearchReportService.selectTResearchReportList(tResearchReport);
        ExcelUtil<TResearchReport> util = new ExcelUtil<TResearchReport>(TResearchReport.class);
        util.exportExcel(response, list, "调研报告材料数据");
    }

    /**
     * 获取调研报告材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('repo:repo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tResearchReportService.selectTResearchReportById(id));
    }

    /**
     * 新增调研报告材料
     */
    @PreAuthorize("@ss.hasPermi('repo:repo:add')")
    @Log(title = "调研报告材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TResearchReport tResearchReport)
    {
        tResearchReport.setCreateBy(getUsername());
        tResearchReport.setUpdateBy(getUsername());
        return toAjax(tResearchReportService.insertTResearchReport(tResearchReport));
    }

    /**
     * 修改调研报告材料
     */
    @PreAuthorize("@ss.hasPermi('repo:repo:edit')")
    @Log(title = "调研报告材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TResearchReport tResearchReport)
    {
        tResearchReport.setUpdateBy(getUsername());
        return toAjax(tResearchReportService.updateTResearchReport(tResearchReport));
    }

    /**
     * 删除调研报告材料
     */
    @PreAuthorize("@ss.hasPermi('repo:repo:remove')")
    @Log(title = "调研报告材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tResearchReportService.deleteTResearchReportByIds(ids));
    }
}
