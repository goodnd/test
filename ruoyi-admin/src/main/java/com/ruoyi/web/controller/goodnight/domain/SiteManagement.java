package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾站点管理对象 sm_site_management
 * 
 * @author goodnight
 * @date 2024-10-04
 */
public class SiteManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号
 */
    private Long id;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("siteName", getSiteName())
            .append("address", getAddress())
            .append("plot", getPlot())
            .append("sitRecyclingStation", getSitRecyclingStation())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
