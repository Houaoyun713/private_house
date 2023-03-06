package com.ruoyi.acce.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.acce.domain.TProjectDecl;
import com.ruoyi.acce.mapper.TProjectDeclMapper;
import com.ruoyi.acce.service.ITProjectDeclService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 项目申报书Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TProjectDeclServiceImpl implements ITProjectDeclService
{
    @Resource
    private TProjectDeclMapper tProjectDeclMapper;

    /**
     * 查询项目申报书
     * 
     * @param id 项目申报书主键
     * @return 项目申报书
     */
    @Override
    public TProjectDecl selectTProjectDeclById(Long id)
    {
        return tProjectDeclMapper.selectTProjectDeclById(id);
    }

    /**
     * 查询项目申报书列表
     * 
     * @param tProjectDecl 项目申报书
     * @return 项目申报书
     */
    @Override
    public List<TProjectDecl> selectTProjectDeclList(TProjectDecl tProjectDecl)
    {
        if (tProjectDecl.getDateOfIssues() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tProjectDecl.getDateOfIssues().get(0));
            String endDate = dateFormat.format(tProjectDecl.getDateOfIssues().get(1));
            tProjectDecl.setStrDate(strDate);
            tProjectDecl.setEndDate(endDate);
        }
        return tProjectDeclMapper.selectTProjectDeclList(tProjectDecl);
    }

    /**
     * 新增项目申报书
     * 
     * @param tProjectDecl 项目申报书
     * @return 结果
     */
    @Override
    public int insertTProjectDecl(TProjectDecl tProjectDecl)
    {
        tProjectDecl.setCreateTime(DateUtils.getNowDate());
        tProjectDecl.setUpdateTime(DateUtils.getNowDate());
        return tProjectDeclMapper.insertTProjectDecl(tProjectDecl);
    }

    /**
     * 修改项目申报书
     * 
     * @param tProjectDecl 项目申报书
     * @return 结果
     */
    @Override
    public int updateTProjectDecl(TProjectDecl tProjectDecl)
    {
        tProjectDecl.setUpdateTime(DateUtils.getNowDate());
        return tProjectDeclMapper.updateTProjectDecl(tProjectDecl);
    }

    /**
     * 批量删除项目申报书
     * 
     * @param ids 需要删除的项目申报书主键
     * @return 结果
     */
    @Override
    public int deleteTProjectDeclByIds(Long[] ids)
    {
        return tProjectDeclMapper.deleteTProjectDeclByIds(ids);
    }

    /**
     * 删除项目申报书信息
     * 
     * @param id 项目申报书主键
     * @return 结果
     */
    @Override
    public int deleteTProjectDeclById(Long id)
    {
        return tProjectDeclMapper.deleteTProjectDeclById(id);
    }
}
