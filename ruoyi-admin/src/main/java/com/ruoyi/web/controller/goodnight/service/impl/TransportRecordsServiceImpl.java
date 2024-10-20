package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.TransportRecords;
import com.ruoyi.web.controller.goodnight.mapper.TransportRecordsMapper;
import com.ruoyi.web.controller.goodnight.service.ITransportRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 垃圾运输记录Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-18
 */
@Service
public class TransportRecordsServiceImpl implements ITransportRecordsService
{
    @Resource
    private TransportRecordsMapper transportRecordsMapper;

    /**
     * 查询垃圾运输记录
     * 
     * @param id 垃圾运输记录主键
     * @return 垃圾运输记录
     */
    @Override
    public TransportRecords selectTransportRecordsById(Long id)
    {
        return transportRecordsMapper.selectTransportRecordsById(id);
    }

    /**
     * 查询垃圾运输记录列表
     * 
     * @param transportRecords 垃圾运输记录
     * @return 垃圾运输记录
     */
    @Override
    public List<TransportRecords> selectTransportRecordsList(TransportRecords transportRecords)
    {
        return transportRecordsMapper.selectTransportRecordsList(transportRecords);
    }

    /**
     * 新增垃圾运输记录
     * 
     * @param transportRecords 垃圾运输记录
     * @return 结果
     */
    @Override
    public int insertTransportRecords(TransportRecords transportRecords)
    {
        return transportRecordsMapper.insertTransportRecords(transportRecords);
    }

    /**
     * 修改垃圾运输记录
     * 
     * @param transportRecords 垃圾运输记录
     * @return 结果
     */
    @Override
    public int updateTransportRecords(TransportRecords transportRecords)
    {
        return transportRecordsMapper.updateTransportRecords(transportRecords);
    }

    /**
     * 批量删除垃圾运输记录
     * 
     * @param ids 需要删除的垃圾运输记录主键
     * @return 结果
     */
    @Override
    public int deleteTransportRecordsByIds(Long[] ids)
    {
        return transportRecordsMapper.deleteTransportRecordsByIds(ids);
    }

    /**
     * 删除垃圾运输记录信息
     * 
     * @param id 垃圾运输记录主键
     * @return 结果
     */
    @Override
    public int deleteTransportRecordsById(Long id)
    {
        return transportRecordsMapper.deleteTransportRecordsById(id);
    }
}
