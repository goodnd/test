package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运输人员管理对象 sm_driver
 * 
 * @author goodnight
 * @date 2024-10-22
 */
public class Driver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String driverId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private Long phone;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String homeAddress;

    /** 工作区域 */
    @Excel(name = "工作区域")
    private String workAddress;

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
    public void setDriverId(String driverId) 
    {
        this.driverId = driverId;
    }

    public String getDriverId() 
    {
        return driverId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setPhone(Long phone) 
    {
        this.phone = phone;
    }

    public Long getPhone() 
    {
        return phone;
    }
    public void setHomeAddress(String homeAddress) 
    {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() 
    {
        return homeAddress;
    }
    public void setWorkAddress(String workAddress) 
    {
        this.workAddress = workAddress;
    }

    public String getWorkAddress() 
    {
        return workAddress;
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
            .append("driverId", getDriverId())
            .append("name", getName())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("homeAddress", getHomeAddress())
            .append("workAddress", getWorkAddress())
            .append("notes", getNotes())
            .toString();
    }
}
