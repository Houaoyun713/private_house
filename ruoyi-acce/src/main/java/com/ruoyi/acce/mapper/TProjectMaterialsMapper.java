package com.ruoyi.acce.mapper;

import java.util.List;
import com.ruoyi.acce.domain.TProjectMaterials;

/**
 * 项目验收材料Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface TProjectMaterialsMapper 
{
    /**
     * 查询项目验收材料
     * 
     * @param id 项目验收材料主键
     * @return 项目验收材料
     */
    public TProjectMaterials selectTProjectMaterialsById(Long id);

    /**
     * 查询项目验收材料列表
     * 
     * @param tProjectMaterials 项目验收材料
     * @return 项目验收材料集合
     */
    public List<TProjectMaterials> selectTProjectMaterialsList(TProjectMaterials tProjectMaterials);

    /**
     * 新增项目验收材料
     * 
     * @param tProjectMaterials 项目验收材料
     * @return 结果
     */
    public int insertTProjectMaterials(TProjectMaterials tProjectMaterials);

    /**
     * 修改项目验收材料
     * 
     * @param tProjectMaterials 项目验收材料
     * @return 结果
     */
    public int updateTProjectMaterials(TProjectMaterials tProjectMaterials);

    /**
     * 删除项目验收材料
     * 
     * @param id 项目验收材料主键
     * @return 结果
     */
    public int deleteTProjectMaterialsById(Long id);

    /**
     * 批量删除项目验收材料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectMaterialsByIds(Long[] ids);
}
