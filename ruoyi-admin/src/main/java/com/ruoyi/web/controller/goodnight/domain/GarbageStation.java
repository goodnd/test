package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾回收站管理对象 sm_garbage_station
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public class GarbageStation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 回收站编号 */
    @Excel(name = "回收站编号")
    private String stationId;

    /** 回收站名称 */
    @Excel(name = "回收站名称")
    private String stationName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 站点容纳量 */
    @Excel(name = "站点容纳量")
    private String capacity;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String head;

    /** 站点状态 */
    @Excel(name = "站点状态")
    private String stationStatus;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String phone;

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
    public void setStationId(String stationId) 
    {
        this.stationId = stationId;
    }

    public String getStationId() 
    {
        return stationId;
    }
    public void setStationName(String stationName) 
    {
        this.stationName = stationName;
    }

    public String getStationName() 
    {
        return stationName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setCapacity(String capacity) 
    {
        this.capacity = capacity;
    }

    public String getCapacity() 
    {
        return capacity;
    }
    public void setHead(String head) 
    {
        this.head = head;
    }

    public String getHead() 
    {
        return head;
    }
    public void setStationStatus(String stationStatus) 
    {
        this.stationStatus = stationStatus;
    }

    public String getStationStatus() 
    {
        return stationStatus;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
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
            .append("stationId", getStationId())
            .append("stationName", getStationName())
            .append("address", getAddress())
            .append("capacity", getCapacity())
            .append("head", getHead())
            .append("stationStatus", getStationStatus())
            .append("phone", getPhone())
            .append("notes", getNotes())
            .toString();
    }
}
