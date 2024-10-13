package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.goodnight.domain.PrizeStock;
import com.ruoyi.web.controller.goodnight.mapper.PrizeStockMapper;
import com.ruoyi.web.controller.goodnight.service.IPrizeStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 奖品库存管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-07
 */
@Service
public class PrizeStockServiceImpl implements IPrizeStockService
{
    @Resource
    private PrizeStockMapper prizeStockMapper;

    /**
     * 查询奖品库存管理
     * 
     * @param id 奖品库存管理主键
     * @return 奖品库存管理
     */
    @Override
    public PrizeStock selectPrizeStockById(Long id)
    {
        return prizeStockMapper.selectPrizeStockById(id);
    }

    /**
     * 查询奖品库存管理列表
     * 
     * @param prizeStock 奖品库存管理
     * @return 奖品库存管理
     */
    @Override
    public List<PrizeStock> selectPrizeStockList(PrizeStock prizeStock)
    {
        return prizeStockMapper.selectPrizeStockList(prizeStock);
    }

    /**
     * 新增奖品库存管理
     * 
     * @param prizeStock 奖品库存管理
     * @return 结果
     */
    @Override
    public int insertPrizeStock(PrizeStock prizeStock)
    {
        prizeStock.setCreateTime(DateUtils.getNowDate());
        return prizeStockMapper.insertPrizeStock(prizeStock);
    }

    /**
     * 修改奖品库存管理
     * 
     * @param prizeStock 奖品库存管理
     * @return 结果
     */
    @Override
    public int updatePrizeStock(PrizeStock prizeStock)
    {
        return prizeStockMapper.updatePrizeStock(prizeStock);
    }

    /**
     * 批量删除奖品库存管理
     * 
     * @param ids 需要删除的奖品库存管理主键
     * @return 结果
     */
    @Override
    public int deletePrizeStockByIds(Long[] ids)
    {
        return prizeStockMapper.deletePrizeStockByIds(ids);
    }

    /**
     * 删除奖品库存管理信息
     * 
     * @param id 奖品库存管理主键
     * @return 结果
     */
    @Override
    public int deletePrizeStockById(Long id)
    {
        return prizeStockMapper.deletePrizeStockById(id);
    }
}
