package com.ruoyi.web.controller.goodnight.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 垃圾分类管理对象 sm_garbage_sorting
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public class GarbageSorting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 垃圾名称 */
    @Excel(name = "垃圾名称")
    private String garbageName;

    /** 垃圾类别 */
    @Excel(name = "垃圾类别")
    private String garbageCategory;

    /** 垃圾图片 */
    @Excel(name = "垃圾图片")
    private String garbageImg;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creatBy;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGarbageName(String garbageName) 
    {
        this.garbageName = garbageName;
    }

    public String getGarbageName() 
    {
        return garbageName;
    }
    public void setGarbageCategory(String garbageCategory) 
    {
        this.garbageCategory = garbageCategory;
    }

    public String getGarbageCategory() 
    {
        return garbageCategory;
    }
    public void setGarbageImg(String garbageImg) 
    {
        this.garbageImg = garbageImg;
    }

    public String getGarbageImg() 
    {
        return garbageImg;
    }
    public void setCreatBy(String creatBy) 
    {
        this.creatBy = creatBy;
    }

    public String getCreatBy() 
    {
        return creatBy;
    }
    public void setRemake(String remake) 
    {
        this.remake = remake;
    }

    public String getRemake() 
    {
        return remake;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("garbageName", getGarbageName())
            .append("garbageCategory", getGarbageCategory())
            .append("garbageImg", getGarbageImg())
            .append("creatBy", getCreatBy())
            .append("remake", getRemake())
            .toString();
    }
}
