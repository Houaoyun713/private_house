package com.ruoyi.acce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.acce.domain.TProjectDecl;
import com.ruoyi.acce.service.ITProjectDeclService;
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
 * 项目申报书Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/decl/decl")
public class TProjectDeclController extends BaseController
{
    @Autowired
    private ITProjectDeclService tProjectDeclService;

    /**
     * 查询项目申报书列表
     */
    @PreAuthorize("@ss.hasPermi('decl:decl:list')")
    @GetMapping("/list")
    public TableDataInfo list(TProjectDecl tProjectDecl)
    {
        startPage();
        List<TProjectDecl> list = tProjectDeclService.selectTProjectDeclList(tProjectDecl);
        return getDataTable(list);
    }

    /**
     * 导出项目申报书列表
     */
    @PreAuthorize("@ss.hasPermi('decl:decl:export')")
    @Log(title = "项目申报书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProjectDecl tProjectDecl)
    {
        List<TProjectDecl> list = tProjectDeclService.selectTProjectDeclList(tProjectDecl);
        ExcelUtil<TProjectDecl> util = new ExcelUtil<TProjectDecl>(TProjectDecl.class);
        util.exportExcel(response, list, "项目申报书数据");
    }

    /**
     * 获取项目申报书详细信息
     */
    @PreAuthorize("@ss.hasPermi('decl:decl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tProjectDeclService.selectTProjectDeclById(id));
    }

    /**
     * 新增项目申报书
     */
    @PreAuthorize("@ss.hasPermi('decl:decl:add')")
    @Log(title = "项目申报书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProjectDecl tProjectDecl)
    {
        tProjectDecl.setCreateBy(getUsername());
        tProjectDecl.setUpdateBy(getUsername());
        return toAjax(tProjectDeclService.insertTProjectDecl(tProjectDecl));
    }

    /**
     * 修改项目申报书
     */
    @PreAuthorize("@ss.hasPermi('decl:decl:edit')")
    @Log(title = "项目申报书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProjectDecl tProjectDecl)
    {
        tProjectDecl.setUpdateBy(getUsername());
        return toAjax(tProjectDeclService.updateTProjectDecl(tProjectDecl));
    }

    /**
     * 删除项目申报书
     */
    @PreAuthorize("@ss.hasPermi('decl:decl:remove')")
    @Log(title = "项目申报书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProjectDeclService.deleteTProjectDeclByIds(ids));
    }
}
