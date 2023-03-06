package com.ruoyi.annrel.service;

import java.util.List;
import com.ruoyi.annrel.domain.TAnnoRelease;
import com.ruoyi.annrel.domain.THome;

/**
 * 公告发布Service接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface ITAnnoReleaseService 
{
    /**
     * 查询公告发布
     * 
     * @param id 公告发布主键
     * @return 公告发布
     */
    public TAnnoRelease selectTAnnoReleaseById(Long id);

    /**
     * 查询公告发布列表
     * 
     * @param tAnnoRelease 公告发布
     * @return 公告发布集合
     */
    public List<TAnnoRelease> selectTAnnoReleaseList(TAnnoRelease tAnnoRelease);

    /**
     * 新增公告发布
     * 
     * @param tAnnoRelease 公告发布
     * @return 结果
     */
    public int insertTAnnoRelease(TAnnoRelease tAnnoRelease);

    /**
     * 修改公告发布
     * 
     * @param tAnnoRelease 公告发布
     * @return 结果
     */
    public int updateTAnnoRelease(TAnnoRelease tAnnoRelease);

    /**
     * 批量删除公告发布
     * 
     * @param ids 需要删除的公告发布主键集合
     * @return 结果
     */
    public int deleteTAnnoReleaseByIds(Long[] ids);

    /**
     * 删除公告发布信息
     * 
     * @param id 公告发布主键
     * @return 结果
     */
    public int deleteTAnnoReleaseById(Long id);

    THome selectTHomeList();
}
