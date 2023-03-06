package com.ruoyi.annrel.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.annrel.domain.THome;
import com.ruoyi.annrel.domain.TRelease;
import com.ruoyi.annrel.mapper.TReleaseMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.projec.domain.TKeyTechn;
import com.ruoyi.projec.domain.TPatent;
import com.ruoyi.projec.mapper.TKeyTechnMapper;
import com.ruoyi.projec.mapper.TPatentMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.annrel.mapper.TAnnoReleaseMapper;
import com.ruoyi.annrel.domain.TAnnoRelease;
import com.ruoyi.annrel.service.ITAnnoReleaseService;

import javax.annotation.Resource;

/**
 * 公告发布Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class TAnnoReleaseServiceImpl implements ITAnnoReleaseService
{
    @Resource
    private TAnnoReleaseMapper tAnnoReleaseMapper;
    @Resource
    private TKeyTechnMapper tKeyTechnMapper;
    @Resource
    private TReleaseMapper tReleaseMapper;
    @Resource
    private TPatentMapper tPatentMapper;


    /**
     * 查询公告发布
     * 
     * @param id 公告发布主键
     * @return 公告发布
     */
    @Override
    public TAnnoRelease selectTAnnoReleaseById(Long id)
    {
        return tAnnoReleaseMapper.selectTAnnoReleaseById(id);
    }

    /**
     * 查询公告发布列表
     * 
     * @param tAnnoRelease 公告发布
     * @return 公告发布
     */
    @Override
    public List<TAnnoRelease> selectTAnnoReleaseList(TAnnoRelease tAnnoRelease)
    {
        if (tAnnoRelease.getReleaDates() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(tAnnoRelease.getReleaDates().get(0));
            String endDate = dateFormat.format(tAnnoRelease.getReleaDates().get(1));
            tAnnoRelease.setStrDate(strDate);
            tAnnoRelease.setEndDate(endDate);
        }
        return tAnnoReleaseMapper.selectTAnnoReleaseList(tAnnoRelease);
    }

    /**
     * 新增公告发布
     * 
     * @param tAnnoRelease 公告发布
     * @return 结果
     */
    @Override
    public int insertTAnnoRelease(TAnnoRelease tAnnoRelease)
    {
        tAnnoRelease.setCreateTime(DateUtils.getNowDate());

//        tAnnoRelease.setSourceName(tAnnoRelease.getOriginalFilenames());
//        tAnnoRelease.setUploadName(tAnnoRelease.getNewFileNames());
//        tAnnoRelease.setSourceFileUrl(tAnnoRelease.getFileNames());
//        tAnnoRelease.setSourceDownloadUrl(tAnnoRelease.getUrls());
        return tAnnoReleaseMapper.insertTAnnoRelease(tAnnoRelease);
    }

    /**
     * 修改公告发布
     * 
     * @param tAnnoRelease 公告发布
     * @return 结果
     */
    @Override
    public int updateTAnnoRelease(TAnnoRelease tAnnoRelease)
    {
        tAnnoRelease.setUpdateTime(DateUtils.getNowDate());
        return tAnnoReleaseMapper.updateTAnnoRelease(tAnnoRelease);
    }

    /**
     * 批量删除公告发布
     * 
     * @param ids 需要删除的公告发布主键
     * @return 结果
     */
    @Override
    public int deleteTAnnoReleaseByIds(Long[] ids)
    {
        return tAnnoReleaseMapper.deleteTAnnoReleaseByIds(ids);
    }

    /**
     * 删除公告发布信息
     * 
     * @param id 公告发布主键
     * @return 结果
     */
    @Override
    public int deleteTAnnoReleaseById(Long id)
    {
        return tAnnoReleaseMapper.deleteTAnnoReleaseById(id);
    }

    @Override
    public THome selectTHomeList() {
        THome tHomeList = new THome();
        List<TKeyTechn> keyTechnList = tKeyTechnMapper.selectTKeyTechnList(null);
        List<TAnnoRelease> annoReleaseList = tAnnoReleaseMapper.selectTAnnoReleaseList(null);
        List<TRelease> releaseList = tReleaseMapper.selectTReleaseList(null);
        List<TPatent> patentList = tPatentMapper.selectTPatentList(null);
        if (!CollectionUtils.isEmpty(keyTechnList)) {
            tHomeList.setKeyTechnList(keyTechnList);
        }
        if (!CollectionUtils.isEmpty(annoReleaseList)) {
            tHomeList.setAnnoReleaseList(annoReleaseList);
        }
        if (!CollectionUtils.isEmpty(releaseList)) {
            tHomeList.setReleaseList(releaseList);
        }
        if (!CollectionUtils.isEmpty(patentList)) {
            tHomeList.setPatentList(patentList);
        }
        return tHomeList;
    }
}
