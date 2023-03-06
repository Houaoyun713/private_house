package com.ruoyi.acce.domain;

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
 * 项目申报书对象 t_project_decl
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TProjectDecl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 编制单位 */
    @Excel(name = "编制单位")
    private String preparedBy;

    /** 文件标题 */
    @Excel(name = "文件标题")
    private String documentTitle;

    /** 文件号 */
    @Excel(name = "文件号")
    private String documentNo;

    /** 发文日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发文日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfIssue;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "发文日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> dateOfIssues;

    @Transient
    @Excel(name = "源文件下载地址")
    private String strDate;

    @Transient
    @Excel(name = "源文件下载地址")
    private String endDate;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileType", getFileType())
            .append("preparedBy", getPreparedBy())
            .append("documentTitle", getDocumentTitle())
            .append("documentNo", getDocumentNo())
            .append("dateOfIssue", getDateOfIssue())
            .append("remarks", getRemarks())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
