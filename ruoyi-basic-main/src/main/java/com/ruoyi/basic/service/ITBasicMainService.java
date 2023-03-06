package com.ruoyi.basic.service;

import com.ruoyi.basic.domain.TBasicMain;

import java.util.List;

/**
 * 公司维护Service接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface ITBasicMainService 
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
     * 批量删除公司维护
     * 
     * @param ids 需要删除的公司维护主键集合
     * @return 结果
     */
    public int deleteTBasicMainByIds(Long[] ids);

    /**
     * 删除公司维护信息
     * 
     * @param id 公司维护主键
     * @return 结果
     */
    public int deleteTBasicMainById(Long id);
}
