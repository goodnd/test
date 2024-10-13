package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户积分管理对象 sm_user_credit
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public class UserCredit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userAccount;

    /** 所属小区地址 */
    @Excel(name = "所属小区地址")
    private String cellAddress;

    /** 积分余额 */
    @Excel(name = "积分余额")
    private String points;

    /** 兑换奖品 */
    @Excel(name = "兑换奖品")
    private String prize;

    /** 奖品状态 */
    @Excel(name = "奖品状态")
    private String prizeStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserAccount(String userAccount) 
    {
        this.userAccount = userAccount;
    }

    public String getUserAccount() 
    {
        return userAccount;
    }
    public void setCellAddress(String cellAddress) 
    {
        this.cellAddress = cellAddress;
    }

    public String getCellAddress() 
    {
        return cellAddress;
    }
    public void setPoints(String points) 
    {
        this.points = points;
    }

    public String getPoints() 
    {
        return points;
    }
    public void setPrize(String prize) 
    {
        this.prize = prize;
    }

    public String getPrize() 
    {
        return prize;
    }
    public void setPrizeStatus(String prizeStatus) 
    {
        this.prizeStatus = prizeStatus;
    }

    public String getPrizeStatus() 
    {
        return prizeStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userAccount", getUserAccount())
            .append("cellAddress", getCellAddress())
            .append("points", getPoints())
            .append("prize", getPrize())
            .append("prizeStatus", getPrizeStatus())
            .append("createBy", getCreateBy())
            .toString();
    }
}
