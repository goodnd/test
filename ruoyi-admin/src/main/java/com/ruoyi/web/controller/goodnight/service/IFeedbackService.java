package com.ruoyi.web.controller.goodnight.service;

import com.ruoyi.web.controller.goodnight.domain.Feedback;

import java.util.List;


/**
 * 反馈与处理Service接口
 * 
 * @author goodnight
 * @date 2024-10-06
 */
public interface IFeedbackService 
{
    /**
     * 查询反馈与处理
     * 
     * @param Id 反馈与处理主键
     * @return 反馈与处理
     */
    public Feedback selectFeedbackById(Long Id);

    /**
     * 查询反馈与处理列表
     * 
     * @param feedback 反馈与处理
     * @return 反馈与处理集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增反馈与处理
     * 
     * @param feedback 反馈与处理
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改反馈与处理
     * 
     * @param feedback 反馈与处理
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 批量删除反馈与处理
     * 
     * @param Ids 需要删除的反馈与处理主键集合
     * @return 结果
     */
    public int deleteFeedbackByIds(Long[] Ids);

    /**
     * 删除反馈与处理信息
     * 
     * @param Id 反馈与处理主键
     * @return 结果
     */
    public int deleteFeedbackById(Long Id);
}
