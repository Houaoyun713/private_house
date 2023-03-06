package com.ruoyi.projec.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projec.domain.TSoftwareCopy;
import com.ruoyi.projec.mapper.TSoftwareCopyMapper;
import com.ruoyi.projec.service.ITSoftwareCopyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 软件著作权Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TSoftwareCopyServiceImpl implements ITSoftwareCopyService
{
    @Resource
    private TSoftwareCopyMapper tSoftwareCopyMapper;

    /**
     * 查询软件著作权
     * 
     * @param id 软件著作权主键
     * @return 软件著作权
     */
    @Override
    public TSoftwareCopy selectTSoftwareCopyById(Long id)
    {
        return tSoftwareCopyMapper.selectTSoftwareCopyById(id);
    }

    /**
     * 查询软件著作权列表
     * 
     * @param tSoftwareCopy 软件著作权
     * @return 软件著作权
     */
    @Override
    public List<TSoftwareCopy> selectTSoftwareCopyList(TSoftwareCopy tSoftwareCopy)
    {
        if (tSoftwareCopy.getDateOfPubs() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tSoftwareCopy.getDateOfPubs().get(0));
            String endDate = dateFormat.format(tSoftwareCopy.getDateOfPubs().get(1));
            tSoftwareCopy.setStrDate(strDate);
            tSoftwareCopy.setEndDate(endDate);
        }
        return tSoftwareCopyMapper.selectTSoftwareCopyList(tSoftwareCopy);
    }

    /**
     * 新增软件著作权
     * 
     * @param tSoftwareCopy 软件著作权
     * @return 结果
     */
    @Override
    public int insertTSoftwareCopy(TSoftwareCopy tSoftwareCopy)
    {
        tSoftwareCopy.setCreateTime(DateUtils.getNowDate());
        return tSoftwareCopyMapper.insertTSoftwareCopy(tSoftwareCopy);
    }

    /**
     * 修改软件著作权
     * 
     * @param tSoftwareCopy 软件著作权
     * @return 结果
     */
    @Override
    public int updateTSoftwareCopy(TSoftwareCopy tSoftwareCopy)
    {
        tSoftwareCopy.setUpdateTime(DateUtils.getNowDate());
        return tSoftwareCopyMapper.updateTSoftwareCopy(tSoftwareCopy);
    }

    /**
     * 批量删除软件著作权
     * 
     * @param ids 需要删除的软件著作权主键
     * @return 结果
     */
    @Override
    public int deleteTSoftwareCopyByIds(Long[] ids)
    {
        return tSoftwareCopyMapper.deleteTSoftwareCopyByIds(ids);
    }

    /**
     * 删除软件著作权信息
     * 
     * @param id 软件著作权主键
     * @return 结果
     */
    @Override
    public int deleteTSoftwareCopyById(Long id)
    {
        return tSoftwareCopyMapper.deleteTSoftwareCopyById(id);
    }
}
