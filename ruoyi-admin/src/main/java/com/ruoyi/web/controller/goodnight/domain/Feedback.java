package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 反馈与处理对象 sm_feedback
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public class Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long Id;

    /** 反馈编号 */
    @Excel(name = "反馈编号")
    private Long feedbackId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 投诉地址 */
    @Excel(name = "投诉地址")
    private String address;

    /** 处理人 */
    @Excel(name = "处理人")
    private String processor;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String fbStatus;

    /** 反馈结果 */
    @Excel(name = "反馈结果")
    private String fbResult;

    public void setId(Long Id) 
    {
        this.Id = Id;
    }

    public Long getId() 
    {
        return Id;
    }
    public void setFeedbackId(Long feedbackId) 
    {
        this.feedbackId = feedbackId;
    }

    public Long getFeedbackId() 
    {
        return feedbackId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("Id", getId())
            .append("feedbackId", getFeedbackId())
            .append("userId", getUserId())
            .append("address", getAddress())
            .append("processor", getProcessor())
            .append("fbStatus", getFbStatus())
            .append("fbResult", getFbResult())
            .toString();
    }
}
