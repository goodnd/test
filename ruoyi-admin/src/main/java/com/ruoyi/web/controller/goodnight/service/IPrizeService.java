package com.ruoyi.web.controller.goodnight.service;

import com.ruoyi.web.controller.goodnight.domain.Prize;

import java.util.List;

/**
 * 奖品管理Service接口
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public interface IPrizeService 
{
    /**
     * 查询奖品管理
     * 
     * @param id 奖品管理主键
     * @return 奖品管理
     */
    public Prize selectPrizeById(Long id);

    /**
     * 查询奖品管理列表
     * 
     * @param prize 奖品管理
     * @return 奖品管理集合
     */
    public List<Prize> selectPrizeList(Prize prize);

    /**
     * 新增奖品管理
     * 
     * @param prize 奖品管理
     * @return 结果
     */
    public int insertPrize(Prize prize);

    /**
     * 修改奖品管理
     * 
     * @param prize 奖品管理
     * @return 结果
     */
    public int updatePrize(Prize prize);

    /**
     * 批量删除奖品管理
     * 
     * @param ids 需要删除的奖品管理主键集合
     * @return 结果
     */
    public int deletePrizeByIds(Long[] ids);

    /**
     * 删除奖品管理信息
     * 
     * @param id 奖品管理主键
     * @return 结果
     */
    public int deletePrizeById(Long id);
}
