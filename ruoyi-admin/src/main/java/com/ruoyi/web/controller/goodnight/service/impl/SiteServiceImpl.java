package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.Site;
import com.ruoyi.web.controller.goodnight.mapper.SiteMapper;
import com.ruoyi.web.controller.goodnight.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 垃圾站点管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-18
 */
@Service
public class SiteServiceImpl implements ISiteService
{
    @Resource
    private SiteMapper siteMapper;

    /**
     * 查询垃圾站点管理
     * 
     * @param id 垃圾站点管理主键
     * @return 垃圾站点管理
     */
    @Override
    public Site selectSiteById(Long id)
    {
        return siteMapper.selectSiteById(id);
    }

    /**
     * 查询垃圾站点管理列表
     * 
     * @param site 垃圾站点管理
     * @return 垃圾站点管理
     */
    @Override
    public List<Site> selectSiteList(Site site)
    {
        return siteMapper.selectSiteList(site);
    }

    /**
     * 新增垃圾站点管理
     * 
     * @param site 垃圾站点管理
     * @return 结果
     */
    @Override
    public int insertSite(Site site)
    {
        return siteMapper.insertSite(site);
    }

    /**
     * 修改垃圾站点管理
     * 
     * @param site 垃圾站点管理
     * @return 结果
     */
    @Override
    public int updateSite(Site site)
    {
        return siteMapper.updateSite(site);
    }

    /**
     * 批量删除垃圾站点管理
     * 
     * @param ids 需要删除的垃圾站点管理主键
     * @return 结果
     */
    @Override
    public int deleteSiteByIds(Long[] ids)
    {
        return siteMapper.deleteSiteByIds(ids);
    }

    /**
     * 删除垃圾站点管理信息
     * 
     * @param id 垃圾站点管理主键
     * @return 结果
     */
    @Override
    public int deleteSiteById(Long id)
    {
        return siteMapper.deleteSiteById(id);
    }
}
