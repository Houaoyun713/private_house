package com.ruoyi.projec.service;

import com.ruoyi.projec.domain.TSoftwareCopy;

import java.util.List;

/**
 * 软件著作权Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ITSoftwareCopyService 
{
    /**
     * 查询软件著作权
     * 
     * @param id 软件著作权主键
     * @return 软件著作权
     */
    public TSoftwareCopy selectTSoftwareCopyById(Long id);

    /**
     * 查询软件著作权列表
     * 
     * @param tSoftwareCopy 软件著作权
     * @return 软件著作权集合
     */
    public List<TSoftwareCopy> selectTSoftwareCopyList(TSoftwareCopy tSoftwareCopy);

    /**
     * 新增软件著作权
     * 
     * @param tSoftwareCopy 软件著作权
     * @return 结果
     */
    public int insertTSoftwareCopy(TSoftwareCopy tSoftwareCopy);

    /**
     * 修改软件著作权
     * 
     * @param tSoftwareCopy 软件著作权
     * @return 结果
     */
    public int updateTSoftwareCopy(TSoftwareCopy tSoftwareCopy);

    /**
     * 批量删除软件著作权
     * 
     * @param ids 需要删除的软件著作权主键集合
     * @return 结果
     */
    public int deleteTSoftwareCopyByIds(Long[] ids);

    /**
     * 删除软件著作权信息
     * 
     * @param id 软件著作权主键
     * @return 结果
     */
    public int deleteTSoftwareCopyById(Long id);
}
