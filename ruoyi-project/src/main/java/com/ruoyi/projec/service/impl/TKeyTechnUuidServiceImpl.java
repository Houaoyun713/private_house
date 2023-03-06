package com.ruoyi.projec.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projec.domain.TKeyTechnUuid;
import com.ruoyi.projec.mapper.TKeyTechnUuidMapper;
import com.ruoyi.projec.service.ITKeyTechnUuidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 关键技术Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TKeyTechnUuidServiceImpl implements ITKeyTechnUuidService
{
    @Resource
    private TKeyTechnUuidMapper tKeyTechnUuidMapper;

    /**
     * 查询关键技术
     * 
     * @param id 关键技术主键
     * @return 关键技术
     */
    @Override
    public TKeyTechnUuid selectTKeyTechnUuidById(Long id)
    {
        return tKeyTechnUuidMapper.selectTKeyTechnUuidById(id);
    }

    /**
     * 查询关键技术列表
     * 
     * @param tKeyTechn 关键技术
     * @return 关键技术
     */
    @Override
    public List<TKeyTechnUuid> selectTKeyTechnUuidList(TKeyTechnUuid tKeyTechn)
    {
        return tKeyTechnUuidMapper.selectTKeyTechnUuidList(tKeyTechn);
    }

    /**
     * 新增关键技术
     * 
     * @param tKeyTechn 关键技术
     * @return 结果
     */
    @Override
    public int insertTKeyTechnUuid(TKeyTechnUuid tKeyTechn)
    {
        tKeyTechn.setCreateTime(DateUtils.getNowDate());
        return tKeyTechnUuidMapper.insertTKeyTechnUuid(tKeyTechn);
    }

    /**
     * 修改关键技术
     * 
     * @param tKeyTechn 关键技术
     * @return 结果
     */
    @Override
    public int updateTKeyTechnUuid(TKeyTechnUuid tKeyTechn)
    {
        tKeyTechn.setUpdateTime(DateUtils.getNowDate());
        return tKeyTechnUuidMapper.updateTKeyTechnUuid(tKeyTechn);
    }

    /**
     * 批量删除关键技术
     * 
     * @param ids 需要删除的关键技术主键
     * @return 结果
     */
    @Override
    public int deleteTKeyTechnUuidByIds(Long[] ids)
    {
        return tKeyTechnUuidMapper.deleteTKeyTechnUuidByIds(ids);
    }

    /**
     * 删除关键技术信息
     * 
     * @param id 关键技术主键
     * @return 结果
     */
    @Override
    public int deleteTKeyTechnUuidById(Long id)
    {
        return tKeyTechnUuidMapper.deleteTKeyTechnUuidById(id);
    }
}
