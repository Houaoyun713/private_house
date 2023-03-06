package com.ruoyi.basic.mapper;

import com.ruoyi.basic.domain.TCompDepart;

import java.util.List;

/**
 * 主管部门Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public interface TCompDepartMapper 
{
    /**
     * 查询主管部门
     * 
     * @param id 主管部门主键
     * @return 主管部门
     */
    public TCompDepart selectTCompDepartById(Long id);

    /**
     * 查询主管部门列表
     * 
     * @param tCompDepart 主管部门
     * @return 主管部门集合
     */
    public List<TCompDepart> selectTCompDepartList(TCompDepart tCompDepart);

    /**
     * 新增主管部门
     * 
     * @param tCompDepart 主管部门
     * @return 结果
     */
    public int insertTCompDepart(TCompDepart tCompDepart);

    /**
     * 修改主管部门
     * 
     * @param tCompDepart 主管部门
     * @return 结果
     */
    public int updateTCompDepart(TCompDepart tCompDepart);

    /**
     * 删除主管部门
     * 
     * @param id 主管部门主键
     * @return 结果
     */
    public int deleteTCompDepartById(Long id);

    /**
     * 批量删除主管部门
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTCompDepartByIds(Long[] ids);
}
