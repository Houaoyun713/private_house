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
 * 调研报告材料对象 t_research_report
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TResearchReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date times;

    /** 报告名称 */
    @Excel(name = "报告名称")
    private String reportName;

    /** 报告内容简介 */
    @Excel(name = "报告内容简介")
    private String reportContent;

    /** 报告负责人 */
    @Excel(name = "报告负责人")
    private String reportLeader;

    /** 归属课题 */
    @Excel(name = "归属课题")
    private String subjects;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Excel(name = "状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTimes(Date times) 
    {
        this.times = times;
    }

    public Date getTimes() 
    {
        return times;
    }
    public void setReportName(String reportName) 
    {
        this.reportName = reportName;
    }

    public String getReportName() 
    {
        return reportName;
    }
    public void setReportContent(String reportContent) 
    {
        this.reportContent = reportContent;
    }

    public String getReportContent() 
    {
        return reportContent;
    }
    public void setReportLeader(String reportLeader) 
    {
        this.reportLeader = reportLeader;
    }

    public String getReportLeader() 
    {
        return reportLeader;
    }
    public void setSubjects(String subjects) 
    {
        this.subjects = subjects;
    }

    public String getSubjects() 
    {
        return subjects;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("times", getTimes())
            .append("reportName", getReportName())
            .append("reportContent", getReportContent())
            .append("reportLeader", getReportLeader())
            .append("subjects", getSubjects())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
