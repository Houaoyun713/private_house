package com.ruoyi.projec.service;

import com.ruoyi.projec.domain.TGuideSpec;

import java.util.List;

/**
 * 导则规范Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITGuideSpecService 
{
    /**
     * 查询导则规范
     * 
     * @param id 导则规范主键
     * @return 导则规范
     */
    public TGuideSpec selectTGuideSpecById(Long id);

    /**
     * 查询导则规范列表
     * 
     * @param tGuideSpec 导则规范
     * @return 导则规范集合
     */
    public List<TGuideSpec> selectTGuideSpecList(TGuideSpec tGuideSpec);

    /**
     * 新增导则规范
     * 
     * @param tGuideSpec 导则规范
     * @return 结果
     */
    public int insertTGuideSpec(TGuideSpec tGuideSpec);

    /**
     * 修改导则规范
     * 
     * @param tGuideSpec 导则规范
     * @return 结果
     */
    public int updateTGuideSpec(TGuideSpec tGuideSpec);

    /**
     * 批量删除导则规范
     * 
     * @param ids 需要删除的导则规范主键集合
     * @return 结果
     */
    public int deleteTGuideSpecByIds(Long[] ids);

    /**
     * 删除导则规范信息
     * 
     * @param id 导则规范主键
     * @return 结果
     */
    public int deleteTGuideSpecById(Long id);
}
