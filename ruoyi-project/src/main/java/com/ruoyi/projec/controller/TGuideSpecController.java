package com.ruoyi.projec.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.projec.domain.TGuideSpec;
import com.ruoyi.projec.service.ITGuideSpecService;
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
 * 导则规范Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/dard/dard")
public class TGuideSpecController extends BaseController
{
    @Resource
    private ITGuideSpecService tGuideSpecService;

    /**
     * 查询导则规范列表
     */
    @PreAuthorize("@ss.hasPermi('dard:dard:list')")
    @GetMapping("/list")
    public TableDataInfo list(TGuideSpec tGuideSpec)
    {
        startPage();
        List<TGuideSpec> list = tGuideSpecService.selectTGuideSpecList(tGuideSpec);
        return getDataTable(list);
    }

    /**
     * 导出导则规范列表
     */
    @PreAuthorize("@ss.hasPermi('dard:dard:export')")
    @Log(title = "导则规范", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TGuideSpec tGuideSpec)
    {
        List<TGuideSpec> list = tGuideSpecService.selectTGuideSpecList(tGuideSpec);
        ExcelUtil<TGuideSpec> util = new ExcelUtil<TGuideSpec>(TGuideSpec.class);
        util.exportExcel(response, list, "导则规范数据");
    }

    /**
     * 获取导则规范详细信息
     */
    @PreAuthorize("@ss.hasPermi('dard:dard:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tGuideSpecService.selectTGuideSpecById(id));
    }

    /**
     * 新增导则规范
     */
    @PreAuthorize("@ss.hasPermi('dard:dard:add')")
    @Log(title = "导则规范", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TGuideSpec tGuideSpec)
    {
        tGuideSpec.setCreateBy(getUsername());
        tGuideSpec.setUpdateBy(getUsername());
        return toAjax(tGuideSpecService.insertTGuideSpec(tGuideSpec));
    }

    /**
     * 修改导则规范
     */
    @PreAuthorize("@ss.hasPermi('dard:dard:edit')")
    @Log(title = "导则规范", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TGuideSpec tGuideSpec)
    {
        tGuideSpec.setUpdateBy(getUsername());
        return toAjax(tGuideSpecService.updateTGuideSpec(tGuideSpec));
    }

    /**
     * 删除导则规范
     */
    @PreAuthorize("@ss.hasPermi('dard:dard:remove')")
    @Log(title = "导则规范", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tGuideSpecService.deleteTGuideSpecByIds(ids));
    }
}
