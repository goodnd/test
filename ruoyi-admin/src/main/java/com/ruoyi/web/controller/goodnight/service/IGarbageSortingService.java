package com.ruoyi.web.controller.goodnight.service;

import com.ruoyi.web.controller.goodnight.domain.GarbageSorting;

import java.util.List;


/**
 * 垃圾分类管理Service接口
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public interface IGarbageSortingService 
{
    /**
     * 查询垃圾分类管理
     * 
     * @param id 垃圾分类管理主键
     * @return 垃圾分类管理
     */
    public GarbageSorting selectGarbageSortingById(Long id);

    /**
     * 查询垃圾分类管理列表
     * 
     * @param garbageSorting 垃圾分类管理
     * @return 垃圾分类管理集合
     */
    public List<GarbageSorting> selectGarbageSortingList(GarbageSorting garbageSorting);

    /**
     * 新增垃圾分类管理
     * 
     * @param garbageSorting 垃圾分类管理
     * @return 结果
     */
    public int insertGarbageSorting(GarbageSorting garbageSorting);

    /**
     * 修改垃圾分类管理
     * 
     * @param garbageSorting 垃圾分类管理
     * @return 结果
     */
    public int updateGarbageSorting(GarbageSorting garbageSorting);

    /**
     * 批量删除垃圾分类管理
     * 
     * @param ids 需要删除的垃圾分类管理主键集合
     * @return 结果
     */
    public int deleteGarbageSortingByIds(Long[] ids);

    /**
     * 删除垃圾分类管理信息
     * 
     * @param id 垃圾分类管理主键
     * @return 结果
     */
    public int deleteGarbageSortingById(Long id);
}
