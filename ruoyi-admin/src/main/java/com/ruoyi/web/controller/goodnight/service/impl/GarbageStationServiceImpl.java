package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.GarbageStation;
import com.ruoyi.web.controller.goodnight.mapper.GarbageStationMapper;
import com.ruoyi.web.controller.goodnight.service.IGarbageStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 垃圾回收站管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-18
 */
@Service
public class GarbageStationServiceImpl implements IGarbageStationService
{
    @Resource
    private GarbageStationMapper garbageStationMapper;

    /**
     * 查询垃圾回收站管理
     * 
     * @param id 垃圾回收站管理主键
     * @return 垃圾回收站管理
     */
    @Override
    public GarbageStation selectGarbageStationById(Long id)
    {
        return garbageStationMapper.selectGarbageStationById(id);
    }

    /**
     * 查询垃圾回收站管理列表
     * 
     * @param garbageStation 垃圾回收站管理
     * @return 垃圾回收站管理
     */
    @Override
    public List<GarbageStation> selectGarbageStationList(GarbageStation garbageStation)
    {
        return garbageStationMapper.selectGarbageStationList(garbageStation);
    }

    /**
     * 新增垃圾回收站管理
     * 
     * @param garbageStation 垃圾回收站管理
     * @return 结果
     */
    @Override
    public int insertGarbageStation(GarbageStation garbageStation)
    {
        return garbageStationMapper.insertGarbageStation(garbageStation);
    }

    /**
     * 修改垃圾回收站管理
     * 
     * @param garbageStation 垃圾回收站管理
     * @return 结果
     */
    @Override
    public int updateGarbageStation(GarbageStation garbageStation)
    {
        return garbageStationMapper.updateGarbageStation(garbageStation);
    }

    /**
     * 批量删除垃圾回收站管理
     * 
     * @param ids 需要删除的垃圾回收站管理主键
     * @return 结果
     */
    @Override
    public int deleteGarbageStationByIds(Long[] ids)
    {
        return garbageStationMapper.deleteGarbageStationByIds(ids);
    }

    /**
     * 删除垃圾回收站管理信息
     * 
     * @param id 垃圾回收站管理主键
     * @return 结果
     */
    @Override
    public int deleteGarbageStationById(Long id)
    {
        return garbageStationMapper.deleteGarbageStationById(id);
    }
}
