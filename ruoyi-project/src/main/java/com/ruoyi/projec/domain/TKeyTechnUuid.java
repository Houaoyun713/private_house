package com.ruoyi.projec.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 关键技术对象 t_key_techn
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Data
public class TKeyTechnUuid extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    @Excel(name = "关键技术表id")
    private Long keyTechnId;

    @Excel(name = "源文件存储名称")
    private String sourceName;

    @Excel(name = "上传后文件名称")
    private String uploadName;

    @Excel(name = "源文件存储ID")
    private String sourceId;

    @Excel(name = "源文件存储路径")
    private String sourceFileUrl;

    @Excel(name = "源文件下载地址")
    private String sourceDownloadUrl;

    @Excel(name = "文件大小")
    private String fileSize;

    @Excel(name = "软件著作权id")
    private Long softwareCopyId;

    @Excel(name = "导则规范id")
    private Long guideSpecId;

    @Excel(name = "论文id")
    private Long paperId;

    @Excel(name = "专利id")
    private Long paterId;

}
