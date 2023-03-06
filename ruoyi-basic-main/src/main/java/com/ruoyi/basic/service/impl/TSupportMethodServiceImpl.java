package com.ruoyi.basic.service.impl;

import java.util.List;

import com.ruoyi.basic.domain.TSupportMethod;
import com.ruoyi.basic.mapper.TSupportMethodMapper;
import com.ruoyi.basic.service.ITSupportMethodService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 支持方式Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TSupportMethodServiceImpl implements ITSupportMethodService
{
    @Resource
    private TSupportMethodMapper tSupportMethodMapper;

    /**
     * 查询支持方式
     * 
     * @param id 支持方式主键
     * @return 支持方式
     */
    @Override
    public TSupportMethod selectTSupportMethodById(Long id)
    {
        return tSupportMethodMapper.selectTSupportMethodById(id);
    }

    /**
     * 查询支持方式列表
     * 
     * @param tSupportMethod 支持方式
     * @return 支持方式
     */
    @Override
    public List<TSupportMethod> selectTSupportMethodList(TSupportMethod tSupportMethod)
    {
        return tSupportMethodMapper.selectTSupportMethodList(tSupportMethod);
    }

    /**
     * 新增支持方式
     * 
     * @param tSupportMethod 支持方式
     * @return 结果
     */
    @Override
    public int insertTSupportMethod(TSupportMethod tSupportMethod)
    {
        tSupportMethod.setCreateTime(DateUtils.getNowDate());
        return tSupportMethodMapper.insertTSupportMethod(tSupportMethod);
    }

    /**
     * 修改支持方式
     * 
     * @param tSupportMethod 支持方式
     * @return 结果
     */
    @Override
    public int updateTSupportMethod(TSupportMethod tSupportMethod)
    {
        tSupportMethod.setUpdateTime(DateUtils.getNowDate());
        return tSupportMethodMapper.updateTSupportMethod(tSupportMethod);
    }

    /**
     * 批量删除支持方式
     * 
     * @param ids 需要删除的支持方式主键
     * @return 结果
     */
    @Override
    public int deleteTSupportMethodByIds(Long[] ids)
    {
        return tSupportMethodMapper.deleteTSupportMethodByIds(ids);
    }

    /**
     * 删除支持方式信息
     * 
     * @param id 支持方式主键
     * @return 结果
     */
    @Override
    public int deleteTSupportMethodById(Long id)
    {
        return tSupportMethodMapper.deleteTSupportMethodById(id);
    }
}
