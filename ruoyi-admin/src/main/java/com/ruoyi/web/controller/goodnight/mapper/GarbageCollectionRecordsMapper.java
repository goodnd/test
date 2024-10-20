package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.GarbageCollectionRecords;

import java.util.List;


/**
 * 垃圾收集记录管理Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-17
 */
public interface GarbageCollectionRecordsMapper 
{
    /**
     * 查询垃圾收集记录管理
     * 
     * @param id 垃圾收集记录管理主键
     * @return 垃圾收集记录管理
     */
    public GarbageCollectionRecords selectGarbageCollectionRecordsById(Long id);

    /**
     * 查询垃圾收集记录管理列表
     * 
     * @param garbageCollectionRecords 垃圾收集记录管理
     * @return 垃圾收集记录管理集合
     */
    public List<GarbageCollectionRecords> selectGarbageCollectionRecordsList(GarbageCollectionRecords garbageCollectionRecords);

    /**
     * 新增垃圾收集记录管理
     * 
     * @param garbageCollectionRecords 垃圾收集记录管理
     * @return 结果
     */
    public int insertGarbageCollectionRecords(GarbageCollectionRecords garbageCollectionRecords);

    /**
     * 修改垃圾收集记录管理
     * 
     * @param garbageCollectionRecords 垃圾收集记录管理
     * @return 结果
     */
    public int updateGarbageCollectionRecords(GarbageCollectionRecords garbageCollectionRecords);

    /**
     * 删除垃圾收集记录管理
     * 
     * @param id 垃圾收集记录管理主键
     * @return 结果
     */
    public int deleteGarbageCollectionRecordsById(Long id);

    /**
     * 批量删除垃圾收集记录管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGarbageCollectionRecordsByIds(Long[] ids);
}
