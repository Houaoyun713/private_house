package com.ruoyi.projec.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projec.domain.TGuideSpec;
import com.ruoyi.projec.mapper.TGuideSpecMapper;
import com.ruoyi.projec.service.ITGuideSpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 导则规范Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TGuideSpecServiceImpl implements ITGuideSpecService
{
    @Resource
    private TGuideSpecMapper tGuideSpecMapper;

    /**
     * 查询导则规范
     * 
     * @param id 导则规范主键
     * @return 导则规范
     */
    @Override
    public TGuideSpec selectTGuideSpecById(Long id)
    {
        return tGuideSpecMapper.selectTGuideSpecById(id);
    }

    /**
     * 查询导则规范列表
     * 
     * @param tGuideSpec 导则规范
     * @return 导则规范
     */
    @Override
    public List<TGuideSpec> selectTGuideSpecList(TGuideSpec tGuideSpec)
    {
        return tGuideSpecMapper.selectTGuideSpecList(tGuideSpec);
    }

    /**
     * 新增导则规范
     * 
     * @param tGuideSpec 导则规范
     * @return 结果
     */
    @Override
    public int insertTGuideSpec(TGuideSpec tGuideSpec)
    {
        tGuideSpec.setCreateTime(DateUtils.getNowDate());
        return tGuideSpecMapper.insertTGuideSpec(tGuideSpec);
    }

    /**
     * 修改导则规范
     * 
     * @param tGuideSpec 导则规范
     * @return 结果
     */
    @Override
    public int updateTGuideSpec(TGuideSpec tGuideSpec)
    {
        tGuideSpec.setUpdateTime(DateUtils.getNowDate());
        return tGuideSpecMapper.updateTGuideSpec(tGuideSpec);
    }

    /**
     * 批量删除导则规范
     * 
     * @param ids 需要删除的导则规范主键
     * @return 结果
     */
    @Override
    public int deleteTGuideSpecByIds(Long[] ids)
    {
        return tGuideSpecMapper.deleteTGuideSpecByIds(ids);
    }

    /**
     * 删除导则规范信息
     * 
     * @param id 导则规范主键
     * @return 结果
     */
    @Override
    public int deleteTGuideSpecById(Long id)
    {
        return tGuideSpecMapper.deleteTGuideSpecById(id);
    }
}
