package com.ruoyi.web.controller.goodnight.service;

import com.ruoyi.web.controller.goodnight.domain.PrizeStock;

import java.util.List;


/**
 * 奖品库存管理Service接口
 * 
 * @author goodnight
 * @date 2024-10-07
 */
public interface IPrizeStockService 
{
    /**
     * 查询奖品库存管理
     * 
     * @param id 奖品库存管理主键
     * @return 奖品库存管理
     */
    public PrizeStock selectPrizeStockById(Long id);

    /**
     * 查询奖品库存管理列表
     * 
     * @param prizeStock 奖品库存管理
     * @return 奖品库存管理集合
     */
    public List<PrizeStock> selectPrizeStockList(PrizeStock prizeStock);

    /**
     * 新增奖品库存管理
     * 
     * @param prizeStock 奖品库存管理
     * @return 结果
     */
    public int insertPrizeStock(PrizeStock prizeStock);

    /**
     * 修改奖品库存管理
     * 
     * @param prizeStock 奖品库存管理
     * @return 结果
     */
    public int updatePrizeStock(PrizeStock prizeStock);

    /**
     * 批量删除奖品库存管理
     * 
     * @param ids 需要删除的奖品库存管理主键集合
     * @return 结果
     */
    public int deletePrizeStockByIds(Long[] ids);

    /**
     * 删除奖品库存管理信息
     * 
     * @param id 奖品库存管理主键
     * @return 结果
     */
    public int deletePrizeStockById(Long id);
}
