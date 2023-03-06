package com.ruoyi.acce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.acce.domain.TProjectMaterials;
import com.ruoyi.acce.service.ITProjectMaterialsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目验收材料Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/acce/acce")
public class TProjectMaterialsController extends BaseController
{
    @Autowired
    private ITProjectMaterialsService tProjectMaterialsService;

    /**
     * 查询项目验收材料列表
     */
    @PreAuthorize("@ss.hasPermi('acce:acce:list')")
    @GetMapping("/list")
    public TableDataInfo list(TProjectMaterials tProjectMaterials)
    {
        startPage();
        List<TProjectMaterials> list = tProjectMaterialsService.selectTProjectMaterialsList(tProjectMaterials);
        return getDataTable(list);
    }

    /**
     * 导出项目验收材料列表
     */
    @PreAuthorize("@ss.hasPermi('acce:acce:export')")
    @Log(title = "项目验收材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProjectMaterials tProjectMaterials)
    {
        List<TProjectMaterials> list = tProjectMaterialsService.selectTProjectMaterialsList(tProjectMaterials);
        ExcelUtil<TProjectMaterials> util = new ExcelUtil<TProjectMaterials>(TProjectMaterials.class);
        util.exportExcel(response, list, "项目验收材料数据");
    }

    /**
     * 获取项目验收材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('acce:acce:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tProjectMaterialsService.selectTProjectMaterialsById(id));
    }

    /**
     * 新增项目验收材料
     */
    @PreAuthorize("@ss.hasPermi('acce:acce:add')")
    @Log(title = "项目验收材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProjectMaterials tProjectMaterials)
    {
        tProjectMaterials.setCreateBy(getUsername());
        tProjectMaterials.setUpdateBy(getUsername());
        return toAjax(tProjectMaterialsService.insertTProjectMaterials(tProjectMaterials));
    }

    /**
     * 修改项目验收材料
     */
    @PreAuthorize("@ss.hasPermi('acce:acce:edit')")
    @Log(title = "项目验收材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProjectMaterials tProjectMaterials)
    {
        tProjectMaterials.setUpdateBy(getUsername());
        return toAjax(tProjectMaterialsService.updateTProjectMaterials(tProjectMaterials));
    }

    /**
     * 删除项目验收材料
     */
    @PreAuthorize("@ss.hasPermi('acce:acce:remove')")
    @Log(title = "项目验收材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProjectMaterialsService.deleteTProjectMaterialsByIds(ids));
    }
}
