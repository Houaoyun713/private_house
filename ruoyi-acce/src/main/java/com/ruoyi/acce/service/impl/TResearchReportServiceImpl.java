package com.ruoyi.acce.service.impl;

import java.util.List;

import com.ruoyi.acce.domain.TResearchReport;
import com.ruoyi.acce.mapper.TResearchReportMapper;
import com.ruoyi.acce.service.ITResearchReportService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 调研报告材料Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TResearchReportServiceImpl implements ITResearchReportService
{
    @Resource
    private TResearchReportMapper tResearchReportMapper;

    /**
     * 查询调研报告材料
     * 
     * @param id 调研报告材料主键
     * @return 调研报告材料
     */
    @Override
    public TResearchReport selectTResearchReportById(Long id)
    {
        return tResearchReportMapper.selectTResearchReportById(id);
    }

    /**
     * 查询调研报告材料列表
     * 
     * @param tResearchReport 调研报告材料
     * @return 调研报告材料
     */
    @Override
    public List<TResearchReport> selectTResearchReportList(TResearchReport tResearchReport)
    {
        return tResearchReportMapper.selectTResearchReportList(tResearchReport);
    }

    /**
     * 新增调研报告材料
     * 
     * @param tResearchReport 调研报告材料
     * @return 结果
     */
    @Override
    public int insertTResearchReport(TResearchReport tResearchReport)
    {
        tResearchReport.setCreateTime(DateUtils.getNowDate());
        tResearchReport.setUpdateTime(DateUtils.getNowDate());
        return tResearchReportMapper.insertTResearchReport(tResearchReport);
    }

    /**
     * 修改调研报告材料
     * 
     * @param tResearchReport 调研报告材料
     * @return 结果
     */
    @Override
    public int updateTResearchReport(TResearchReport tResearchReport)
    {
        tResearchReport.setUpdateTime(DateUtils.getNowDate());
        return tResearchReportMapper.updateTResearchReport(tResearchReport);
    }

    /**
     * 批量删除调研报告材料
     * 
     * @param ids 需要删除的调研报告材料主键
     * @return 结果
     */
    @Override
    public int deleteTResearchReportByIds(Long[] ids)
    {
        return tResearchReportMapper.deleteTResearchReportByIds(ids);
    }

    /**
     * 删除调研报告材料信息
     * 
     * @param id 调研报告材料主键
     * @return 结果
     */
    @Override
    public int deleteTResearchReportById(Long id)
    {
        return tResearchReportMapper.deleteTResearchReportById(id);
    }
}
