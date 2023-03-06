package com.ruoyi.basic.mapper;

import com.ruoyi.basic.domain.TBasicMain;

import java.util.List;

/**
 * 公司维护Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface TBasicMainMapper 
{
    /**
     * 查询公司维护
     * 
     * @param id 公司维护主键
     * @return 公司维护
     */
    public TBasicMain selectTBasicMainById(Long id);

    /**
     * 查询公司维护列表
     * 
     * @param tBasicMain 公司维护
     * @return 公司维护集合
     */
    public List<TBasicMain> selectTBasicMainList(TBasicMain tBasicMain);

    /**
     * 新增公司维护
     * 
     * @param tBasicMain 公司维护
     * @return 结果
     */
    public int insertTBasicMain(TBasicMain tBasicMain);

    /**
     * 修改公司维护
     * 
     * @param tBasicMain 公司维护
     * @return 结果
     */
    public int updateTBasicMain(TBasicMain tBasicMain);

    /**
     * 删除公司维护
     * 
     * @param id 公司维护主键
     * @return 结果
     */
    public int deleteTBasicMainById(Long id);

    /**
     * 批量删除公司维护
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBasicMainByIds(Long[] ids);
}
