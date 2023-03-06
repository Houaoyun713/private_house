package com.ruoyi.projec.domain;

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
 * 专利对象 t_patent
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TPatent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String number;

    /** 专利名称 */
    @Excel(name = "专利名称")
    private String patentName;

    /** 专利权人 */
    @Excel(name = "专利权人")
    private String patentee;

    /** 专利发明人 */
    @Excel(name = "专利发明人")
    private String patentInventor;

    /** 授权公告 */
    @Excel(name = "授权公告")
    private String authorization;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "授权公告日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date authorizedDate;

    /** 所属课题 */
    @Excel(name = "所属课题")
    private String subject;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 驳回理由 */
    @Excel(name = "驳回理由")
    private String statusReason;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "授权公告日日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> authorizedDates;

    @Transient
    @Excel(name = "源文件下载地址")
    private String strDate;

    @Transient
    @Excel(name = "源文件下载地址")
    private String endDate;

}
