package com.ruoyi.web.controller.goodnight.service;

import com.ruoyi.web.controller.goodnight.domain.GarbageStation;

import java.util.List;


/**
 * 垃圾回收站管理Service接口
 * 
 * @author goodnight
 * @date 2024-10-04
 */
public interface IGarbageStationService 
{
    /**
     * 查询垃圾回收站管理
     * 
     * @param id 垃圾回收站管理主键
     * @return 垃圾回收站管理
     */
    public GarbageStation selectGarbageStationById(Long id);

    /**
     * 查询垃圾回收站管理列表
     * 
     * @param garbageStation 垃圾回收站管理
     * @return 垃圾回收站管理集合
     */
    public List<GarbageStation> selectGarbageStationList(GarbageStation garbageStation);

    /**
     * 新增垃圾回收站管理
     * 
     * @param garbageStation 垃圾回收站管理
     * @return 结果
     */
    public int insertGarbageStation(GarbageStation garbageStation);

    /**
     * 修改垃圾回收站管理
     * 
     * @param garbageStation 垃圾回收站管理
     * @return 结果
     */
    public int updateGarbageStation(GarbageStation garbageStation);

    /**
     * 批量删除垃圾回收站管理
     * 
     * @param ids 需要删除的垃圾回收站管理主键集合
     * @return 结果
     */
    public int deleteGarbageStationByIds(Long[] ids);

    /**
     * 删除垃圾回收站管理信息
     * 
     * @param id 垃圾回收站管理主键
     * @return 结果
     */
    public int deleteGarbageStationById(Long id);
}
