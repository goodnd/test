package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.Prize;
import com.ruoyi.web.controller.goodnight.mapper.PrizeMapper;
import com.ruoyi.web.controller.goodnight.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 奖品管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@Service
public class PrizeServiceImpl implements IPrizeService
{
    @Resource
    private PrizeMapper prizeMapper;

    /**
     * 查询奖品管理
     * 
     * @param id 奖品管理主键
     * @return 奖品管理
     */
    @Override
    public Prize selectPrizeById(Long id)
    {
        return prizeMapper.selectPrizeById(id);
    }

    /**
     * 查询奖品管理列表
     * 
     * @param prize 奖品管理
     * @return 奖品管理
     */
    @Override
    public List<Prize> selectPrizeList(Prize prize)
    {
        return prizeMapper.selectPrizeList(prize);
    }

    /**
     * 新增奖品管理
     * 
     * @param prize 奖品管理
     * @return 结果
     */
    @Override
    public int insertPrize(Prize prize)
    {
        return prizeMapper.insertPrize(prize);
    }

    /**
     * 修改奖品管理
     * 
     * @param prize 奖品管理
     * @return 结果
     */
    @Override
    public int updatePrize(Prize prize)
    {
        return prizeMapper.updatePrize(prize);
    }

    /**
     * 批量删除奖品管理
     * 
     * @param ids 需要删除的奖品管理主键
     * @return 结果
     */
    @Override
    public int deletePrizeByIds(Long[] ids)
    {
        return prizeMapper.deletePrizeByIds(ids);
    }

    /**
     * 删除奖品管理信息
     * 
     * @param id 奖品管理主键
     * @return 结果
     */
    @Override
    public int deletePrizeById(Long id)
    {
        return prizeMapper.deletePrizeById(id);
    }
}
