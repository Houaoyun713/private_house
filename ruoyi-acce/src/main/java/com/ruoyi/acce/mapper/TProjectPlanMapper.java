package com.ruoyi.acce.mapper;

import com.ruoyi.acce.domain.TProjectPlan;

import java.util.List;

/**
 * 项目实施方案Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface TProjectPlanMapper 
{
    /**
     * 查询项目实施方案
     * 
     * @param id 项目实施方案主键
     * @return 项目实施方案
     */
    public TProjectPlan selectTProjectPlanById(Long id);

    /**
     * 查询项目实施方案列表
     * 
     * @param tProjectPlan 项目实施方案
     * @return 项目实施方案集合
     */
    public List<TProjectPlan> selectTProjectPlanList(TProjectPlan tProjectPlan);

    /**
     * 新增项目实施方案
     * 
     * @param tProjectPlan 项目实施方案
     * @return 结果
     */
    public int insertTProjectPlan(TProjectPlan tProjectPlan);

    /**
     * 修改项目实施方案
     * 
     * @param tProjectPlan 项目实施方案
     * @return 结果
     */
    public int updateTProjectPlan(TProjectPlan tProjectPlan);

    /**
     * 删除项目实施方案
     * 
     * @param id 项目实施方案主键
     * @return 结果
     */
    public int deleteTProjectPlanById(Long id);

    /**
     * 批量删除项目实施方案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectPlanByIds(Long[] ids);
}
