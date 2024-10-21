package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.Driver;

import java.util.List;


/**
 * 运输人员管理Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-22
 */
public interface DriverMapper 
{
    /**
     * 查询运输人员管理
     * 
     * @param id 运输人员管理主键
     * @return 运输人员管理
     */
    public Driver selectDriverById(Long id);

    /**
     * 查询运输人员管理列表
     * 
     * @param driver 运输人员管理
     * @return 运输人员管理集合
     */
    public List<Driver> selectDriverList(Driver driver);

    /**
     * 新增运输人员管理
     * 
     * @param driver 运输人员管理
     * @return 结果
     */
    public int insertDriver(Driver driver);

    /**
     * 修改运输人员管理
     * 
     * @param driver 运输人员管理
     * @return 结果
     */
    public int updateDriver(Driver driver);

    /**
     * 删除运输人员管理
     * 
     * @param id 运输人员管理主键
     * @return 结果
     */
    public int deleteDriverById(Long id);

    /**
     * 批量删除运输人员管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDriverByIds(Long[] ids);
}
