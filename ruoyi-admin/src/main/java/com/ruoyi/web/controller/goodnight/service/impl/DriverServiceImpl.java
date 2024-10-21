package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.Driver;
import com.ruoyi.web.controller.goodnight.mapper.DriverMapper;
import com.ruoyi.web.controller.goodnight.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 运输人员管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-22
 */
@Service
public class DriverServiceImpl implements IDriverService
{
    @Resource
    private DriverMapper driverMapper;

    /**
     * 查询运输人员管理
     * 
     * @param id 运输人员管理主键
     * @return 运输人员管理
     */
    @Override
    public Driver selectDriverById(Long id)
    {
        return driverMapper.selectDriverById(id);
    }

    /**
     * 查询运输人员管理列表
     * 
     * @param driver 运输人员管理
     * @return 运输人员管理
     */
    @Override
    public List<Driver> selectDriverList(Driver driver)
    {
        return driverMapper.selectDriverList(driver);
    }

    /**
     * 新增运输人员管理
     * 
     * @param driver 运输人员管理
     * @return 结果
     */
    @Override
    public int insertDriver(Driver driver)
    {
        return driverMapper.insertDriver(driver);
    }

    /**
     * 修改运输人员管理
     * 
     * @param driver 运输人员管理
     * @return 结果
     */
    @Override
    public int updateDriver(Driver driver)
    {
        return driverMapper.updateDriver(driver);
    }

    /**
     * 批量删除运输人员管理
     * 
     * @param ids 需要删除的运输人员管理主键
     * @return 结果
     */
    @Override
    public int deleteDriverByIds(Long[] ids)
    {
        return driverMapper.deleteDriverByIds(ids);
    }

    /**
     * 删除运输人员管理信息
     * 
     * @param id 运输人员管理主键
     * @return 结果
     */
    @Override
    public int deleteDriverById(Long id)
    {
        return driverMapper.deleteDriverById(id);
    }
}
