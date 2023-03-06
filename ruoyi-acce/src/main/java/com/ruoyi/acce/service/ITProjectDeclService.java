package com.ruoyi.acce.service;

import com.ruoyi.acce.domain.TProjectDecl;

import java.util.List;

/**
 * 项目申报书Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITProjectDeclService 
{
    /**
     * 查询项目申报书
     * 
     * @param id 项目申报书主键
     * @return 项目申报书
     */
    public TProjectDecl selectTProjectDeclById(Long id);

    /**
     * 查询项目申报书列表
     * 
     * @param tProjectDecl 项目申报书
     * @return 项目申报书集合
     */
    public List<TProjectDecl> selectTProjectDeclList(TProjectDecl tProjectDecl);

    /**
     * 新增项目申报书
     * 
     * @param tProjectDecl 项目申报书
     * @return 结果
     */
    public int insertTProjectDecl(TProjectDecl tProjectDecl);

    /**
     * 修改项目申报书
     * 
     * @param tProjectDecl 项目申报书
     * @return 结果
     */
    public int updateTProjectDecl(TProjectDecl tProjectDecl);

    /**
     * 批量删除项目申报书
     * 
     * @param ids 需要删除的项目申报书主键集合
     * @return 结果
     */
    public int deleteTProjectDeclByIds(Long[] ids);

    /**
     * 删除项目申报书信息
     * 
     * @param id 项目申报书主键
     * @return 结果
     */
    public int deleteTProjectDeclById(Long id);
}
