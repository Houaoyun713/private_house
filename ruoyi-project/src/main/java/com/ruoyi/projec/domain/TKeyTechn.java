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
 * 关键技术对象 t_key_techn
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TKeyTechn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 成果名称 */
    @Excel(name = "成果名称")
    private String achieName;

    /** 关键词 */
    @Excel(name = "关键词")
    private String keyWord;

    /** 上报公司 */
    @Excel(name = "上报公司")
    private String reportComp;

    /** 发表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publicTime;

    /** 拟竣工时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拟竣工时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date propoTime;

    /** 总投资 */
    @Excel(name = "总投资")
    private String totalInve;

    /** 项目主管部门 */
    @Excel(name = "项目主管部门")
    private String projectDepart;

    /** 级别 */
    @Excel(name = "级别")
    private String levels;

    /** 驳回理由 */
    @Excel(name = "驳回理由")
    private String statusReason;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Excel(name = "归属课题")
    private String subjects;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "发布结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> publicTimes;

    @Transient
    @Excel(name = "源文件下载地址")
    private String strDate;

    @Transient
    @Excel(name = "源文件下载地址")
    private String endDate;

}
