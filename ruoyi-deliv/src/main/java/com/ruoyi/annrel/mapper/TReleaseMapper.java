package com.ruoyi.annrel.mapper;

import com.ruoyi.annrel.domain.TRelease;

import java.util.List;

/**
 * 通知发布Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface TReleaseMapper 
{
    /**
     * 查询通知发布
     * 
     * @param id 通知发布主键
     * @return 通知发布
     */
    public TRelease selectTReleaseById(Long id);

    /**
     * 查询通知发布列表
     * 
     * @param tRelease 通知发布
     * @return 通知发布集合
     */
    public List<TRelease> selectTReleaseList(TRelease tRelease);

    /**
     * 新增通知发布
     * 
     * @param tRelease 通知发布
     * @return 结果
     */
    public int insertTRelease(TRelease tRelease);

    /**
     * 修改通知发布
     * 
     * @param tRelease 通知发布
     * @return 结果
     */
    public int updateTRelease(TRelease tRelease);

    /**
     * 删除通知发布
     * 
     * @param id 通知发布主键
     * @return 结果
     */
    public int deleteTReleaseById(Long id);

    /**
     * 批量删除通知发布
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTReleaseByIds(Long[] ids);
}
