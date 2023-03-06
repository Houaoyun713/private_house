package com.ruoyi.annrel.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.annrel.domain.TAnnoRelease;
import com.ruoyi.annrel.service.ITAnnoReleaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告发布Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/annrel/annrel")
public class TAnnoReleaseController extends BaseController
{
    @Resource
    private ITAnnoReleaseService tAnnoReleaseService;

    /**
     * 查询公告发布列表
     */
    @ApiOperation("查询公告发布列表")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAnnoRelease tAnnoRelease)
    {
        startPage();
        List<TAnnoRelease> list = tAnnoReleaseService.selectTAnnoReleaseList(tAnnoRelease);
        return getDataTable(list);
    }

    /**
     * 导出公告发布列表
     */
    @ApiOperation("导出公告发布列表")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:export')")
    @Log(title = "公告发布", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAnnoRelease tAnnoRelease)
    {
        List<TAnnoRelease> list = tAnnoReleaseService.selectTAnnoReleaseList(tAnnoRelease);
        ExcelUtil<TAnnoRelease> util = new ExcelUtil<TAnnoRelease>(TAnnoRelease.class);
        util.exportExcel(response, list, "公告发布数据");
    }

    /**
     * 获取公告发布详细信息
     */
    @ApiOperation("获取公告发布详细信息")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAnnoReleaseService.selectTAnnoReleaseById(id));
    }

    /**
     * 新增公告发布
     */
    @ApiOperation("新增公告发布")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:add')")
    @Log(title = "公告发布", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAnnoRelease tAnnoRelease)
    {
        tAnnoRelease.setCreateBy(getUsername());
        tAnnoRelease.setUpdateBy(getUsername());
        return toAjax(tAnnoReleaseService.insertTAnnoRelease(tAnnoRelease));
    }

    /**
     * 修改公告发布
     */
    @ApiOperation("修改公告发布")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:edit')")
    @Log(title = "公告发布", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAnnoRelease tAnnoRelease)
    {
        tAnnoRelease.setUpdateBy(getUsername());
        return toAjax(tAnnoReleaseService.updateTAnnoRelease(tAnnoRelease));
    }

    /**
     * 删除公告发布
     */
    @ApiOperation("删除公告发布")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:remove')")
    @Log(title = "公告发布", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAnnoReleaseService.deleteTAnnoReleaseByIds(ids));
    }

    /**
     * 查询首页列表
     */
    @ApiOperation("查询首页列表")
    @PreAuthorize("@ss.hasPermi('annrel:annrel:homeList')")
    @GetMapping("/homeList")
    public AjaxResult homeList()
    {
        return success(tAnnoReleaseService.selectTHomeList());
    }
}
