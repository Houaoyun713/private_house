package com.ruoyi.projec.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projec.domain.TPaper;
import com.ruoyi.projec.mapper.TPaperMapper;
import com.ruoyi.projec.service.ITPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 论文Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class TPaperServiceImpl implements ITPaperService
{
    @Resource
    private TPaperMapper tPaperMapper;

    /**
     * 查询论文
     * 
     * @param id 论文主键
     * @return 论文
     */
    @Override
    public TPaper selectTPaperById(Long id)
    {
        return tPaperMapper.selectTPaperById(id);
    }

    /**
     * 查询论文列表
     * 
     * @param tPaper 论文
     * @return 论文
     */
    @Override
    public List<TPaper> selectTPaperList(TPaper tPaper)
    {
        if (tPaper.getDateOfPublics() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tPaper.getDateOfPublics().get(0));
            String endDate = dateFormat.format(tPaper.getDateOfPublics().get(1));
            tPaper.setStrDate(strDate);
            tPaper.setEndDate(endDate);
        }
        return tPaperMapper.selectTPaperList(tPaper);
    }

    /**
     * 新增论文
     * 
     * @param tPaper 论文
     * @return 结果
     */
    @Override
    public int insertTPaper(TPaper tPaper)
    {
        tPaper.setCreateTime(DateUtils.getNowDate());
        return tPaperMapper.insertTPaper(tPaper);
    }

    /**
     * 修改论文
     * 
     * @param tPaper 论文
     * @return 结果
     */
    @Override
    public int updateTPaper(TPaper tPaper)
    {
        tPaper.setUpdateTime(DateUtils.getNowDate());
        return tPaperMapper.updateTPaper(tPaper);
    }

    /**
     * 批量删除论文
     * 
     * @param ids 需要删除的论文主键
     * @return 结果
     */
    @Override
    public int deleteTPaperByIds(Long[] ids)
    {
        return tPaperMapper.deleteTPaperByIds(ids);
    }

    /**
     * 删除论文信息
     * 
     * @param id 论文主键
     * @return 结果
     */
    @Override
    public int deleteTPaperById(Long id)
    {
        return tPaperMapper.deleteTPaperById(id);
    }
}
