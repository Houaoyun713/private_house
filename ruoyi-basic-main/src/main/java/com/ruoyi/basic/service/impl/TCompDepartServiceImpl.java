package com.ruoyi.basic.service.impl;

import java.util.List;

import com.ruoyi.basic.domain.TCompDepart;
import com.ruoyi.basic.mapper.TCompDepartMapper;
import com.ruoyi.basic.service.ITCompDepartService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 主管部门Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@Service
public class TCompDepartServiceImpl implements ITCompDepartService
{
    @Autowired
    private TCompDepartMapper tCompDepartMapper;

    /**
     * 查询主管部门
     * 
     * @param id 主管部门主键
     * @return 主管部门
     */
    @Override
    public TCompDepart selectTCompDepartById(Long id)
    {
        return tCompDepartMapper.selectTCompDepartById(id);
    }

    /**
     * 查询主管部门列表
     * 
     * @param tCompDepart 主管部门
     * @return 主管部门
     */
    @Override
    public List<TCompDepart> selectTCompDepartList(TCompDepart tCompDepart)
    {
        return tCompDepartMapper.selectTCompDepartList(tCompDepart);
    }

    /**
     * 新增主管部门
     * 
     * @param tCompDepart 主管部门
     * @return 结果
     */
    @Override
    public int insertTCompDepart(TCompDepart tCompDepart)
    {
        tCompDepart.setCreateTime(DateUtils.getNowDate());
        return tCompDepartMapper.insertTCompDepart(tCompDepart);
    }

    /**
     * 修改主管部门
     * 
     * @param tCompDepart 主管部门
     * @return 结果
     */
    @Override
    public int updateTCompDepart(TCompDepart tCompDepart)
    {
        tCompDepart.setUpdateTime(DateUtils.getNowDate());
        return tCompDepartMapper.updateTCompDepart(tCompDepart);
    }

    /**
     * 批量删除主管部门
     * 
     * @param ids 需要删除的主管部门主键
     * @return 结果
     */
    @Override
    public int deleteTCompDepartByIds(Long[] ids)
    {
        return tCompDepartMapper.deleteTCompDepartByIds(ids);
    }

    /**
     * 删除主管部门信息
     * 
     * @param id 主管部门主键
     * @return 结果
     */
    @Override
    public int deleteTCompDepartById(Long id)
    {
        return tCompDepartMapper.deleteTCompDepartById(id);
    }
}
