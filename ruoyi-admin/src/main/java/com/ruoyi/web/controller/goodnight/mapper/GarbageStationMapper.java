package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.GarbageStation;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 垃圾回收站管理Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public interface GarbageStationMapper 
{
    /**
     * 查询垃圾回收站管理
     * 
     * @param id 垃圾回收站管理主键
     * @return 垃圾回收站管理
     */
    public GarbageStation selectGarbageStationById(Long id);

    /**
     * id查询
     * @param ids
     * @return
     */
    public List<GarbageStation> selectGarbageStationByIds(@Param("ids")List<Long> ids);
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
     * 删除垃圾回收站管理
     * 
     * @param id 垃圾回收站管理主键
     * @return 结果
     */
    public int deleteGarbageStationById(Long id);

    /**
     * 批量删除垃圾回收站管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGarbageStationByIds(Long[] ids);
}
