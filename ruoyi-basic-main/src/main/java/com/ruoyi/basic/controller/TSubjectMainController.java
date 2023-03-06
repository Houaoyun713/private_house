package com.ruoyi.basic.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.basic.domain.TSubjectMain;
import com.ruoyi.basic.service.ITSubjectMainService;
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
 * 课题维护Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/sub/sub")
public class TSubjectMainController extends BaseController
{
    @Resource
    private ITSubjectMainService tSubjectMainService;

    /**
     * 查询课题维护列表
     */
    @PreAuthorize("@ss.hasPermi('sub:sub:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSubjectMain tSubjectMain)
    {
        startPage();
        List<TSubjectMain> list = tSubjectMainService.selectTSubjectMainList(tSubjectMain);
        return getDataTable(list);
    }

    /**
     * 导出课题维护列表
     */
    @PreAuthorize("@ss.hasPermi('sub:sub:export')")
    @Log(title = "课题维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSubjectMain tSubjectMain)
    {
        List<TSubjectMain> list = tSubjectMainService.selectTSubjectMainList(tSubjectMain);
        ExcelUtil<TSubjectMain> util = new ExcelUtil<TSubjectMain>(TSubjectMain.class);
        util.exportExcel(response, list, "课题维护数据");
    }

    /**
     * 获取课题维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('sub:sub:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tSubjectMainService.selectTSubjectMainById(id));
    }

    /**
     * 新增课题维护
     */
    @PreAuthorize("@ss.hasPermi('sub:sub:add')")
    @Log(title = "课题维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSubjectMain tSubjectMain)
    {
        return toAjax(tSubjectMainService.insertTSubjectMain(tSubjectMain));
    }

    /**
     * 修改课题维护
     */
    @PreAuthorize("@ss.hasPermi('sub:sub:edit')")
    @Log(title = "课题维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSubjectMain tSubjectMain)
    {
        return toAjax(tSubjectMainService.updateTSubjectMain(tSubjectMain));
    }

    /**
     * 删除课题维护
     */
    @PreAuthorize("@ss.hasPermi('sub:sub:remove')")
    @Log(title = "课题维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSubjectMainService.deleteTSubjectMainByIds(ids));
    }
}
