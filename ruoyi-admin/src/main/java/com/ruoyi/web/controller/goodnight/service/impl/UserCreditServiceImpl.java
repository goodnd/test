package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.UserCredit;
import com.ruoyi.web.controller.goodnight.mapper.UserCreditMapper;
import com.ruoyi.web.controller.goodnight.service.IUserCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户积分管理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@Service
public class UserCreditServiceImpl implements IUserCreditService
{
    @Resource
    private UserCreditMapper userCreditMapper;

    /**
     * 查询用户积分管理
     * 
     * @param id 用户积分管理主键
     * @return 用户积分管理
     */
    @Override
    public UserCredit selectUserCreditById(Long id)
    {
        return userCreditMapper.selectUserCreditById(id);
    }

    /**
     * 查询用户积分管理列表
     * 
     * @param userCredit 用户积分管理
     * @return 用户积分管理
     */
    @Override
    public List<UserCredit> selectUserCreditList(UserCredit userCredit)
    {
        return userCreditMapper.selectUserCreditList(userCredit);
    }

    /**
     * 新增用户积分管理
     * 
     * @param userCredit 用户积分管理
     * @return 结果
     */
    @Override
    public int insertUserCredit(UserCredit userCredit)
    {
        return userCreditMapper.insertUserCredit(userCredit);
    }

    /**
     * 修改用户积分管理
     * 
     * @param userCredit 用户积分管理
     * @return 结果
     */
    @Override
    public int updateUserCredit(UserCredit userCredit)
    {
        return userCreditMapper.updateUserCredit(userCredit);
    }

    /**
     * 批量删除用户积分管理
     * 
     * @param ids 需要删除的用户积分管理主键
     * @return 结果
     */
    @Override
    public int deleteUserCreditByIds(Long[] ids)
    {
        return userCreditMapper.deleteUserCreditByIds(ids);
    }

    /**
     * 删除用户积分管理信息
     * 
     * @param id 用户积分管理主键
     * @return 结果
     */
    @Override
    public int deleteUserCreditById(Long id)
    {
        return userCreditMapper.deleteUserCreditById(id);
    }
}
