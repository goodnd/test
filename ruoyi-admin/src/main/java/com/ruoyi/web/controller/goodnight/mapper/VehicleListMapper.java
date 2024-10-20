package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.VehicleList;

import java.util.List;


/**
 * 运输车辆Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public interface VehicleListMapper 
{
    /**
     * 查询运输车辆
     * 
     * @param id 运输车辆主键
     * @return 运输车辆
     */
    public VehicleList selectVehicleListById(Long id);

    /**
     * 查询运输车辆列表
     * 
     * @param vehicleList 运输车辆
     * @return 运输车辆集合
     */
    public List<VehicleList> selectVehicleListList(VehicleList vehicleList);

    /**
     * 新增运输车辆
     * 
     * @param vehicleList 运输车辆
     * @return 结果
     */
    public int insertVehicleList(VehicleList vehicleList);

    /**
     * 修改运输车辆
     * 
     * @param vehicleList 运输车辆
     * @return 结果
     */
    public int updateVehicleList(VehicleList vehicleList);

    /**
     * 删除运输车辆
     * 
     * @param id 运输车辆主键
     * @return 结果
     */
    public int deleteVehicleListById(Long id);

    /**
     * 批量删除运输车辆
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVehicleListByIds(Long[] ids);
}
