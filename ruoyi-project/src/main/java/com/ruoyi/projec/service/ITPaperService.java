package com.ruoyi.projec.service;

import com.ruoyi.projec.domain.TPaper;

import java.util.List;

/**
 * 论文Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITPaperService 
{
    /**
     * 查询论文
     * 
     * @param id 论文主键
     * @return 论文
     */
    public TPaper selectTPaperById(Long id);

    /**
     * 查询论文列表
     * 
     * @param tPaper 论文
     * @return 论文集合
     */
    public List<TPaper> selectTPaperList(TPaper tPaper);

    /**
     * 新增论文
     * 
     * @param tPaper 论文
     * @return 结果
     */
    public int insertTPaper(TPaper tPaper);

    /**
     * 修改论文
     * 
     * @param tPaper 论文
     * @return 结果
     */
    public int updateTPaper(TPaper tPaper);

    /**
     * 批量删除论文
     * 
     * @param ids 需要删除的论文主键集合
     * @return 结果
     */
    public int deleteTPaperByIds(Long[] ids);

    /**
     * 删除论文信息
     * 
     * @param id 论文主键
     * @return 结果
     */
    public int deleteTPaperById(Long id);
}
