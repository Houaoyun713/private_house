package com.ruoyi.annrel.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.annrel.domain.TReferMater;
import com.ruoyi.annrel.mapper.TReferMaterMapper;
import com.ruoyi.annrel.service.ITReferMaterService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 参考材料Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TReferMaterServiceImpl implements ITReferMaterService
{
    @Resource
    private TReferMaterMapper tReferMaterMapper;

    /**
     * 查询参考材料
     * 
     * @param id 参考材料主键
     * @return 参考材料
     */
    @Override
    public TReferMater selectTReferMaterById(Long id)
    {
        return tReferMaterMapper.selectTReferMaterById(id);
    }

    /**
     * 查询参考材料列表
     * 
     * @param tReferMater 参考材料
     * @return 参考材料
     */
    @Override
    public List<TReferMater> selectTReferMaterList(TReferMater tReferMater)
    {
        if (tReferMater.getUploadTimes() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tReferMater.getUploadTimes().get(0));
            String endDate = dateFormat.format(tReferMater.getUploadTimes().get(1));
            tReferMater.setStrDate(strDate);
            tReferMater.setEndDate(endDate);
        }
        return tReferMaterMapper.selectTReferMaterList(tReferMater);
    }

    /**
     * 新增参考材料
     * 
     * @param tReferMater 参考材料
     * @return 结果
     */
    @Override
    public int insertTReferMater(TReferMater tReferMater)
    {
        tReferMater.setCreateTime(DateUtils.getNowDate());
        if (StringUtils.isNotEmpty(tReferMater.getUploadName())) {
            tReferMater.setReferMater(tReferMater.getUploadName().substring(16));
        }
        tReferMater.setUpdateTime(DateUtils.getNowDate());
        tReferMater.setUploadTime(DateUtils.getNowDate());
        return tReferMaterMapper.insertTReferMater(tReferMater);
    }

    /**
     * 修改参考材料
     * 
     * @param tReferMater 参考材料
     * @return 结果
     */
    @Override
    public int updateTReferMater(TReferMater tReferMater)
    {
        tReferMater.setUpdateTime(DateUtils.getNowDate());
        return tReferMaterMapper.updateTReferMater(tReferMater);
    }

    /**
     * 批量删除参考材料
     * 
     * @param ids 需要删除的参考材料主键
     * @return 结果
     */
    @Override
    public int deleteTReferMaterByIds(Long[] ids)
    {
        return tReferMaterMapper.deleteTReferMaterByIds(ids);
    }

    /**
     * 删除参考材料信息
     * 
     * @param id 参考材料主键
     * @return 结果
     */
    @Override
    public int deleteTReferMaterById(Long id)
    {
        return tReferMaterMapper.deleteTReferMaterById(id);
    }
}
