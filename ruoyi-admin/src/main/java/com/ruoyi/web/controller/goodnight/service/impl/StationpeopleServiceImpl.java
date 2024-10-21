package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.Stationpeople;
import com.ruoyi.web.controller.goodnight.mapper.StationpeopleMapper;
import com.ruoyi.web.controller.goodnight.service.IStationpeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 回收站点人员Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-21
 */
@Service
public class StationpeopleServiceImpl implements IStationpeopleService
{
    @Resource
    private StationpeopleMapper stationpeopleMapper;

    /**
     * 查询回收站点人员
     * 
     * @param id 回收站点人员主键
     * @return 回收站点人员
     */
    @Override
    public Stationpeople selectStationpeopleById(Long id)
    {
        return stationpeopleMapper.selectStationpeopleById(id);
    }

    /**
     * 查询回收站点人员列表
     * 
     * @param stationpeople 回收站点人员
     * @return 回收站点人员
     */
    @Override
    public List<Stationpeople> selectStationpeopleList(Stationpeople stationpeople)
    {
        return stationpeopleMapper.selectStationpeopleList(stationpeople);
    }

    /**
     * 新增回收站点人员
     * 
     * @param stationpeople 回收站点人员
     * @return 结果
     */
    @Override
    public int insertStationpeople(Stationpeople stationpeople)
    {
        return stationpeopleMapper.insertStationpeople(stationpeople);
    }

    /**
     * 修改回收站点人员
     * 
     * @param stationpeople 回收站点人员
     * @return 结果
     */
    @Override
    public int updateStationpeople(Stationpeople stationpeople)
    {
        return stationpeopleMapper.updateStationpeople(stationpeople);
    }

    /**
     * 批量删除回收站点人员
     * 
     * @param ids 需要删除的回收站点人员主键
     * @return 结果
     */
    @Override
    public int deleteStationpeopleByIds(Long[] ids)
    {
        return stationpeopleMapper.deleteStationpeopleByIds(ids);
    }

    /**
     * 删除回收站点人员信息
     * 
     * @param id 回收站点人员主键
     * @return 结果
     */
    @Override
    public int deleteStationpeopleById(Long id)
    {
        return stationpeopleMapper.deleteStationpeopleById(id);
    }
}
