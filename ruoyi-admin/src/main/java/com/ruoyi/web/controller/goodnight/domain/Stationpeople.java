package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 回收站点人员对象 sm_stationpeople
 * 
 * @author goodnight
 * @date 2024-10-21
 */
public class Stationpeople extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 人员编号 */
    @Excel(name = "人员编号")
    private String stationpeopleId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String homeAddress;

    /** 岗位 */
    @Excel(name = "岗位")
    private String job;

    /** 工作地区 */
    @Excel(name = "工作地区")
    private String area;

    /** 回收站 */
    @Excel(name = "回收站")
    private String station;

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
    public void setStationpeopleId(String stationpeopleId) 
    {
        this.stationpeopleId = stationpeopleId;
    }

    public String getStationpeopleId() 
    {
        return stationpeopleId;
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
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
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
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setStation(String station) 
    {
        this.station = station;
    }

    public String getStation() 
    {
        return station;
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
            .append("stationpeopleId", getStationpeopleId())
            .append("name", getName())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("homeAddress", getHomeAddress())
            .append("job", getJob())
            .append("area", getArea())
            .append("station", getStation())
            .append("notes", getNotes())
            .toString();
    }
}
