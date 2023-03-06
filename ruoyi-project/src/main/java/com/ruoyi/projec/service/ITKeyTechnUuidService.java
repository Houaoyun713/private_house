package com.ruoyi.projec.service;

import com.ruoyi.projec.domain.TKeyTechn;
import com.ruoyi.projec.domain.TKeyTechnUuid;

import java.util.List;

/**
 * 关键技术Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITKeyTechnUuidService
{
    /**
     * 查询关键技术
     * 
     * @param id 关键技术主键
     * @return 关键技术
     */
    public TKeyTechnUuid selectTKeyTechnUuidById(Long id);

    /**
     * 查询关键技术列表
     * 
     * @param tKeyTechn 关键技术
     * @return 关键技术集合
     */
    public List<TKeyTechnUuid> selectTKeyTechnUuidList(TKeyTechnUuid tKeyTechn);

    /**
     * 新增关键技术
     * 
     * @param tKeyTechn 关键技术
     * @return 结果
     */
    public int insertTKeyTechnUuid(TKeyTechnUuid tKeyTechn);

    /**
     * 修改关键技术
     * 
     * @param tKeyTechn 关键技术
     * @return 结果
     */
    public int updateTKeyTechnUuid(TKeyTechnUuid tKeyTechn);

    /**
     * 批量删除关键技术
     * 
     * @param ids 需要删除的关键技术主键集合
     * @return 结果
     */
    public int deleteTKeyTechnUuidByIds(Long[] ids);

    /**
     * 删除关键技术信息
     * 
     * @param id 关键技术主键
     * @return 结果
     */
    public int deleteTKeyTechnUuidById(Long id);
}
