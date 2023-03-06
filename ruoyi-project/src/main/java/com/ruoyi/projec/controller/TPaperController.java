package com.ruoyi.projec.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.projec.domain.TPaper;
import com.ruoyi.projec.service.ITPaperService;
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
 * 论文Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/pap/pap")
public class TPaperController extends BaseController
{
    @Resource
    private ITPaperService tPaperService;

    /**
     * 查询论文列表
     */
    @PreAuthorize("@ss.hasPermi('pap:pap:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPaper tPaper)
    {
        startPage();
        List<TPaper> list = tPaperService.selectTPaperList(tPaper);
        return getDataTable(list);
    }

    /**
     * 导出论文列表
     */
    @PreAuthorize("@ss.hasPermi('pap:pap:export')")
    @Log(title = "论文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPaper tPaper)
    {
        List<TPaper> list = tPaperService.selectTPaperList(tPaper);
        ExcelUtil<TPaper> util = new ExcelUtil<TPaper>(TPaper.class);
        util.exportExcel(response, list, "论文数据");
    }

    /**
     * 获取论文详细信息
     */
    @PreAuthorize("@ss.hasPermi('pap:pap:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tPaperService.selectTPaperById(id));
    }

    /**
     * 新增论文
     */
    @PreAuthorize("@ss.hasPermi('pap:pap:add')")
    @Log(title = "论文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPaper tPaper)
    {
        tPaper.setCreateBy(getUsername());
        tPaper.setUpdateBy(getUsername());
        return toAjax(tPaperService.insertTPaper(tPaper));
    }

    /**
     * 修改论文
     */
    @PreAuthorize("@ss.hasPermi('pap:pap:edit')")
    @Log(title = "论文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPaper tPaper)
    {
        tPaper.setUpdateBy(getUsername());
        return toAjax(tPaperService.updateTPaper(tPaper));
    }

    /**
     * 删除论文
     */
    @PreAuthorize("@ss.hasPermi('pap:pap:remove')")
    @Log(title = "论文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tPaperService.deleteTPaperByIds(ids));
    }
}
