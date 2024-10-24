package com.ruoyi.web.controller.goodnight.mapper;

import com.ruoyi.web.controller.goodnight.domain.UserCredit;

import java.util.List;


/**
 * 用户积分管理Mapper接口
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public interface UserCreditMapper 
{
    /**
     * 查询用户积分管理
     * 
     * @param id 用户积分管理主键
     * @return 用户积分管理
     */
    public UserCredit selectUserCreditById(Long id);

    /**
     * 查询用户积分管理列表
     * 
     * @param userCredit 用户积分管理
     * @return 用户积分管理集合
     */
    public List<UserCredit> selectUserCreditList(UserCredit userCredit);

    /**
     * 新增用户积分管理
     * 
     * @param userCredit 用户积分管理
     * @return 结果
     */
    public int insertUserCredit(UserCredit userCredit);

    /**
     * 修改用户积分管理
     * 
     * @param userCredit 用户积分管理
     * @return 结果
     */
    public int updateUserCredit(UserCredit userCredit);

    /**
     * 删除用户积分管理
     * 
     * @param id 用户积分管理主键
     * @return 结果
     */
    public int deleteUserCreditById(Long id);

    /**
     * 批量删除用户积分管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserCreditByIds(Long[] ids);
}
