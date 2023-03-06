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

/**
 * 通知发布对象 t_release
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Data
public class TRelease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 通知标题 */
    @Excel(name = "通知标题")
    private String notiTitle;

    /** 通知类型 */
    @Excel(name = "通知类型")
    private String notiType;

    /** 通知发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通知发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date notiReleaseDate;

    /** 通知描述 */
    @Excel(name = "通知描述")
    private String notiDesc;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "发布结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> notiReleaseDates;

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
            .append("notiTitle", getNotiTitle())
            .append("notiType", getNotiType())
            .append("notiReleaseDate", getNotiReleaseDate())
            .append("notiDesc", getNotiDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
