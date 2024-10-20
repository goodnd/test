package com.ruoyi.web.controller.goodnight.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 反馈与处理对象 sm_feedback
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public class Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 反馈编号 */
    @Excel(name = "反馈编号")
    private String feedbackId;

    /** 反馈人员 */
    @Excel(name = "反馈人员")
    private String fbUser;

    /** 反馈地址 */
    @Excel(name = "反馈地址")
    private String address;

    /** 反馈问题 */
    @Excel(name = "反馈问题")
    private String problem;

    /** 反馈日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "反馈日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fbTime;

    /** 处理人 */
    @Excel(name = "处理人")
    private String processor;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String fbStatus;

    /** 反馈结果 */
    @Excel(name = "反馈结果")
    private String fbResult;

    /** 完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFeedbackId(String feedbackId) 
    {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackId() 
    {
        return feedbackId;
    }
    public void setFbUser(String fbUser) 
    {
        this.fbUser = fbUser;
    }

    public String getFbUser() 
    {
        return fbUser;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setProblem(String problem) 
    {
        this.problem = problem;
    }

    public String getProblem() 
    {
        return problem;
    }
    public void setFbTime(Date fbTime) 
    {
        this.fbTime = fbTime;
    }

    public Date getFbTime() 
    {
        return fbTime;
    }
    public void setProcessor(String processor) 
    {
        this.processor = processor;
    }

    public String getProcessor() 
    {
        return processor;
    }
    public void setFbStatus(String fbStatus) 
    {
        this.fbStatus = fbStatus;
    }

    public String getFbStatus() 
    {
        return fbStatus;
    }
    public void setFbResult(String fbResult) 
    {
        this.fbResult = fbResult;
    }

    public String getFbResult() 
    {
        return fbResult;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("feedbackId", getFeedbackId())
            .append("fbUser", getFbUser())
            .append("address", getAddress())
            .append("problem", getProblem())
            .append("fbTime", getFbTime())
            .append("processor", getProcessor())
            .append("fbStatus", getFbStatus())
            .append("fbResult", getFbResult())
            .append("finishTime", getFinishTime())
            .toString();
    }
}
