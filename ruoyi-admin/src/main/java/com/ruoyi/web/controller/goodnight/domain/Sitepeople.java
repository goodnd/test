package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾站点人员对象 sm_sitepeople
 * 
 * @author goodnight
 * @date 2024-10-21
 */
public class Sitepeople extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 人员编号 */
    @Excel(name = "人员编号")
    private String sitePeopleId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String sitePeopleName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String homeAddress;

    /** 岗位 */
    @Excel(name = "岗位")
    private String job;

    /** 工作地区 */
    @Excel(name = "工作地区")
    private String responsibleArea;

    /** 工作站点 */
    @Excel(name = "工作站点")
    private String responsibleSite;

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
    public void setSitePeopleId(String sitePeopleId) 
    {
        this.sitePeopleId = sitePeopleId;
    }

    public String getSitePeopleId() 
    {
        return sitePeopleId;
    }
    public void setSitePeopleName(String sitePeopleName) 
    {
        this.sitePeopleName = sitePeopleName;
    }

    public String getSitePeopleName() 
    {
        return sitePeopleName;
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
    public void setResponsibleArea(String responsibleArea) 
    {
        this.responsibleArea = responsibleArea;
    }

    public String getResponsibleArea() 
    {
        return responsibleArea;
    }
    public void setResponsibleSite(String responsibleSite) 
    {
        this.responsibleSite = responsibleSite;
    }

    public String getResponsibleSite() 
    {
        return responsibleSite;
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
            .append("sitePeopleId", getSitePeopleId())
            .append("sitePeopleName", getSitePeopleName())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("homeAddress", getHomeAddress())
            .append("job", getJob())
            .append("responsibleArea", getResponsibleArea())
            .append("responsibleSite", getResponsibleSite())
            .append("notes", getNotes())
            .toString();
    }
}
