package com.ruoyi.basic.service.impl;

import java.util.List;

import com.ruoyi.basic.domain.TBasicMain;
import com.ruoyi.basic.mapper.TBasicMainMapper;
import com.ruoyi.basic.service.ITBasicMainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 公司维护Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TBasicMainServiceImpl implements ITBasicMainService
{
    @Resource
    private TBasicMainMapper tBasicMainMapper;

    /**
     * 查询公司维护
     * 
     * @param id 公司维护主键
     * @return 公司维护
     */
    @Override
    public TBasicMain selectTBasicMainById(Long id)
    {
        return tBasicMainMapper.selectTBasicMainById(id);
    }

    /**
     * 查询公司维护列表
     * 
     * @param tBasicMain 公司维护
     * @return 公司维护
     */
    @Override
    public List<TBasicMain> selectTBasicMainList(TBasicMain tBasicMain)
    {
        return tBasicMainMapper.selectTBasicMainList(tBasicMain);
    }

    /**
     * 新增公司维护
     * 
     * @param tBasicMain 公司维护
     * @return 结果
     */
    @Override
    public int insertTBasicMain(TBasicMain tBasicMain)
    {
        return tBasicMainMapper.insertTBasicMain(tBasicMain);
    }

    /**
     * 修改公司维护
     * 
     * @param tBasicMain 公司维护
     * @return 结果
     */
    @Override
    public int updateTBasicMain(TBasicMain tBasicMain)
    {
        return tBasicMainMapper.updateTBasicMain(tBasicMain);
    }

    /**
     * 批量删除公司维护
     * 
     * @param ids 需要删除的公司维护主键
     * @return 结果
     */
    @Override
    public int deleteTBasicMainByIds(Long[] ids)
    {
        return tBasicMainMapper.deleteTBasicMainByIds(ids);
    }

    /**
     * 删除公司维护信息
     * 
     * @param id 公司维护主键
     * @return 结果
     */
    @Override
    public int deleteTBasicMainById(Long id)
    {
        return tBasicMainMapper.deleteTBasicMainById(id);
    }
}
