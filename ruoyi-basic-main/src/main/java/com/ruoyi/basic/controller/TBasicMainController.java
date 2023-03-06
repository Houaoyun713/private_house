package com.ruoyi.basic.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.basic.domain.TBasicMain;
import com.ruoyi.basic.service.ITBasicMainService;
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
 * 公司维护Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/compa/compa")
public class TBasicMainController extends BaseController
{
    @Resource
    private ITBasicMainService tBasicMainService;

    /**
     * 查询公司维护列表
     */
    @PreAuthorize("@ss.hasPermi('compa:compa:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasicMain tBasicMain)
    {
        startPage();
        List<TBasicMain> list = tBasicMainService.selectTBasicMainList(tBasicMain);
        return getDataTable(list);
    }

    /**
     * 导出公司维护列表
     */
    @PreAuthorize("@ss.hasPermi('compa:compa:export')")
    @Log(title = "公司维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasicMain tBasicMain)
    {
        List<TBasicMain> list = tBasicMainService.selectTBasicMainList(tBasicMain);
        ExcelUtil<TBasicMain> util = new ExcelUtil<TBasicMain>(TBasicMain.class);
        util.exportExcel(response, list, "公司维护数据");
    }

    /**
     * 获取公司维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('compa:compa:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tBasicMainService.selectTBasicMainById(id));
    }

    /**
     * 新增公司维护
     */
    @PreAuthorize("@ss.hasPermi('compa:compa:add')")
    @Log(title = "公司维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasicMain tBasicMain)
    {
        return toAjax(tBasicMainService.insertTBasicMain(tBasicMain));
    }

    /**
     * 修改公司维护
     */
    @PreAuthorize("@ss.hasPermi('compa:compa:edit')")
    @Log(title = "公司维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasicMain tBasicMain)
    {
        return toAjax(tBasicMainService.updateTBasicMain(tBasicMain));
    }

    /**
     * 删除公司维护
     */
    @PreAuthorize("@ss.hasPermi('compa:compa:remove')")
    @Log(title = "公司维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBasicMainService.deleteTBasicMainByIds(ids));
    }
}
