package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.SiteManagement;

import java.util.List;


/**
 * 垃圾站点管理Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-04
 */
public interface SiteManagementMapper 
{
    /**
     * 查询垃圾站点管理
     * 
     * @param id 垃圾站点管理主键
     * @return 垃圾站点管理
     */
    public SiteManagement selectSiteManagementById(Long id);

    /**
     * 查询垃圾站点管理列表
     * 
     * @param siteManagement 垃圾站点管理
     * @return 垃圾站点管理集合
     */
    public List<SiteManagement> selectSiteManagementList(SiteManagement siteManagement);

    /**
     * 新增垃圾站点管理
     * 
     * @param siteManagement 垃圾站点管理
     * @return 结果
     */
    public int insertSiteManagement(SiteManagement siteManagement);

    /**
     * 修改垃圾站点管理
     * 
     * @param siteManagement 垃圾站点管理
     * @return 结果
     */
    public int updateSiteManagement(SiteManagement siteManagement);

    /**
     * 删除垃圾站点管理
     * 
     * @param id 垃圾站点管理主键
     * @return 结果
     */
    public int deleteSiteManagementById(Long id);

    /**
     * 批量删除垃圾站点管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSiteManagementByIds(Long[] ids);
}
