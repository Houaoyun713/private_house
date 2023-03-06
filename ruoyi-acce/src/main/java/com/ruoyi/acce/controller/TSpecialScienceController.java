package com.ruoyi.acce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.acce.domain.TSpecialScience;
import com.ruoyi.acce.service.ITSpecialScienceService;
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
 * 科技专报材料Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/spec/spec")
public class TSpecialScienceController extends BaseController
{
    @Autowired
    private ITSpecialScienceService tSpecialScienceService;

    /**
     * 查询科技专报材料列表
     */
    @PreAuthorize("@ss.hasPermi('spec:spec:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSpecialScience tSpecialScience)
    {
        startPage();
        List<TSpecialScience> list = tSpecialScienceService.selectTSpecialScienceList(tSpecialScience);
        return getDataTable(list);
    }

    /**
     * 导出科技专报材料列表
     */
    @PreAuthorize("@ss.hasPermi('spec:spec:export')")
    @Log(title = "科技专报材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSpecialScience tSpecialScience)
    {
        List<TSpecialScience> list = tSpecialScienceService.selectTSpecialScienceList(tSpecialScience);
        ExcelUtil<TSpecialScience> util = new ExcelUtil<TSpecialScience>(TSpecialScience.class);
        util.exportExcel(response, list, "科技专报材料数据");
    }

    /**
     * 获取科技专报材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('spec:spec:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tSpecialScienceService.selectTSpecialScienceById(id));
    }

    /**
     * 新增科技专报材料
     */
    @PreAuthorize("@ss.hasPermi('spec:spec:add')")
    @Log(title = "科技专报材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSpecialScience tSpecialScience)
    {
        tSpecialScience.setCreateBy(getUsername());
        tSpecialScience.setUpdateBy(getUsername());
        return toAjax(tSpecialScienceService.insertTSpecialScience(tSpecialScience));
    }

    /**
     * 修改科技专报材料
     */
    @PreAuthorize("@ss.hasPermi('spec:spec:edit')")
    @Log(title = "科技专报材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSpecialScience tSpecialScience)
    {
        tSpecialScience.setUpdateBy(getUsername());
        return toAjax(tSpecialScienceService.updateTSpecialScience(tSpecialScience));
    }

    /**
     * 删除科技专报材料
     */
    @PreAuthorize("@ss.hasPermi('spec:spec:remove')")
    @Log(title = "科技专报材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSpecialScienceService.deleteTSpecialScienceByIds(ids));
    }
}
