package com.ruoyi.projec.mapper;

import com.ruoyi.projec.domain.TPaper;

import java.util.List;

/**
 * 论文Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface TPaperMapper 
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
     * 删除论文
     * 
     * @param id 论文主键
     * @return 结果
     */
    public int deleteTPaperById(Long id);

    /**
     * 批量删除论文
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPaperByIds(Long[] ids);
}
