package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.GarbageCollectionRecords;
import com.ruoyi.web.controller.goodnight.mapper.GarbageCollectionRecordsMapper;
import com.ruoyi.web.controller.goodnight.service.IGarbageCollectionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 垃圾收集记录管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-17
 */
@Service
public class GarbageCollectionRecordsServiceImpl implements IGarbageCollectionRecordsService
{
    @Resource
    private GarbageCollectionRecordsMapper garbageCollectionRecordsMapper;

    /**
     * 查询垃圾收集记录管理
     * 
     * @param id 垃圾收集记录管理主键
     * @return 垃圾收集记录管理
     */
    @Override
    public GarbageCollectionRecords selectGarbageCollectionRecordsById(Long id)
    {
        return garbageCollectionRecordsMapper.selectGarbageCollectionRecordsById(id);
    }

    /**
     * 查询垃圾收集记录管理列表
     * 
     * @param garbageCollectionRecords 垃圾收集记录管理
     * @return 垃圾收集记录管理
     */
    @Override
    public List<GarbageCollectionRecords> selectGarbageCollectionRecordsList(GarbageCollectionRecords garbageCollectionRecords)
    {
        return garbageCollectionRecordsMapper.selectGarbageCollectionRecordsList(garbageCollectionRecords);
    }

    /**
     * 新增垃圾收集记录管理
     * 
     * @param garbageCollectionRecords 垃圾收集记录管理
     * @return 结果
     */
    @Override
    public int insertGarbageCollectionRecords(GarbageCollectionRecords garbageCollectionRecords)
    {
        return garbageCollectionRecordsMapper.insertGarbageCollectionRecords(garbageCollectionRecords);
    }

    /**
     * 修改垃圾收集记录管理
     * 
     * @param garbageCollectionRecords 垃圾收集记录管理
     * @return 结果
     */
    @Override
    public int updateGarbageCollectionRecords(GarbageCollectionRecords garbageCollectionRecords)
    {
        return garbageCollectionRecordsMapper.updateGarbageCollectionRecords(garbageCollectionRecords);
    }

    /**
     * 批量删除垃圾收集记录管理
     * 
     * @param ids 需要删除的垃圾收集记录管理主键
     * @return 结果
     */
    @Override
    public int deleteGarbageCollectionRecordsByIds(Long[] ids)
    {
        return garbageCollectionRecordsMapper.deleteGarbageCollectionRecordsByIds(ids);
    }

    /**
     * 删除垃圾收集记录管理信息
     * 
     * @param id 垃圾收集记录管理主键
     * @return 结果
     */
    @Override
    public int deleteGarbageCollectionRecordsById(Long id)
    {
        return garbageCollectionRecordsMapper.deleteGarbageCollectionRecordsById(id);
    }
}
