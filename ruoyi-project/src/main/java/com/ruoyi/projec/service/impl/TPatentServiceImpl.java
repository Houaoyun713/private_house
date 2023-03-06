package com.ruoyi.projec.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projec.domain.TPatent;
import com.ruoyi.projec.mapper.TPatentMapper;
import com.ruoyi.projec.service.ITPatentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 专利Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TPatentServiceImpl implements ITPatentService
{
    @Resource
    private TPatentMapper tPatentMapper;

    /**
     * 查询专利
     * 
     * @param id 专利主键
     * @return 专利
     */
    @Override
    public TPatent selectTPatentById(Long id)
    {
        return tPatentMapper.selectTPatentById(id);
    }

    /**
     * 查询专利列表
     * 
     * @param tPatent 专利
     * @return 专利
     */
    @Override
    public List<TPatent> selectTPatentList(TPatent tPatent)
    {
        if (tPatent.getAuthorizedDates() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tPatent.getAuthorizedDates().get(0));
            String endDate = dateFormat.format(tPatent.getAuthorizedDates().get(1));
            tPatent.setStrDate(strDate);
            tPatent.setEndDate(endDate);
        }
        return tPatentMapper.selectTPatentList(tPatent);
    }

    /**
     * 新增专利
     * 
     * @param tPatent 专利
     * @return 结果
     */
    @Override
    public int insertTPatent(TPatent tPatent)
    {
        tPatent.setCreateTime(DateUtils.getNowDate());
        return tPatentMapper.insertTPatent(tPatent);
    }

    /**
     * 修改专利
     * 
     * @param tPatent 专利
     * @return 结果
     */
    @Override
    public int updateTPatent(TPatent tPatent)
    {
        tPatent.setUpdateTime(DateUtils.getNowDate());
        return tPatentMapper.updateTPatent(tPatent);
    }

    /**
     * 批量删除专利
     * 
     * @param ids 需要删除的专利主键
     * @return 结果
     */
    @Override
    public int deleteTPatentByIds(Long[] ids)
    {
        return tPatentMapper.deleteTPatentByIds(ids);
    }

    /**
     * 删除专利信息
     * 
     * @param id 专利主键
     * @return 结果
     */
    @Override
    public int deleteTPatentById(Long id)
    {
        return tPatentMapper.deleteTPatentById(id);
    }
}
