package com.ruoyi.web.controller.goodnight.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾收集记录管理对象 garbage_collection_records
 * 
 * @author goodnight
 * @date 2024-10-17
 */
public class GarbageCollectionRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String collectionId;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String communityName;

    /** 收集数量（桶） */
    @Excel(name = "收集数量", readConverterExp = "桶=")
    private String garbageQuantity;

    /** 收集者 */
    @Excel(name = "收集者")
    private String collectorName;

    /** 收集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectionTime;

    /** 备注消息 */
    @Excel(name = "备注消息")
    private String notes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCollectionId(String collectionId) 
    {
        this.collectionId = collectionId;
    }

    public String getCollectionId() 
    {
        return collectionId;
    }
    public void setCommunityName(String communityName) 
    {
        this.communityName = communityName;
    }

    public String getCommunityName() 
    {
        return communityName;
    }
    public void setGarbageQuantity(String garbageQuantity) 
    {
        this.garbageQuantity = garbageQuantity;
    }

    public String getGarbageQuantity() 
    {
        return garbageQuantity;
    }
    public void setCollectorName(String collectorName) 
    {
        this.collectorName = collectorName;
    }

    public String getCollectorName() 
    {
        return collectorName;
    }
    public void setCollectionTime(Date collectionTime) 
    {
        this.collectionTime = collectionTime;
    }

    public Date getCollectionTime() 
    {
        return collectionTime;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("collectionId", getCollectionId())
            .append("communityName", getCommunityName())
            .append("garbageQuantity", getGarbageQuantity())
            .append("collectorName", getCollectorName())
            .append("collectionTime", getCollectionTime())
            .append("notes", getNotes())
            .toString();
    }
}
