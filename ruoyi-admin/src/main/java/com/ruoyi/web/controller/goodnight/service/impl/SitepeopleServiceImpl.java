package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.Sitepeople;
import com.ruoyi.web.controller.goodnight.mapper.SitepeopleMapper;
import com.ruoyi.web.controller.goodnight.service.ISitepeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 垃圾站点人员Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-21
 */
@Service
public class SitepeopleServiceImpl implements ISitepeopleService
{
    @Resource
    private SitepeopleMapper sitepeopleMapper;

    /**
     * 查询垃圾站点人员
     * 
     * @param id 垃圾站点人员主键
     * @return 垃圾站点人员
     */
    @Override
    public Sitepeople selectSitepeopleById(Long id)
    {
        return sitepeopleMapper.selectSitepeopleById(id);
    }

    /**
     * 查询垃圾站点人员列表
     * 
     * @param sitepeople 垃圾站点人员
     * @return 垃圾站点人员
     */
    @Override
    public List<Sitepeople> selectSitepeopleList(Sitepeople sitepeople)
    {
        return sitepeopleMapper.selectSitepeopleList(sitepeople);
    }

    /**
     * 新增垃圾站点人员
     * 
     * @param sitepeople 垃圾站点人员
     * @return 结果
     */
    @Override
    public int insertSitepeople(Sitepeople sitepeople)
    {
        return sitepeopleMapper.insertSitepeople(sitepeople);
    }

    /**
     * 修改垃圾站点人员
     * 
     * @param sitepeople 垃圾站点人员
     * @return 结果
     */
    @Override
    public int updateSitepeople(Sitepeople sitepeople)
    {
        return sitepeopleMapper.updateSitepeople(sitepeople);
    }

    /**
     * 批量删除垃圾站点人员
     * 
     * @param ids 需要删除的垃圾站点人员主键
     * @return 结果
     */
    @Override
    public int deleteSitepeopleByIds(Long[] ids)
    {
        return sitepeopleMapper.deleteSitepeopleByIds(ids);
    }

    /**
     * 删除垃圾站点人员信息
     * 
     * @param id 垃圾站点人员主键
     * @return 结果
     */
    @Override
    public int deleteSitepeopleById(Long id)
    {
        return sitepeopleMapper.deleteSitepeopleById(id);
    }
}
