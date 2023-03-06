package com.ruoyi.managee.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.managee.domain.TJurisdictionAdmin;
import com.ruoyi.managee.service.ITJurisdictionAdminService;
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
 * 权限管理Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/pmage/pmage")
public class TJurisdictionAdminController extends BaseController
{
    @Resource
    private ITJurisdictionAdminService tJurisdictionAdminService;

    /**
     * 查询权限管理列表
     */
    @PreAuthorize("@ss.hasPermi('pmage:pmage:list')")
    @GetMapping("/list")
    public TableDataInfo list(TJurisdictionAdmin tJurisdictionAdmin)
    {
        startPage();
        List<TJurisdictionAdmin> list = tJurisdictionAdminService.selectTJurisdictionAdminList(tJurisdictionAdmin);
        return getDataTable(list);
    }

    /**
     * 导出权限管理列表
     */
    @PreAuthorize("@ss.hasPermi('pmage:pmage:export')")
    @Log(title = "权限管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TJurisdictionAdmin tJurisdictionAdmin)
    {
        List<TJurisdictionAdmin> list = tJurisdictionAdminService.selectTJurisdictionAdminList(tJurisdictionAdmin);
        ExcelUtil<TJurisdictionAdmin> util = new ExcelUtil<TJurisdictionAdmin>(TJurisdictionAdmin.class);
        util.exportExcel(response, list, "权限管理数据");
    }

    /**
     * 获取权限管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('pmage:pmage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tJurisdictionAdminService.selectTJurisdictionAdminById(id));
    }

    /**
     * 新增权限管理
     */
    @PreAuthorize("@ss.hasPermi('pmage:pmage:add')")
    @Log(title = "权限管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TJurisdictionAdmin tJurisdictionAdmin)
    {
        return toAjax(tJurisdictionAdminService.insertTJurisdictionAdmin(tJurisdictionAdmin));
    }

    /**
     * 修改权限管理
     */
    @PreAuthorize("@ss.hasPermi('pmage:pmage:edit')")
    @Log(title = "权限管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TJurisdictionAdmin tJurisdictionAdmin)
    {
        return toAjax(tJurisdictionAdminService.updateTJurisdictionAdmin(tJurisdictionAdmin));
    }

    /**
     * 删除权限管理
     */
    @PreAuthorize("@ss.hasPermi('pmage:pmage:remove')")
    @Log(title = "权限管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tJurisdictionAdminService.deleteTJurisdictionAdminByIds(ids));
    }
}
