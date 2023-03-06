package com.ruoyi.annrel.mapper;

import java.util.List;
import com.ruoyi.annrel.domain.TAnnoRelease;

/**
 * 公告发布Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface TAnnoReleaseMapper 
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
     * 删除公告发布
     * 
     * @param id 公告发布主键
     * @return 结果
     */
    public int deleteTAnnoReleaseById(Long id);

    /**
     * 批量删除公告发布
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTAnnoReleaseByIds(Long[] ids);
}
