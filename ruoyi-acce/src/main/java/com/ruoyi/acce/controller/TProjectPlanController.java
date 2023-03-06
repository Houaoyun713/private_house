package com.ruoyi.acce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.acce.domain.TProjectPlan;
import com.ruoyi.acce.service.ITProjectPlanService;
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
 * 项目实施方案Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/prog/prog")
public class TProjectPlanController extends BaseController
{
    @Autowired
    private ITProjectPlanService tProjectPlanService;

    /**
     * 查询项目实施方案列表
     */
    @PreAuthorize("@ss.hasPermi('prog:prog:list')")
    @GetMapping("/list")
    public TableDataInfo list(TProjectPlan tProjectPlan)
    {
        startPage();
        List<TProjectPlan> list = tProjectPlanService.selectTProjectPlanList(tProjectPlan);
        return getDataTable(list);
    }

    /**
     * 导出项目实施方案列表
     */
    @PreAuthorize("@ss.hasPermi('prog:prog:export')")
    @Log(title = "项目实施方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProjectPlan tProjectPlan)
    {
        List<TProjectPlan> list = tProjectPlanService.selectTProjectPlanList(tProjectPlan);
        ExcelUtil<TProjectPlan> util = new ExcelUtil<TProjectPlan>(TProjectPlan.class);
        util.exportExcel(response, list, "项目实施方案数据");
    }

    /**
     * 获取项目实施方案详细信息
     */
    @PreAuthorize("@ss.hasPermi('prog:prog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tProjectPlanService.selectTProjectPlanById(id));
    }

    /**
     * 新增项目实施方案
     */
    @PreAuthorize("@ss.hasPermi('prog:prog:add')")
    @Log(title = "项目实施方案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProjectPlan tProjectPlan)
    {
        tProjectPlan.setCreateBy(getUsername());
        tProjectPlan.setUpdateBy(getUsername());
        return toAjax(tProjectPlanService.insertTProjectPlan(tProjectPlan));
    }

    /**
     * 修改项目实施方案
     */
    @PreAuthorize("@ss.hasPermi('prog:prog:edit')")
    @Log(title = "项目实施方案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProjectPlan tProjectPlan)
    {
        tProjectPlan.setUpdateBy(getUsername());
        return toAjax(tProjectPlanService.updateTProjectPlan(tProjectPlan));
    }

    /**
     * 删除项目实施方案
     */
    @PreAuthorize("@ss.hasPermi('prog:prog:remove')")
    @Log(title = "项目实施方案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProjectPlanService.deleteTProjectPlanByIds(ids));
    }
}
