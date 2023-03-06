package com.ruoyi.acce.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.acce.mapper.TProjectMaterialsMapper;
import com.ruoyi.acce.domain.TProjectMaterials;
import com.ruoyi.acce.service.ITProjectMaterialsService;

import javax.annotation.Resource;

/**
 * 项目验收材料Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TProjectMaterialsServiceImpl implements ITProjectMaterialsService 
{
    @Resource
    private TProjectMaterialsMapper tProjectMaterialsMapper;

    /**
     * 查询项目验收材料
     * 
     * @param id 项目验收材料主键
     * @return 项目验收材料
     */
    @Override
    public TProjectMaterials selectTProjectMaterialsById(Long id)
    {
        return tProjectMaterialsMapper.selectTProjectMaterialsById(id);
    }

    /**
     * 查询项目验收材料列表
     * 
     * @param tProjectMaterials 项目验收材料
     * @return 项目验收材料
     */
    @Override
    public List<TProjectMaterials> selectTProjectMaterialsList(TProjectMaterials tProjectMaterials)
    {
        return tProjectMaterialsMapper.selectTProjectMaterialsList(tProjectMaterials);
    }

    /**
     * 新增项目验收材料
     * 
     * @param tProjectMaterials 项目验收材料
     * @return 结果
     */
    @Override
    public int insertTProjectMaterials(TProjectMaterials tProjectMaterials)
    {
        tProjectMaterials.setCreateTime(DateUtils.getNowDate());
        tProjectMaterials.setUpdateTime(DateUtils.getNowDate());
        return tProjectMaterialsMapper.insertTProjectMaterials(tProjectMaterials);
    }

    /**
     * 修改项目验收材料
     * 
     * @param tProjectMaterials 项目验收材料
     * @return 结果
     */
    @Override
    public int updateTProjectMaterials(TProjectMaterials tProjectMaterials)
    {
        tProjectMaterials.setUpdateTime(DateUtils.getNowDate());
        return tProjectMaterialsMapper.updateTProjectMaterials(tProjectMaterials);
    }

    /**
     * 批量删除项目验收材料
     * 
     * @param ids 需要删除的项目验收材料主键
     * @return 结果
     */
    @Override
    public int deleteTProjectMaterialsByIds(Long[] ids)
    {
        return tProjectMaterialsMapper.deleteTProjectMaterialsByIds(ids);
    }

    /**
     * 删除项目验收材料信息
     * 
     * @param id 项目验收材料主键
     * @return 结果
     */
    @Override
    public int deleteTProjectMaterialsById(Long id)
    {
        return tProjectMaterialsMapper.deleteTProjectMaterialsById(id);
    }
}
