package com.ruoyi.web.controller.goodnight.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖品库存管理对象 sm_prize_stock
 * 
 * @author goodnight
 * @date 2024-10-07
 */
public class PrizeStock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 物品名称 */
    @Excel(name = "物品名称")
    private String goods;

    /** 采购单价 */
    @Excel(name = "采购单价")
    private BigDecimal goodsPrice;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long goodsNumber;

    /** 花费总金额 */
    @Excel(name = "花费总金额")
    private String totalMoney;

    /** 采购人员名称 */
    @Excel(name = "采购人员名称")
    private String buyer;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoods(String goods) 
    {
        this.goods = goods;
    }

    public String getGoods() 
    {
        return goods;
    }
    public void setGoodsPrice(BigDecimal goodsPrice) 
    {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice() 
    {
        return goodsPrice;
    }
    public void setGoodsNumber(Long goodsNumber) 
    {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsNumber() 
    {
        return goodsNumber;
    }
    public void setTotalMoney(String totalMoney) 
    {
        this.totalMoney = totalMoney;
    }

    public String getTotalMoney() 
    {
        return totalMoney;
    }
    public void setBuyer(String buyer) 
    {
        this.buyer = buyer;
    }

    public String getBuyer() 
    {
        return buyer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goods", getGoods())
            .append("goodsPrice", getGoodsPrice())
            .append("goodsNumber", getGoodsNumber())
            .append("totalMoney", getTotalMoney())
            .append("buyer", getBuyer())
            .append("createTime", getCreateTime())
            .toString();
    }
}
