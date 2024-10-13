package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.GarbageSorting;
import com.ruoyi.web.controller.goodnight.mapper.GarbageSortingMapper;
import com.ruoyi.web.controller.goodnight.service.IGarbageSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 垃圾分类管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@Service
public class GarbageSortingServiceImpl implements IGarbageSortingService
{
    @Resource
    private GarbageSortingMapper garbageSortingMapper;

    /**
     * 查询垃圾分类管理
     * 
     * @param id 垃圾分类管理主键
     * @return 垃圾分类管理
     */
    @Override
    public GarbageSorting selectGarbageSortingById(Long id)
    {
        return garbageSortingMapper.selectGarbageSortingById(id);
    }

    /**
     * 查询垃圾分类管理列表
     * 
     * @param garbageSorting 垃圾分类管理
     * @return 垃圾分类管理
     */
    @Override
    public List<GarbageSorting> selectGarbageSortingList(GarbageSorting garbageSorting)
    {
        return garbageSortingMapper.selectGarbageSortingList(garbageSorting);
    }

    /**
     * 新增垃圾分类管理
     * 
     * @param garbageSorting 垃圾分类管理
     * @return 结果
     */
    @Override
    public int insertGarbageSorting(GarbageSorting garbageSorting)
    {
        return garbageSortingMapper.insertGarbageSorting(garbageSorting);
    }

    /**
     * 修改垃圾分类管理
     * 
     * @param garbageSorting 垃圾分类管理
     * @return 结果
     */
    @Override
    public int updateGarbageSorting(GarbageSorting garbageSorting)
    {
        return garbageSortingMapper.updateGarbageSorting(garbageSorting);
    }

    /**
     * 批量删除垃圾分类管理
     * 
     * @param ids 需要删除的垃圾分类管理主键
     * @return 结果
     */
    @Override
    public int deleteGarbageSortingByIds(Long[] ids)
    {
        return garbageSortingMapper.deleteGarbageSortingByIds(ids);
    }

    /**
     * 删除垃圾分类管理信息
     * 
     * @param id 垃圾分类管理主键
     * @return 结果
     */
    @Override
    public int deleteGarbageSortingById(Long id)
    {
        return garbageSortingMapper.deleteGarbageSortingById(id);
    }
}
