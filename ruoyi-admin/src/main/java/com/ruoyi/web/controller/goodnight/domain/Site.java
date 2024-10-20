package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾站点管理对象 sm_site
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public class Site extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String siteId;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String siteName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 所属小区 */
    @Excel(name = "所属小区")
    private String plot;

    /** 所属回收站 */
    @Excel(name = "所属回收站")
    private String sitRecyclingStation;

    /** 可回收垃圾容纳量 */
    @Excel(name = "可回收垃圾容纳量")
    private String recyclableCapacity;

    /** 厨余垃圾容纳量 */
    @Excel(name = "厨余垃圾容纳量")
    private String kitchenWasteCapacity;

    /** 有害垃圾容纳量 */
    @Excel(name = "有害垃圾容纳量")
    private String hazardousWasteCapacity;

    /** 其他垃圾容纳量 */
    @Excel(name = "其他垃圾容纳量")
    private String otherWasteCapacity;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSiteId(String siteId) 
    {
        this.siteId = siteId;
    }

    public String getSiteId() 
    {
        return siteId;
    }
    public void setSiteName(String siteName) 
    {
        this.siteName = siteName;
    }

    public String getSiteName() 
    {
        return siteName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPlot(String plot) 
    {
        this.plot = plot;
    }

    public String getPlot() 
    {
        return plot;
    }
    public void setSitRecyclingStation(String sitRecyclingStation) 
    {
        this.sitRecyclingStation = sitRecyclingStation;
    }

    public String getSitRecyclingStation() 
    {
        return sitRecyclingStation;
    }
    public void setRecyclableCapacity(String recyclableCapacity) 
    {
        this.recyclableCapacity = recyclableCapacity;
    }

    public String getRecyclableCapacity() 
    {
        return recyclableCapacity;
    }
    public void setKitchenWasteCapacity(String kitchenWasteCapacity) 
    {
        this.kitchenWasteCapacity = kitchenWasteCapacity;
    }

    public String getKitchenWasteCapacity() 
    {
        return kitchenWasteCapacity;
    }
    public void setHazardousWasteCapacity(String hazardousWasteCapacity) 
    {
        this.hazardousWasteCapacity = hazardousWasteCapacity;
    }

    public String getHazardousWasteCapacity() 
    {
        return hazardousWasteCapacity;
    }
    public void setOtherWasteCapacity(String otherWasteCapacity) 
    {
        this.otherWasteCapacity = otherWasteCapacity;
    }

    public String getOtherWasteCapacity() 
    {
        return otherWasteCapacity;
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
            .append("siteId", getSiteId())
            .append("siteName", getSiteName())
            .append("address", getAddress())
            .append("plot", getPlot())
            .append("sitRecyclingStation", getSitRecyclingStation())
            .append("recyclableCapacity", getRecyclableCapacity())
            .append("kitchenWasteCapacity", getKitchenWasteCapacity())
            .append("hazardousWasteCapacity", getHazardousWasteCapacity())
            .append("otherWasteCapacity", getOtherWasteCapacity())
            .append("notes", getNotes())
            .toString();
    }
}
