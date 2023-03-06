package com.ruoyi.basic.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.basic.domain.TSupportMethod;
import com.ruoyi.basic.service.ITSupportMethodService;
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
 * 支持方式Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/mode/mode")
public class TSupportMethodController extends BaseController
{
    @Resource
    private ITSupportMethodService tSupportMethodService;

    /**
     * 查询支持方式列表
     */
    @PreAuthorize("@ss.hasPermi('mode:mode:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSupportMethod tSupportMethod)
    {
        startPage();
        List<TSupportMethod> list = tSupportMethodService.selectTSupportMethodList(tSupportMethod);
        return getDataTable(list);
    }

    /**
     * 导出支持方式列表
     */
    @PreAuthorize("@ss.hasPermi('mode:mode:export')")
    @Log(title = "支持方式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSupportMethod tSupportMethod)
    {
        List<TSupportMethod> list = tSupportMethodService.selectTSupportMethodList(tSupportMethod);
        ExcelUtil<TSupportMethod> util = new ExcelUtil<TSupportMethod>(TSupportMethod.class);
        util.exportExcel(response, list, "支持方式数据");
    }

    /**
     * 获取支持方式详细信息
     */
    @PreAuthorize("@ss.hasPermi('mode:mode:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tSupportMethodService.selectTSupportMethodById(id));
    }

    /**
     * 新增支持方式
     */
    @PreAuthorize("@ss.hasPermi('mode:mode:add')")
    @Log(title = "支持方式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSupportMethod tSupportMethod)
    {
        return toAjax(tSupportMethodService.insertTSupportMethod(tSupportMethod));
    }

    /**
     * 修改支持方式
     */
    @PreAuthorize("@ss.hasPermi('mode:mode:edit')")
    @Log(title = "支持方式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSupportMethod tSupportMethod)
    {
        return toAjax(tSupportMethodService.updateTSupportMethod(tSupportMethod));
    }

    /**
     * 删除支持方式
     */
    @PreAuthorize("@ss.hasPermi('mode:mode:remove')")
    @Log(title = "支持方式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSupportMethodService.deleteTSupportMethodByIds(ids));
    }
}
