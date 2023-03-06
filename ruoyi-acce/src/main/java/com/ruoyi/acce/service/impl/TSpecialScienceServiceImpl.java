package com.ruoyi.acce.service.impl;

import java.util.List;

import com.ruoyi.acce.domain.TSpecialScience;
import com.ruoyi.acce.mapper.TSpecialScienceMapper;
import com.ruoyi.acce.service.ITSpecialScienceService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 科技专报材料Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TSpecialScienceServiceImpl implements ITSpecialScienceService
{
    @Resource
    private TSpecialScienceMapper tSpecialScienceMapper;

    /**
     * 查询科技专报材料
     * 
     * @param id 科技专报材料主键
     * @return 科技专报材料
     */
    @Override
    public TSpecialScience selectTSpecialScienceById(Long id)
    {
        return tSpecialScienceMapper.selectTSpecialScienceById(id);
    }

    /**
     * 查询科技专报材料列表
     * 
     * @param tSpecialScience 科技专报材料
     * @return 科技专报材料
     */
    @Override
    public List<TSpecialScience> selectTSpecialScienceList(TSpecialScience tSpecialScience)
    {
        return tSpecialScienceMapper.selectTSpecialScienceList(tSpecialScience);
    }

    /**
     * 新增科技专报材料
     * 
     * @param tSpecialScience 科技专报材料
     * @return 结果
     */
    @Override
    public int insertTSpecialScience(TSpecialScience tSpecialScience)
    {
        tSpecialScience.setCreateTime(DateUtils.getNowDate());
        tSpecialScience.setUpdateTime(DateUtils.getNowDate());
        return tSpecialScienceMapper.insertTSpecialScience(tSpecialScience);
    }

    /**
     * 修改科技专报材料
     * 
     * @param tSpecialScience 科技专报材料
     * @return 结果
     */
    @Override
    public int updateTSpecialScience(TSpecialScience tSpecialScience)
    {
        tSpecialScience.setUpdateTime(DateUtils.getNowDate());
        return tSpecialScienceMapper.updateTSpecialScience(tSpecialScience);
    }

    /**
     * 批量删除科技专报材料
     * 
     * @param ids 需要删除的科技专报材料主键
     * @return 结果
     */
    @Override
    public int deleteTSpecialScienceByIds(Long[] ids)
    {
        return tSpecialScienceMapper.deleteTSpecialScienceByIds(ids);
    }

    /**
     * 删除科技专报材料信息
     * 
     * @param id 科技专报材料主键
     * @return 结果
     */
    @Override
    public int deleteTSpecialScienceById(Long id)
    {
        return tSpecialScienceMapper.deleteTSpecialScienceById(id);
    }
}
