package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.Stationpeople;

import java.util.List;


/**
 * 回收站点人员Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-21
 */
public interface StationpeopleMapper 
{
    /**
     * 查询回收站点人员
     * 
     * @param id 回收站点人员主键
     * @return 回收站点人员
     */
    public Stationpeople selectStationpeopleById(Long id);

    /**
     * 查询回收站点人员列表
     * 
     * @param stationpeople 回收站点人员
     * @return 回收站点人员集合
     */
    public List<Stationpeople> selectStationpeopleList(Stationpeople stationpeople);

    /**
     * 新增回收站点人员
     * 
     * @param stationpeople 回收站点人员
     * @return 结果
     */
    public int insertStationpeople(Stationpeople stationpeople);

    /**
     * 修改回收站点人员
     * 
     * @param stationpeople 回收站点人员
     * @return 结果
     */
    public int updateStationpeople(Stationpeople stationpeople);

    /**
     * 删除回收站点人员
     * 
     * @param id 回收站点人员主键
     * @return 结果
     */
    public int deleteStationpeopleById(Long id);

    /**
     * 批量删除回收站点人员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStationpeopleByIds(Long[] ids);
}
