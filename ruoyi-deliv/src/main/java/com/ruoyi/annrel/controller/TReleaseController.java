package com.ruoyi.annrel.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.annrel.domain.TRelease;
import com.ruoyi.annrel.service.ITReleaseService;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * 通知发布Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/notire/notire")
public class TReleaseController extends BaseController
{
    @Resource
    private ITReleaseService tReleaseService;

    /**
     * 查询通知发布列表
     */
    @PreAuthorize("@ss.hasPermi('notire:notire:list')")
    @GetMapping("/list")
    public TableDataInfo list(TRelease tRelease)
    {
        startPage();
        List<TRelease> list = tReleaseService.selectTReleaseList(tRelease);
        return getDataTable(list);
    }

    /**
     * 导出通知发布列表
     */
    @PreAuthorize("@ss.hasPermi('notire:notire:export')")
    @Log(title = "通知发布", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TRelease tRelease)
    {
        List<TRelease> list = tReleaseService.selectTReleaseList(tRelease);
        ExcelUtil<TRelease> util = new ExcelUtil<TRelease>(TRelease.class);
        util.exportExcel(response, list, "通知发布数据");
    }

    /**
     * 获取通知发布详细信息
     */
    @PreAuthorize("@ss.hasPermi('notire:notire:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tReleaseService.selectTReleaseById(id));
    }

    /**
     * 新增通知发布
     */
    @PreAuthorize("@ss.hasPermi('notire:notire:add')")
    @Log(title = "通知发布", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TRelease tRelease)
    {
        tRelease.setCreateBy(getUsername());
        tRelease.setUpdateBy(getUsername());
        return toAjax(tReleaseService.insertTRelease(tRelease));
    }

    /**
     * 修改通知发布
     */
    @PreAuthorize("@ss.hasPermi('notire:notire:edit')")
    @Log(title = "通知发布", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TRelease tRelease)
    {
        tRelease.setUpdateBy(getUsername());
        return toAjax(tReleaseService.updateTRelease(tRelease));
    }

    /**
     * 删除通知发布
     */
    @PreAuthorize("@ss.hasPermi('notire:notire:remove')")
    @Log(title = "通知发布", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tReleaseService.deleteTReleaseByIds(ids));
    }
}
