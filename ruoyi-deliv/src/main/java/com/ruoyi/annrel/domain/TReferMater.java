package com.ruoyi.annrel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

/**
 * 参考材料对象 t_refer_mater
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Data
public class TReferMater extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 参考材料 */
    @Excel(name = "参考材料")
    private String referMater;

    /** 文件说明 */
    @Excel(name = "文件说明")
    private String fileDesc;

    /** 上传方 */
    @Excel(name = "上传方")
    private String uploaderName;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> uploadTimes;

    @Transient
    @Excel(name = "发布开始时间")
    private String strDate;

    @Transient
    @Excel(name = "发布结束时间")
    private String endDate;


}
