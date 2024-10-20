package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运输车辆对象 sm_vehicle_list
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public class VehicleList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 车辆编号 */
    @Excel(name = "车辆编号")
    private String vehicleId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String vehiclePlateNumber;

    /** 车辆状态 */
    @Excel(name = "车辆状态")
    private String vehicleStatus;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String vehicleType;

    /** 使用人 */
    @Excel(name = "使用人")
    private String driver;

    /** 容纳量 */
    @Excel(name = "容纳量")
    private String vehicleCapacity;

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
    public void setVehicleId(String vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() 
    {
        return vehicleId;
    }
    public void setVehiclePlateNumber(String vehiclePlateNumber) 
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehiclePlateNumber() 
    {
        return vehiclePlateNumber;
    }
    public void setVehicleStatus(String vehicleStatus) 
    {
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleStatus() 
    {
        return vehicleStatus;
    }
    public void setVehicleType(String vehicleType) 
    {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() 
    {
        return vehicleType;
    }
    public void setDriver(String driver) 
    {
        this.driver = driver;
    }

    public String getDriver() 
    {
        return driver;
    }
    public void setVehicleCapacity(String vehicleCapacity) 
    {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getVehicleCapacity() 
    {
        return vehicleCapacity;
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
            .append("vehicleId", getVehicleId())
            .append("vehiclePlateNumber", getVehiclePlateNumber())
            .append("vehicleStatus", getVehicleStatus())
            .append("vehicleType", getVehicleType())
            .append("driver", getDriver())
            .append("vehicleCapacity", getVehicleCapacity())
            .append("notes", getNotes())
            .toString();
    }
}
