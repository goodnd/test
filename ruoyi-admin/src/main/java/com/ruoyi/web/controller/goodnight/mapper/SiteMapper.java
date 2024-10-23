package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.Site;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 垃圾站点管理Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public interface SiteMapper 
{
    /**
     * 查询垃圾站点管理
     * 
     * @param id 垃圾站点管理主键
     * @return 垃圾站点管理
     */
    public Site selectSiteById(Long id);

    public List<Site> selectSiteListByIds(@Param("ids")List<Long> ids);

    /**
     * 通过名字查询
     * @param siteNames
     * @return
     */
    public List<Site> selectSiteListByName(@Param("siteName") String siteNames);

    /**
     * 查询垃圾站点管理列表
     * 
     * @param site 垃圾站点管理
     * @return 垃圾站点管理集合
     */
    public List<Site> selectSiteList(Site site);

    /**
     * 新增垃圾站点管理
     * 
     * @param site 垃圾站点管理
     * @return 结果
     */
    public int insertSite(Site site);

    /**
     * 修改垃圾站点管理
     * 
     * @param site 垃圾站点管理
     * @return 结果
     */
    public int updateSite(Site site);

    /**
     * 删除垃圾站点管理
     * 
     * @param id 垃圾站点管理主键
     * @return 结果
     */
    public int deleteSiteById(Long id);

    /**
     * 批量删除垃圾站点管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSiteByIds(Long[] ids);
}
