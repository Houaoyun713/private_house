package com.ruoyi.annrel.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.annrel.domain.TReferMater;
import com.ruoyi.annrel.service.ITReferMaterService;
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
 * 参考材料Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/refma/refma")
public class TReferMaterController extends BaseController
{
    @Resource
    private ITReferMaterService tReferMaterService;

    /**
     * 查询参考材料列表
     */
    @PreAuthorize("@ss.hasPermi('refma:refma:list')")
    @GetMapping("/list")
    public TableDataInfo list(TReferMater tReferMater)
    {
        startPage();
        List<TReferMater> list = tReferMaterService.selectTReferMaterList(tReferMater);
        return getDataTable(list);
    }

    /**
     * 导出参考材料列表
     */
    @PreAuthorize("@ss.hasPermi('refma:refma:export')")
    @Log(title = "参考材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TReferMater tReferMater)
    {
        List<TReferMater> list = tReferMaterService.selectTReferMaterList(tReferMater);
        ExcelUtil<TReferMater> util = new ExcelUtil<TReferMater>(TReferMater.class);
        util.exportExcel(response, list, "参考材料数据");
    }

    /**
     * 获取参考材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('refma:refma:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tReferMaterService.selectTReferMaterById(id));
    }

    /**
     * 新增参考材料
     */
    @PreAuthorize("@ss.hasPermi('refma:refma:add')")
    @Log(title = "参考材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TReferMater tReferMater)
    {
        tReferMater.setCreateBy(getUsername());
        tReferMater.setUpdateBy(getUsername());
        return toAjax(tReferMaterService.insertTReferMater(tReferMater));
    }

    /**
     * 修改参考材料
     */
    @PreAuthorize("@ss.hasPermi('refma:refma:edit')")
    @Log(title = "参考材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TReferMater tReferMater)
    {
        tReferMater.setUpdateBy(getUsername());
        return toAjax(tReferMaterService.updateTReferMater(tReferMater));
    }

    /**
     * 删除参考材料
     */
    @PreAuthorize("@ss.hasPermi('refma:refma:remove')")
    @Log(title = "参考材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tReferMaterService.deleteTReferMaterByIds(ids));
    }
}
