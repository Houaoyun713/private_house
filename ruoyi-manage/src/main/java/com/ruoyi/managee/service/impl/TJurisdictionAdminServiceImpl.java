package com.ruoyi.managee.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.managee.domain.TJurisdictionAdmin;
import com.ruoyi.managee.mapper.TJurisdictionAdminMapper;
import com.ruoyi.managee.service.ITJurisdictionAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TJurisdictionAdminServiceImpl implements ITJurisdictionAdminService
{
    @Resource
    private TJurisdictionAdminMapper tJurisdictionAdminMapper;

    /**
     * 查询权限管理
     * 
     * @param id 权限管理主键
     * @return 权限管理
     */
    @Override
    public TJurisdictionAdmin selectTJurisdictionAdminById(Long id)
    {
        return tJurisdictionAdminMapper.selectTJurisdictionAdminById(id);
    }

    /**
     * 查询权限管理列表
     * 
     * @param tJurisdictionAdmin 权限管理
     * @return 权限管理
     */
    @Override
    public List<TJurisdictionAdmin> selectTJurisdictionAdminList(TJurisdictionAdmin tJurisdictionAdmin)
    {
        return tJurisdictionAdminMapper.selectTJurisdictionAdminList(tJurisdictionAdmin);
    }

    /**
     * 新增权限管理
     * 
     * @param tJurisdictionAdmin 权限管理
     * @return 结果
     */
    @Override
    public int insertTJurisdictionAdmin(TJurisdictionAdmin tJurisdictionAdmin)
    {
        tJurisdictionAdmin.setCreateTime(DateUtils.getNowDate());
        return tJurisdictionAdminMapper.insertTJurisdictionAdmin(tJurisdictionAdmin);
    }

    /**
     * 修改权限管理
     * 
     * @param tJurisdictionAdmin 权限管理
     * @return 结果
     */
    @Override
    public int updateTJurisdictionAdmin(TJurisdictionAdmin tJurisdictionAdmin)
    {
        tJurisdictionAdmin.setUpdateTime(DateUtils.getNowDate());
        return tJurisdictionAdminMapper.updateTJurisdictionAdmin(tJurisdictionAdmin);
    }

    /**
     * 批量删除权限管理
     * 
     * @param ids 需要删除的权限管理主键
     * @return 结果
     */
    @Override
    public int deleteTJurisdictionAdminByIds(Long[] ids)
    {
        return tJurisdictionAdminMapper.deleteTJurisdictionAdminByIds(ids);
    }

    /**
     * 删除权限管理信息
     * 
     * @param id 权限管理主键
     * @return 结果
     */
    @Override
    public int deleteTJurisdictionAdminById(Long id)
    {
        return tJurisdictionAdminMapper.deleteTJurisdictionAdminById(id);
    }
}
