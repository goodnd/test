package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾回收站管理对象 sm_garbage_station
 * 
 * @author goodnight
 * @date 2024-10-04
 */
public class GarbageStation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 回收站名称 */
    @Excel(name = "回收站名称")
    private String stationName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String head;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String phone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setHead(String head) 
    {
        this.head = head;
    }

    public String getHead() 
    {
        return head;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stationName", getStationName())
            .append("address", getAddress())
            .append("head", getHead())
            .append("phone", getPhone())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
