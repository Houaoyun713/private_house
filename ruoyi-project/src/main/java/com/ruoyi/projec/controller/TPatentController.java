package com.ruoyi.projec.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.projec.domain.TPatent;
import com.ruoyi.projec.service.ITPatentService;
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
 * 专利Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/paree/paree")
public class TPatentController extends BaseController
{
    @Resource
    private ITPatentService tPatentService;

    /**
     * 查询专利列表
     */
    @PreAuthorize("@ss.hasPermi('paree:paree:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPatent tPatent)
    {
        startPage();
        List<TPatent> list = tPatentService.selectTPatentList(tPatent);
        return getDataTable(list);
    }

    /**
     * 导出专利列表
     */
    @PreAuthorize("@ss.hasPermi('paree:paree:export')")
    @Log(title = "专利", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPatent tPatent)
    {
        List<TPatent> list = tPatentService.selectTPatentList(tPatent);
        ExcelUtil<TPatent> util = new ExcelUtil<TPatent>(TPatent.class);
        util.exportExcel(response, list, "专利数据");
    }

    /**
     * 获取专利详细信息
     */
    @PreAuthorize("@ss.hasPermi('paree:paree:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tPatentService.selectTPatentById(id));
    }

    /**
     * 新增专利
     */
    @PreAuthorize("@ss.hasPermi('paree:paree:add')")
    @Log(title = "专利", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPatent tPatent)
    {
        tPatent.setCreateBy(getUsername());
        tPatent.setUpdateBy(getUsername());
        return toAjax(tPatentService.insertTPatent(tPatent));
    }

    /**
     * 修改专利
     */
    @PreAuthorize("@ss.hasPermi('paree:paree:edit')")
    @Log(title = "专利", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPatent tPatent)
    {
        tPatent.setUpdateBy(getUsername());
        return toAjax(tPatentService.updateTPatent(tPatent));
    }

    /**
     * 删除专利
     */
    @PreAuthorize("@ss.hasPermi('paree:paree:remove')")
    @Log(title = "专利", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tPatentService.deleteTPatentByIds(ids));
    }
}
