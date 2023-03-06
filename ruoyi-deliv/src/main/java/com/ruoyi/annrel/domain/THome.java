package com.ruoyi.annrel.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.projec.domain.TKeyTechn;
import com.ruoyi.projec.domain.TPatent;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.List;


/**
 * 首页列表
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Data
public class THome extends BaseEntity {

    @Transient
    @Excel(name = "待提交成果物")
    private List<TKeyTechn> keyTechnList;

    @Transient
    @Excel(name = "项目公告")
    private List<TAnnoRelease> annoReleaseList;

    @Transient
    @Excel(name = "项目通知")
    private List<TRelease> releaseList;

    @Transient
    @Excel(name = "成果物上报统计")
    private List<TPatent> patentList;

//    @Transient
//    @Excel(name = "项目支出明细")
//    private List<> originalFilenamess;


}
