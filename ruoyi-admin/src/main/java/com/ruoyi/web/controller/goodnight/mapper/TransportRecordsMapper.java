package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.TransportRecords;

import java.util.List;


/**
 * 垃圾运输记录Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-18
 */
public interface TransportRecordsMapper 
{
    /**
     * 查询垃圾运输记录
     * 
     * @param id 垃圾运输记录主键
     * @return 垃圾运输记录
     */
    public TransportRecords selectTransportRecordsById(Long id);

    /**
     * 查询垃圾运输记录列表
     * 
     * @param transportRecords 垃圾运输记录
     * @return 垃圾运输记录集合
     */
    public List<TransportRecords> selectTransportRecordsList(TransportRecords transportRecords);

    /**
     * 新增垃圾运输记录
     * 
     * @param transportRecords 垃圾运输记录
     * @return 结果
     */
    public int insertTransportRecords(TransportRecords transportRecords);

    /**
     * 修改垃圾运输记录
     * 
     * @param transportRecords 垃圾运输记录
     * @return 结果
     */
    public int updateTransportRecords(TransportRecords transportRecords);

    /**
     * 删除垃圾运输记录
     * 
     * @param id 垃圾运输记录主键
     * @return 结果
     */
    public int deleteTransportRecordsById(Long id);

    /**
     * 批量删除垃圾运输记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTransportRecordsByIds(Long[] ids);
}
