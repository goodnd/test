package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.VehicleList;
import com.ruoyi.web.controller.goodnight.mapper.VehicleListMapper;
import com.ruoyi.web.controller.goodnight.service.IVehicleListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 运输车辆Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-18
 */
@Service
public class VehicleListServiceImpl implements IVehicleListService
{
    @Resource
    private VehicleListMapper vehicleListMapper;

    /**
     * 查询运输车辆
     * 
     * @param id 运输车辆主键
     * @return 运输车辆
     */
    @Override
    public VehicleList selectVehicleListById(Long id)
    {
        return vehicleListMapper.selectVehicleListById(id);
    }

    /**
     * 查询运输车辆列表
     * 
     * @param vehicleList 运输车辆
     * @return 运输车辆
     */
    @Override
    public List<VehicleList> selectVehicleListList(VehicleList vehicleList)
    {
        return vehicleListMapper.selectVehicleListList(vehicleList);
    }

    /**
     * 新增运输车辆
     * 
     * @param vehicleList 运输车辆
     * @return 结果
     */
    @Override
    public int insertVehicleList(VehicleList vehicleList)
    {
        return vehicleListMapper.insertVehicleList(vehicleList);
    }

    /**
     * 修改运输车辆
     * 
     * @param vehicleList 运输车辆
     * @return 结果
     */
    @Override
    public int updateVehicleList(VehicleList vehicleList)
    {
        return vehicleListMapper.updateVehicleList(vehicleList);
    }

    /**
     * 批量删除运输车辆
     * 
     * @param ids 需要删除的运输车辆主键
     * @return 结果
     */
    @Override
    public int deleteVehicleListByIds(Long[] ids)
    {
        return vehicleListMapper.deleteVehicleListByIds(ids);
    }

    /**
     * 删除运输车辆信息
     * 
     * @param id 运输车辆主键
     * @return 结果
     */
    @Override
    public int deleteVehicleListById(Long id)
    {
        return vehicleListMapper.deleteVehicleListById(id);
    }
}
