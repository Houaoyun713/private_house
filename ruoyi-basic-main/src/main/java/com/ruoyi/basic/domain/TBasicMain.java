package com.ruoyi.basic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司维护对象 t_basic_main
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public class TBasicMain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String corporateName;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCorporateName(String corporateName) 
    {
        this.corporateName = corporateName;
    }

    public String getCorporateName() 
    {
        return corporateName;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("corporateName", getCorporateName())
            .append("remarks", getRemarks())
            .toString();
    }
}
