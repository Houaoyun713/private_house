package com.ruoyi.projec.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * 导则规范对象 t_guide_spec
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TGuideSpec extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String number;

    /** 编制单位 */
    @Excel(name = "编制单位")
    private String preparedUnit;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 内容简介 */
    @Excel(name = "内容简介")
    private String contentValidity;

    /** 适用范围 */
    @Excel(name = "适用范围")
    private String scopeApplication;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 技术规范类型 */
    @Excel(name = "技术规范类型")
    private String technicalType;

    /** 发布单位 */
    @Excel(name = "发布单位")
    private String issuedBy;

    /** 编制人员 */
    @Excel(name = "编制人员")
    private String preparedBy;

    /** 归属课题 */
    @Excel(name = "归属课题")
    private String subjects;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 驳回理由 */
    @Excel(name = "驳回理由")
    private String statusReason;

    @Excel(name = "上传后文件名称")
    private String uploadName;

}
