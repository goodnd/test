package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.goodnight.domain.SiteManagement;
import com.ruoyi.web.controller.goodnight.mapper.SiteManagementMapper;
import com.ruoyi.web.controller.goodnight.service.ISiteManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 垃圾站点管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-04
 */
@Service
public class SiteManagementServiceImpl implements ISiteManagementService
{
    @Resource
    private SiteManagementMapper siteManagementMapper;

    /**
     * 查询垃圾站点管理
     * 
     * @param id 垃圾站点管理主键
     * @return 垃圾站点管理
     */
    @Override
    public SiteManagement selectSiteManagementById(Long id)
    {
        return siteManagementMapper.selectSiteManagementById(id);
    }

    /**
     * 查询垃圾站点管理列表
     * 
     * @param siteManagement 垃圾站点管理
     * @return 垃圾站点管理
     */
    @Override
    public List<SiteManagement> selectSiteManagementList(SiteManagement siteManagement)
    {
        return siteManagementMapper.selectSiteManagementList(siteManagement);
    }

    /**
     * 新增垃圾站点管理
     * 
     * @param siteManagement 垃圾站点管理
     * @return 结果
     */
    @Override
    public int insertSiteManagement(SiteManagement siteManagement)
    {
        siteManagement.setCreateTime(DateUtils.getNowDate());
        return siteManagementMapper.insertSiteManagement(siteManagement);
    }

    /**
     * 修改垃圾站点管理
     * 
     * @param siteManagement 垃圾站点管理
     * @return 结果
     */
    @Override
    public int updateSiteManagement(SiteManagement siteManagement)
    {
        siteManagement.setUpdateTime(DateUtils.getNowDate());
        return siteManagementMapper.updateSiteManagement(siteManagement);
    }

    /**
     * 批量删除垃圾站点管理
     * 
     * @param ids 需要删除的垃圾站点管理主键
     * @return 结果
     */
    @Override
    public int deleteSiteManagementByIds(Long[] ids)
    {
        return siteManagementMapper.deleteSiteManagementByIds(ids);
    }

    /**
     * 删除垃圾站点管理信息
     * 
     * @param id 垃圾站点管理主键
     * @return 结果
     */
    @Override
    public int deleteSiteManagementById(Long id)
    {
        return siteManagementMapper.deleteSiteManagementById(id);
    }
}
