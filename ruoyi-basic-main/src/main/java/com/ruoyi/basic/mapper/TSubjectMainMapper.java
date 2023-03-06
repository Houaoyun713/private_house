package com.ruoyi.basic.mapper;

import com.ruoyi.basic.domain.TSubjectMain;

import java.util.List;

/**
 * 课题维护Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface TSubjectMainMapper 
{
    /**
     * 查询课题维护
     * 
     * @param id 课题维护主键
     * @return 课题维护
     */
    public TSubjectMain selectTSubjectMainById(Long id);

    /**
     * 查询课题维护列表
     * 
     * @param tSubjectMain 课题维护
     * @return 课题维护集合
     */
    public List<TSubjectMain> selectTSubjectMainList(TSubjectMain tSubjectMain);

    /**
     * 新增课题维护
     * 
     * @param tSubjectMain 课题维护
     * @return 结果
     */
    public int insertTSubjectMain(TSubjectMain tSubjectMain);

    /**
     * 修改课题维护
     * 
     * @param tSubjectMain 课题维护
     * @return 结果
     */
    public int updateTSubjectMain(TSubjectMain tSubjectMain);

    /**
     * 删除课题维护
     * 
     * @param id 课题维护主键
     * @return 结果
     */
    public int deleteTSubjectMainById(Long id);

    /**
     * 批量删除课题维护
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSubjectMainByIds(Long[] ids);
}
