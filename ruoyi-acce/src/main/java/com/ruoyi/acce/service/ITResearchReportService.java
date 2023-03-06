package com.ruoyi.acce.service;

import com.ruoyi.acce.domain.TResearchReport;

import java.util.List;

/**
 * 调研报告材料Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITResearchReportService 
{
    /**
     * 查询调研报告材料
     * 
     * @param id 调研报告材料主键
     * @return 调研报告材料
     */
    public TResearchReport selectTResearchReportById(Long id);

    /**
     * 查询调研报告材料列表
     * 
     * @param tResearchReport 调研报告材料
     * @return 调研报告材料集合
     */
    public List<TResearchReport> selectTResearchReportList(TResearchReport tResearchReport);

    /**
     * 新增调研报告材料
     * 
     * @param tResearchReport 调研报告材料
     * @return 结果
     */
    public int insertTResearchReport(TResearchReport tResearchReport);

    /**
     * 修改调研报告材料
     * 
     * @param tResearchReport 调研报告材料
     * @return 结果
     */
    public int updateTResearchReport(TResearchReport tResearchReport);

    /**
     * 批量删除调研报告材料
     * 
     * @param ids 需要删除的调研报告材料主键集合
     * @return 结果
     */
    public int deleteTResearchReportByIds(Long[] ids);

    /**
     * 删除调研报告材料信息
     * 
     * @param id 调研报告材料主键
     * @return 结果
     */
    public int deleteTResearchReportById(Long id);
}
