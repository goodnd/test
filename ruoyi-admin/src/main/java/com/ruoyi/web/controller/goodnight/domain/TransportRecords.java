package com.ruoyi.web.controller.goodnight.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾运输记录对象 sm_transport_records
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public class TransportRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 运输编号 */
    @Excel(name = "运输编号")
    private String transportId;

    /** 运输日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "运输日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transportDay;

    /** 负责站点 */
    @Excel(name = "负责站点")
    private String transportSites;

    private List<String> transportSitesList;

    /** 目标回收站 */
    @Excel(name = "目标回收站")
    private String transportStation;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String transportStartTime;

    /** 运输司机 */
    @Excel(name = "运输司机")
    private String driver;

    /** 车辆车牌号 */
    @Excel(name = "车辆车牌号")
    private String vehiclePlateNumber;

    /** 运输状态 */
    @Excel(name = "运输状态")
    private String transportStatus;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String transportFinishTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTransportId(String transportId) 
    {
        this.transportId = transportId;
    }

    public String getTransportId() 
    {
        return transportId;
    }
    public void setTransportDay(Date transportDay) 
    {
        this.transportDay = transportDay;
    }

    public Date getTransportDay() 
    {
        return transportDay;
    }
    public void setTransportSites(String transportSites)
    {
        this.transportSites = transportSites;
    }

    public String getTransportSites()
    {

        return transportSites;
    }
    public void setTransportStation(String transportStation) 
    {
        this.transportStation = transportStation;
    }

    public String getTransportStation() 
    {
        return transportStation;
    }
    public void setTransportStartTime(String transportStartTime)
    {
        this.transportStartTime = transportStartTime;
    }

    public String getTransportStartTime()
    {
        return transportStartTime;
    }
    public void setDriver(String driver) 
    {
        this.driver = driver;
    }

    public String getDriver() 
    {
        return driver;
    }
    public void setVehiclePlateNumber(String vehiclePlateNumber) 
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehiclePlateNumber() 
    {
        return vehiclePlateNumber;
    }
    public void setTransportStatus(String transportStatus) 
    {
        this.transportStatus = transportStatus;
    }

    public String getTransportStatus() 
    {
        return transportStatus;
    }
    public void setTransportFinishTime(String transportFinishTime)
    {
        this.transportFinishTime = transportFinishTime;
    }

    public String getTransportFinishTime()
    {
        return transportFinishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("transportId", getTransportId())
            .append("transportDay", getTransportDay())
            .append("transportSites", getTransportSites())
            .append("transportStation", getTransportStation())
            .append("transportStartTime", getTransportStartTime())
            .append("driver", getDriver())
            .append("vehiclePlateNumber", getVehiclePlateNumber())
            .append("transportStatus", getTransportStatus())
            .append("transportFinishTime", getTransportFinishTime())
            .toString();
    }
}
