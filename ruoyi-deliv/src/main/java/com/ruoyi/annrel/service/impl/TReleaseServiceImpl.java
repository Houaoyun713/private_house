package com.ruoyi.annrel.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.annrel.domain.TRelease;
import com.ruoyi.annrel.mapper.TReleaseMapper;
import com.ruoyi.annrel.service.ITReleaseService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 通知发布Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TReleaseServiceImpl implements ITReleaseService
{
    @Resource
    private TReleaseMapper tReleaseMapper;

    /**
     * 查询通知发布
     * 
     * @param id 通知发布主键
     * @return 通知发布
     */
    @Override
    public TRelease selectTReleaseById(Long id)
    {
        return tReleaseMapper.selectTReleaseById(id);
    }

    /**
     * 查询通知发布列表
     * 
     * @param tRelease 通知发布
     * @return 通知发布
     */
    @Override
    public List<TRelease> selectTReleaseList(TRelease tRelease)
    {
        if (tRelease.getNotiReleaseDates() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tRelease.getNotiReleaseDates().get(0));
            String endDate = dateFormat.format(tRelease.getNotiReleaseDates().get(1));
            tRelease.setStrDate(strDate);
            tRelease.setEndDate(endDate);
        }
        return tReleaseMapper.selectTReleaseList(tRelease);
    }

    /**
     * 新增通知发布
     * 
     * @param tRelease 通知发布
     * @return 结果
     */
    @Override
    public int insertTRelease(TRelease tRelease)
    {
        tRelease.setCreateTime(DateUtils.getNowDate());
        tRelease.setUpdateTime(DateUtils.getNowDate());
        return tReleaseMapper.insertTRelease(tRelease);
    }

    /**
     * 修改通知发布
     * 
     * @param tRelease 通知发布
     * @return 结果
     */
    @Override
    public int updateTRelease(TRelease tRelease)
    {
        tRelease.setUpdateTime(DateUtils.getNowDate());
        return tReleaseMapper.updateTRelease(tRelease);
    }

    /**
     * 批量删除通知发布
     * 
     * @param ids 需要删除的通知发布主键
     * @return 结果
     */
    @Override
    public int deleteTReleaseByIds(Long[] ids)
    {
        return tReleaseMapper.deleteTReleaseByIds(ids);
    }

    /**
     * 删除通知发布信息
     * 
     * @param id 通知发布主键
     * @return 结果
     */
    @Override
    public int deleteTReleaseById(Long id)
    {
        return tReleaseMapper.deleteTReleaseById(id);
    }
}
