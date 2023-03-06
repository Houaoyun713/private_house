package com.ruoyi.managee.service;

import com.ruoyi.managee.domain.TJurisdictionAdmin;

import java.util.List;

/**
 * 权限管理Service接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface ITJurisdictionAdminService 
{
    /**
     * 查询权限管理
     * 
     * @param id 权限管理主键
     * @return 权限管理
     */
    public TJurisdictionAdmin selectTJurisdictionAdminById(Long id);

    /**
     * 查询权限管理列表
     * 
     * @param tJurisdictionAdmin 权限管理
     * @return 权限管理集合
     */
    public List<TJurisdictionAdmin> selectTJurisdictionAdminList(TJurisdictionAdmin tJurisdictionAdmin);

    /**
     * 新增权限管理
     * 
     * @param tJurisdictionAdmin 权限管理
     * @return 结果
     */
    public int insertTJurisdictionAdmin(TJurisdictionAdmin tJurisdictionAdmin);

    /**
     * 修改权限管理
     * 
     * @param tJurisdictionAdmin 权限管理
     * @return 结果
     */
    public int updateTJurisdictionAdmin(TJurisdictionAdmin tJurisdictionAdmin);

    /**
     * 批量删除权限管理
     * 
     * @param ids 需要删除的权限管理主键集合
     * @return 结果
     */
    public int deleteTJurisdictionAdminByIds(Long[] ids);

    /**
     * 删除权限管理信息
     * 
     * @param id 权限管理主键
     * @return 结果
     */
    public int deleteTJurisdictionAdminById(Long id);
}
