package com.ruoyi.basic.service.impl;

import java.util.List;

import com.ruoyi.basic.domain.TSubjectMain;
import com.ruoyi.basic.mapper.TSubjectMainMapper;
import com.ruoyi.basic.service.ITSubjectMainService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 课题维护Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TSubjectMainServiceImpl implements ITSubjectMainService
{
    @Resource
    private TSubjectMainMapper tSubjectMainMapper;

    /**
     * 查询课题维护
     * 
     * @param id 课题维护主键
     * @return 课题维护
     */
    @Override
    public TSubjectMain selectTSubjectMainById(Long id)
    {
        return tSubjectMainMapper.selectTSubjectMainById(id);
    }

    /**
     * 查询课题维护列表
     * 
     * @param tSubjectMain 课题维护
     * @return 课题维护
     */
    @Override
    public List<TSubjectMain> selectTSubjectMainList(TSubjectMain tSubjectMain)
    {
        return tSubjectMainMapper.selectTSubjectMainList(tSubjectMain);
    }

    /**
     * 新增课题维护
     * 
     * @param tSubjectMain 课题维护
     * @return 结果
     */
    @Override
    public int insertTSubjectMain(TSubjectMain tSubjectMain)
    {
        tSubjectMain.setCreateTime(DateUtils.getNowDate());
        return tSubjectMainMapper.insertTSubjectMain(tSubjectMain);
    }

    /**
     * 修改课题维护
     * 
     * @param tSubjectMain 课题维护
     * @return 结果
     */
    @Override
    public int updateTSubjectMain(TSubjectMain tSubjectMain)
    {
        tSubjectMain.setUpdateTime(DateUtils.getNowDate());
        return tSubjectMainMapper.updateTSubjectMain(tSubjectMain);
    }

    /**
     * 批量删除课题维护
     * 
     * @param ids 需要删除的课题维护主键
     * @return 结果
     */
    @Override
    public int deleteTSubjectMainByIds(Long[] ids)
    {
        return tSubjectMainMapper.deleteTSubjectMainByIds(ids);
    }

    /**
     * 删除课题维护信息
     * 
     * @param id 课题维护主键
     * @return 结果
     */
    @Override
    public int deleteTSubjectMainById(Long id)
    {
        return tSubjectMainMapper.deleteTSubjectMainById(id);
    }
}
