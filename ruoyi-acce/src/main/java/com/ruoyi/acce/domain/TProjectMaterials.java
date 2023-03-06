package com.ruoyi.acce.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Transient;

/**
 * 项目验收材料对象 t_project_materials
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TProjectMaterials extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialName;

    /** 归属课题 */
    @Excel(name = "归属课题")
    private String subjects;

    /** 填报公司 */
    @Excel(name = "填报公司")
    private String reportingCompany;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private String projectLeader;

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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setSubjects(String subjects) 
    {
        this.subjects = subjects;
    }

    public String getSubjects() 
    {
        return subjects;
    }
    public void setReportingCompany(String reportingCompany) 
    {
        this.reportingCompany = reportingCompany;
    }

    public String getReportingCompany() 
    {
        return reportingCompany;
    }
    public void setProjectLeader(String projectLeader) 
    {
        this.projectLeader = projectLeader;
    }

    public String getProjectLeader() 
    {
        return projectLeader;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("status", getStatus())
            .append("materialName", getMaterialName())
            .append("subjects", getSubjects())
            .append("reportingCompany", getReportingCompany())
            .append("projectLeader", getProjectLeader())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
