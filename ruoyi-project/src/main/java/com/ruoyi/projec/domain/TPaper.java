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
 * 论文对象 t_paper
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TPaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String number;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 论文/专著名称 */
    @Excel(name = "论文/专著名称")
    private String paperName;

    /** 作者单位 */
    @Excel(name = "作者单位")
    private String authorUnit;

    /** 期刊名称 */
    @Excel(name = "期刊名称")
    private String journalName;

    /** 出版社 */
    @Excel(name = "出版社")
    private String press;

    /** 发表/出版时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发表/出版时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfPublic;

    /** 卷/期/页码 */
    @Excel(name = "卷/期/页码")
    private String issue;

    /** 影响因子 */
    @Excel(name = "影响因子")
    private String influenceFactor;

    /** 所属课题/子课题 */
    @Excel(name = "所属课题/子课题")
    private String subjects;

    @Transient
    @Excel(name = "文件名称")
    private String fileNames;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    /** 驳回理由 */
    @Excel(name = "驳回理由")
    private String statusReason;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    @Excel(name = "发布结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private List<Date> dateOfPublics;

    @Transient
    @Excel(name = "源文件下载地址")
    private String strDate;

    @Transient
    @Excel(name = "源文件下载地址")
    private String endDate;

}
