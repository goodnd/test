package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖品管理对象 sm_prize
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public class Prize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 奖品编号 */
    @Excel(name = "奖品编号")
    private Long prizeId;

    /** 奖品名称 */
    @Excel(name = "奖品名称")
    private String prizeName;

    /** 奖品图片 */
    @Excel(name = "奖品图片")
    private String prizeImg;

    /** 奖品数量 */
    @Excel(name = "奖品数量")
    private Long prizeNumber;

    /** 奖品对应积分 */
    @Excel(name = "奖品对应积分")
    private String prizeCredit;

    /** 花费总数 */
    @Excel(name = "花费总数")
    private Long spendNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPrizeId(Long prizeId) 
    {
        this.prizeId = prizeId;
    }

    public Long getPrizeId() 
    {
        return prizeId;
    }
    public void setPrizeName(String prizeName) 
    {
        this.prizeName = prizeName;
    }

    public String getPrizeName() 
    {
        return prizeName;
    }
    public void setPrizeImg(String prizeImg) 
    {
        this.prizeImg = prizeImg;
    }

    public String getPrizeImg() 
    {
        return prizeImg;
    }
    public void setPrizeNumber(Long prizeNumber) 
    {
        this.prizeNumber = prizeNumber;
    }

    public Long getPrizeNumber() 
    {
        return prizeNumber;
    }
    public void setPrizeCredit(String prizeCredit) 
    {
        this.prizeCredit = prizeCredit;
    }

    public String getPrizeCredit() 
    {
        return prizeCredit;
    }
    public void setSpendNumber(Long spendNumber) 
    {
        this.spendNumber = spendNumber;
    }

    public Long getSpendNumber() 
    {
        return spendNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("prizeId", getPrizeId())
            .append("prizeName", getPrizeName())
            .append("prizeImg", getPrizeImg())
            .append("prizeNumber", getPrizeNumber())
            .append("prizeCredit", getPrizeCredit())
            .append("spendNumber", getSpendNumber())
            .toString();
    }
}
