package com.ruoyi.projec.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.projec.domain.TKeyTechn;
import com.ruoyi.projec.service.ITKeyTechnService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 关键技术Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/projec/projec")
public class TKeyTechnController extends BaseController
{
    @Resource
    private ITKeyTechnService tKeyTechnService;

    /**
     * 查询关键技术列表
     */
    @PreAuthorize("@ss.hasPermi('projec:projec:list')")
    @GetMapping("/list")
    public TableDataInfo list(TKeyTechn tKeyTechn)
    {
        startPage();
        List<TKeyTechn> list = tKeyTechnService.selectTKeyTechnList(tKeyTechn);
        return getDataTable(list);
    }

    /**
     * 导出关键技术列表
     */
    @PreAuthorize("@ss.hasPermi('projec:projec:export')")
    @Log(title = "关键技术", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TKeyTechn tKeyTechn)
    {
        List<TKeyTechn> list = tKeyTechnService.selectTKeyTechnList(tKeyTechn);
        ExcelUtil<TKeyTechn> util = new ExcelUtil<TKeyTechn>(TKeyTechn.class);
        util.exportExcel(response, list, "关键技术数据");
    }

    /**
     * 获取关键技术详细信息
     */
    @PreAuthorize("@ss.hasPermi('projec:projec:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tKeyTechnService.selectTKeyTechnById(id));
    }

    /**
     * 新增关键技术
     */
    @PreAuthorize("@ss.hasPermi('projec:projec:add')")
    @Log(title = "关键技术", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TKeyTechn tKeyTechn)
    {
        tKeyTechn.setCreateBy(getUsername());
        tKeyTechn.setUpdateBy(getUsername());
        return toAjax(tKeyTechnService.insertTKeyTechn(tKeyTechn));
    }

    /**
     * 修改关键技术
     */
    @PreAuthorize("@ss.hasPermi('projec:projec:edit')")
    @Log(title = "关键技术", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TKeyTechn tKeyTechn)
    {
        tKeyTechn.setUpdateBy(getUsername());
        return toAjax(tKeyTechnService.updateTKeyTechn(tKeyTechn));
    }

    /**
     * 删除关键技术
     */
    @PreAuthorize("@ss.hasPermi('projec:projec:remove')")
    @Log(title = "关键技术", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tKeyTechnService.deleteTKeyTechnByIds(ids));
    }
}
