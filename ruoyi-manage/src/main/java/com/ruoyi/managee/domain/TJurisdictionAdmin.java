package com.ruoyi.managee.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 权限管理对象 t_jurisdiction_admin
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public class TJurisdictionAdmin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 角色 */
    @Excel(name = "角色")
    private String roles;

    /** 描述 */
    @Excel(name = "描述")
    private String describess;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long isDel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoles(String roles) 
    {
        this.roles = roles;
    }

    public String getRoles() 
    {
        return roles;
    }
    public void setDescribess(String describess) 
    {
        this.describess = describess;
    }

    public String getDescribess() 
    {
        return describess;
    }
    public void setIsDel(Long isDel) 
    {
        this.isDel = isDel;
    }

    public Long getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roles", getRoles())
            .append("describess", getDescribess())
            .append("isDel", getIsDel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
