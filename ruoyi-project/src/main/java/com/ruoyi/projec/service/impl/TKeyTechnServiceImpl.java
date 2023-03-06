package com.ruoyi.projec.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.projec.mapper.TKeyTechnMapper;
import com.ruoyi.projec.domain.TKeyTechn;
import com.ruoyi.projec.service.ITKeyTechnService;

import javax.annotation.Resource;

/**
 * 关键技术Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TKeyTechnServiceImpl implements ITKeyTechnService 
{
    @Resource
    private TKeyTechnMapper tKeyTechnMapper;

    /**
     * 查询关键技术
     * 
     * @param id 关键技术主键
     * @return 关键技术
     */
    @Override
    public TKeyTechn selectTKeyTechnById(Long id)
    {
        return tKeyTechnMapper.selectTKeyTechnById(id);
    }

    /**
     * 查询关键技术列表
     * 
     * @param tKeyTechn 关键技术
     * @return 关键技术
     */
    @Override
    public List<TKeyTechn> selectTKeyTechnList(TKeyTechn tKeyTechn)
    {
        if (tKeyTechn.getPublicTimes() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tKeyTechn.getPublicTimes().get(0));
            String endDate = dateFormat.format(tKeyTechn.getPublicTimes().get(1));
            tKeyTechn.setStrDate(strDate);
            tKeyTechn.setEndDate(endDate);
        }
        return tKeyTechnMapper.selectTKeyTechnList(tKeyTechn);
    }

    /**
     * 新增关键技术
     * 
     * @param tKeyTechn 关键技术
     * @return 结果
     */
    @Override
    public int insertTKeyTechn(TKeyTechn tKeyTechn)
    {
        tKeyTechn.setCreateTime(DateUtils.getNowDate());
        return tKeyTechnMapper.insertTKeyTechn(tKeyTechn);
    }

    /**
     * 修改关键技术
     * 
     * @param tKeyTechn 关键技术
     * @return 结果
     */
    @Override
    public int updateTKeyTechn(TKeyTechn tKeyTechn)
    {
        tKeyTechn.setUpdateTime(DateUtils.getNowDate());
        return tKeyTechnMapper.updateTKeyTechn(tKeyTechn);
    }

    /**
     * 批量删除关键技术
     * 
     * @param ids 需要删除的关键技术主键
     * @return 结果
     */
    @Override
    public int deleteTKeyTechnByIds(Long[] ids)
    {
        return tKeyTechnMapper.deleteTKeyTechnByIds(ids);
    }

    /**
     * 删除关键技术信息
     * 
     * @param id 关键技术主键
     * @return 结果
     */
    @Override
    public int deleteTKeyTechnById(Long id)
    {
        return tKeyTechnMapper.deleteTKeyTechnById(id);
    }
}
