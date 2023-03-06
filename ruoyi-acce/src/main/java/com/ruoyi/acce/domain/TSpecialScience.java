package com.ruoyi.acce.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Transient;

/**
 * 科技专报材料对象 t_special_science
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TSpecialScience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 报送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submissionTime;

    /** 专报名称 */
    @Excel(name = "专报名称")
    private String nameOfReport;

    /** 报出单位 */
    @Excel(name = "报出单位")
    private String reportingUnit;

    /** 报送单位 */
    @Excel(name = "报送单位")
    private String submitUnit;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 归属课题 */
    @Excel(name = "归属课题")
    private String subject;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSubmissionTime(Date submissionTime) 
    {
        this.submissionTime = submissionTime;
    }

    public Date getSubmissionTime() 
    {
        return submissionTime;
    }
    public void setNameOfReport(String nameOfReport) 
    {
        this.nameOfReport = nameOfReport;
    }

    public String getNameOfReport() 
    {
        return nameOfReport;
    }
    public void setReportingUnit(String reportingUnit) 
    {
        this.reportingUnit = reportingUnit;
    }

    public String getReportingUnit() 
    {
        return reportingUnit;
    }
    public void setSubmitUnit(String submitUnit) 
    {
        this.submitUnit = submitUnit;
    }

    public String getSubmitUnit() 
    {
        return submitUnit;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    public String getSubject() 
    {
        return subject;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("submissionTime", getSubmissionTime())
            .append("nameOfReport", getNameOfReport())
            .append("reportingUnit", getReportingUnit())
            .append("submitUnit", getSubmitUnit())
            .append("status", getStatus())
            .append("subject", getSubject())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
