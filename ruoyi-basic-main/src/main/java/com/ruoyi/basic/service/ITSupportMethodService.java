package com.ruoyi.basic.service;

import com.ruoyi.basic.domain.TSupportMethod;

import java.util.List;

/**
 * 支持方式Service接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface ITSupportMethodService 
{
    /**
     * 查询支持方式
     * 
     * @param id 支持方式主键
     * @return 支持方式
     */
    public TSupportMethod selectTSupportMethodById(Long id);

    /**
     * 查询支持方式列表
     * 
     * @param tSupportMethod 支持方式
     * @return 支持方式集合
     */
    public List<TSupportMethod> selectTSupportMethodList(TSupportMethod tSupportMethod);

    /**
     * 新增支持方式
     * 
     * @param tSupportMethod 支持方式
     * @return 结果
     */
    public int insertTSupportMethod(TSupportMethod tSupportMethod);

    /**
     * 修改支持方式
     * 
     * @param tSupportMethod 支持方式
     * @return 结果
     */
    public int updateTSupportMethod(TSupportMethod tSupportMethod);

    /**
     * 批量删除支持方式
     * 
     * @param ids 需要删除的支持方式主键集合
     * @return 结果
     */
    public int deleteTSupportMethodByIds(Long[] ids);

    /**
     * 删除支持方式信息
     * 
     * @param id 支持方式主键
     * @return 结果
     */
    public int deleteTSupportMethodById(Long id);
}
