package com.ruoyi.basic.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.basic.domain.TCompDepart;
import com.ruoyi.basic.service.ITCompDepartService;
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
 * 主管部门Controller
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/comps/comps")
public class TCompDepartController extends BaseController
{
    @Autowired
    private ITCompDepartService tCompDepartService;

    /**
     * 查询主管部门列表
     */
    @PreAuthorize("@ss.hasPermi('comps:comps:list')")
    @GetMapping("/list")
    public TableDataInfo list(TCompDepart tCompDepart)
    {
        startPage();
        List<TCompDepart> list = tCompDepartService.selectTCompDepartList(tCompDepart);
        return getDataTable(list);
    }

    /**
     * 导出主管部门列表
     */
    @PreAuthorize("@ss.hasPermi('comps:comps:export')")
    @Log(title = "主管部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TCompDepart tCompDepart)
    {
        List<TCompDepart> list = tCompDepartService.selectTCompDepartList(tCompDepart);
        ExcelUtil<TCompDepart> util = new ExcelUtil<TCompDepart>(TCompDepart.class);
        util.exportExcel(response, list, "主管部门数据");
    }

    /**
     * 获取主管部门详细信息
     */
    @PreAuthorize("@ss.hasPermi('comps:comps:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tCompDepartService.selectTCompDepartById(id));
    }

    /**
     * 新增主管部门
     */
    @PreAuthorize("@ss.hasPermi('comps:comps:add')")
    @Log(title = "主管部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TCompDepart tCompDepart)
    {
        return toAjax(tCompDepartService.insertTCompDepart(tCompDepart));
    }

    /**
     * 修改主管部门
     */
    @PreAuthorize("@ss.hasPermi('comps:comps:edit')")
    @Log(title = "主管部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TCompDepart tCompDepart)
    {
        return toAjax(tCompDepartService.updateTCompDepart(tCompDepart));
    }

    /**
     * 删除主管部门
     */
    @PreAuthorize("@ss.hasPermi('comps:comps:remove')")
    @Log(title = "主管部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tCompDepartService.deleteTCompDepartByIds(ids));
    }

}
