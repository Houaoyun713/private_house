package com.ruoyi.projec.domain;

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
 * 软件著作权对象 t_software_copy
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TSoftwareCopy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String number;

    /** 著作权人 */
    @Excel(name = "著作权人")
    private String copyrightOwner;

    /** 软件名称 */
    @Excel(name = "软件名称")
    private String softwareName;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 作者单位 */
    @Excel(name = "作者单位")
    private String authorUnit;

    /** 开发完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开发完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionDate;

    /** 首次发表日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首次发表日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfPub;

    /** 权利取得方式 */
    @Excel(name = "权利取得方式")
    private String rightMethod;

    /** 登记号 */
    @Excel(name = "登记号")
    private String registrationNo;

    /** 证书号 */
    @Excel(name = "证书号")
    private String certificateNo;

    /** 软件代码行数 */
    @Excel(name = "软件代码行数")
    private Long numberOfSoftware;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    /** 驳回理由 */
    @Excel(name = "驳回理由")
    private String statusReason;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> dateOfPubs;

    @Transient
    @Excel(name = "源文件下载地址")
    private String strDate;

    @Transient
    @Excel(name = "源文件下载地址")
    private String endDate;

}
