package com.ruoyi.annrel.service;

import com.ruoyi.annrel.domain.TReferMater;

import java.util.List;

/**
 * 参考材料Service接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface ITReferMaterService 
{
    /**
     * 查询参考材料
     * 
     * @param id 参考材料主键
     * @return 参考材料
     */
    public TReferMater selectTReferMaterById(Long id);

    /**
     * 查询参考材料列表
     * 
     * @param tReferMater 参考材料
     * @return 参考材料集合
     */
    public List<TReferMater> selectTReferMaterList(TReferMater tReferMater);

    /**
     * 新增参考材料
     * 
     * @param tReferMater 参考材料
     * @return 结果
     */
    public int insertTReferMater(TReferMater tReferMater);

    /**
     * 修改参考材料
     * 
     * @param tReferMater 参考材料
     * @return 结果
     */
    public int updateTReferMater(TReferMater tReferMater);

    /**
     * 批量删除参考材料
     * 
     * @param ids 需要删除的参考材料主键集合
     * @return 结果
     */
    public int deleteTReferMaterByIds(Long[] ids);

    /**
     * 删除参考材料信息
     * 
     * @param id 参考材料主键
     * @return 结果
     */
    public int deleteTReferMaterById(Long id);
}
