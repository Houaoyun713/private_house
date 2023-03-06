package com.ruoyi.acce.service;

import com.ruoyi.acce.domain.TSpecialScience;

import java.util.List;

/**
 * 科技专报材料Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITSpecialScienceService 
{
    /**
     * 查询科技专报材料
     * 
     * @param id 科技专报材料主键
     * @return 科技专报材料
     */
    public TSpecialScience selectTSpecialScienceById(Long id);

    /**
     * 查询科技专报材料列表
     * 
     * @param tSpecialScience 科技专报材料
     * @return 科技专报材料集合
     */
    public List<TSpecialScience> selectTSpecialScienceList(TSpecialScience tSpecialScience);

    /**
     * 新增科技专报材料
     * 
     * @param tSpecialScience 科技专报材料
     * @return 结果
     */
    public int insertTSpecialScience(TSpecialScience tSpecialScience);

    /**
     * 修改科技专报材料
     * 
     * @param tSpecialScience 科技专报材料
     * @return 结果
     */
    public int updateTSpecialScience(TSpecialScience tSpecialScience);

    /**
     * 批量删除科技专报材料
     * 
     * @param ids 需要删除的科技专报材料主键集合
     * @return 结果
     */
    public int deleteTSpecialScienceByIds(Long[] ids);

    /**
     * 删除科技专报材料信息
     * 
     * @param id 科技专报材料主键
     * @return 结果
     */
    public int deleteTSpecialScienceById(Long id);
}
