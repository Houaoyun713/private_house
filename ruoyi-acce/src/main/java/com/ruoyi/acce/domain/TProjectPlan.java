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
 * 项目实施方案对象 t_project_plan
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TProjectPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 报告类型 */
    @Excel(name = "报告类型")
    private String reportType;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String corporateName;

    /** 报告文号 */
    @Excel(name = "报告文号")
    private String reportNo;

    /** 报告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportDate;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "报告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> reportDates;

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
            .append("reportType", getReportType())
            .append("corporateName", getCorporateName())
            .append("reportNo", getReportNo())
            .append("reportDate", getReportDate())
            .append("remarks", getRemarks())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
