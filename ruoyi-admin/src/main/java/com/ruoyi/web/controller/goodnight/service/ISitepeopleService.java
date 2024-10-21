package com.ruoyi.web.controller.goodnight.service;

import com.ruoyi.web.controller.goodnight.domain.Sitepeople;

import java.util.List;


/**
 * 垃圾站点人员Service接口
 * 
 * @author goodnight
 * @date 2024-10-21
 */
public interface ISitepeopleService 
{
    /**
     * 查询垃圾站点人员
     * 
     * @param id 垃圾站点人员主键
     * @return 垃圾站点人员
     */
    public Sitepeople selectSitepeopleById(Long id);

    /**
     * 查询垃圾站点人员列表
     * 
     * @param sitepeople 垃圾站点人员
     * @return 垃圾站点人员集合
     */
    public List<Sitepeople> selectSitepeopleList(Sitepeople sitepeople);

    /**
     * 新增垃圾站点人员
     * 
     * @param sitepeople 垃圾站点人员
     * @return 结果
     */
    public int insertSitepeople(Sitepeople sitepeople);

    /**
     * 修改垃圾站点人员
     * 
     * @param sitepeople 垃圾站点人员
     * @return 结果
     */
    public int updateSitepeople(Sitepeople sitepeople);

    /**
     * 批量删除垃圾站点人员
     * 
     * @param ids 需要删除的垃圾站点人员主键集合
     * @return 结果
     */
    public int deleteSitepeopleByIds(Long[] ids);

    /**
     * 删除垃圾站点人员信息
     * 
     * @param id 垃圾站点人员主键
     * @return 结果
     */
    public int deleteSitepeopleById(Long id);
}
