package com.ruoyi.acce.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.acce.domain.TProjectPlan;
import com.ruoyi.acce.mapper.TProjectPlanMapper;
import com.ruoyi.acce.service.ITProjectPlanService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 项目实施方案Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TProjectPlanServiceImpl implements ITProjectPlanService
{
    @Resource
    private TProjectPlanMapper tProjectPlanMapper;

    /**
     * 查询项目实施方案
     * 
     * @param id 项目实施方案主键
     * @return 项目实施方案
     */
    @Override
    public TProjectPlan selectTProjectPlanById(Long id)
    {
        return tProjectPlanMapper.selectTProjectPlanById(id);
    }

    /**
     * 查询项目实施方案列表
     * 
     * @param tProjectPlan 项目实施方案
     * @return 项目实施方案
     */
    @Override
    public List<TProjectPlan> selectTProjectPlanList(TProjectPlan tProjectPlan)
    {
        if (tProjectPlan.getReportDates() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tProjectPlan.getReportDates().get(0));
            String endDate = dateFormat.format(tProjectPlan.getReportDates().get(1));
            tProjectPlan.setStrDate(strDate);
            tProjectPlan.setEndDate(endDate);
        }
        return tProjectPlanMapper.selectTProjectPlanList(tProjectPlan);
    }

    /**
     * 新增项目实施方案
     * 
     * @param tProjectPlan 项目实施方案
     * @return 结果
     */
    @Override
    public int insertTProjectPlan(TProjectPlan tProjectPlan)
    {
        tProjectPlan.setCreateTime(DateUtils.getNowDate());
        tProjectPlan.setUpdateTime(DateUtils.getNowDate());
        return tProjectPlanMapper.insertTProjectPlan(tProjectPlan);
    }

    /**
     * 修改项目实施方案
     * 
     * @param tProjectPlan 项目实施方案
     * @return 结果
     */
    @Override
    public int updateTProjectPlan(TProjectPlan tProjectPlan)
    {
        tProjectPlan.setUpdateTime(DateUtils.getNowDate());
        return tProjectPlanMapper.updateTProjectPlan(tProjectPlan);
    }

    /**
     * 批量删除项目实施方案
     * 
     * @param ids 需要删除的项目实施方案主键
     * @return 结果
     */
    @Override
    public int deleteTProjectPlanByIds(Long[] ids)
    {
        return tProjectPlanMapper.deleteTProjectPlanByIds(ids);
    }

    /**
     * 删除项目实施方案信息
     * 
     * @param id 项目实施方案主键
     * @return 结果
     */
    @Override
    public int deleteTProjectPlanById(Long id)
    {
        return tProjectPlanMapper.deleteTProjectPlanById(id);
    }
}
