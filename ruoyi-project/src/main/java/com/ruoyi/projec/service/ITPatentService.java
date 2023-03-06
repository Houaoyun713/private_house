package com.ruoyi.projec.service;

import com.ruoyi.projec.domain.TPatent;

import java.util.List;

/**
 * 专利Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITPatentService 
{
    /**
     * 查询专利
     * 
     * @param id 专利主键
     * @return 专利
     */
    public TPatent selectTPatentById(Long id);

    /**
     * 查询专利列表
     * 
     * @param tPatent 专利
     * @return 专利集合
     */
    public List<TPatent> selectTPatentList(TPatent tPatent);

    /**
     * 新增专利
     * 
     * @param tPatent 专利
     * @return 结果
     */
    public int insertTPatent(TPatent tPatent);

    /**
     * 修改专利
     * 
     * @param tPatent 专利
     * @return 结果
     */
    public int updateTPatent(TPatent tPatent);

    /**
     * 批量删除专利
     * 
     * @param ids 需要删除的专利主键集合
     * @return 结果
     */
    public int deleteTPatentByIds(Long[] ids);

    /**
     * 删除专利信息
     * 
     * @param id 专利主键
     * @return 结果
     */
    public int deleteTPatentById(Long id);
}
