package com.ruoyi.annrel.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公告发布对象 t_anno_release
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Data
public class TAnnoRelease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 公告名称 */
    @Excel(name = "公告名称")
    private String name;

    /** 通知类型 */
    @Excel(name = "通知类型")
    private String notiType;

    /** 发布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaDate;

    /** 公告描述 */
    @Excel(name = "公告描述")
    private String annDesc;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "发布结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> releaDates;

    @Transient
    @Excel(name = "发布开始时间")
    private String strDate;

    @Transient
    @Excel(name = "发布结束时间")
    private String endDate;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("notiType", getNotiType())
            .append("releaDate", getReleaDate())
            .append("annDesc", getAnnDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
