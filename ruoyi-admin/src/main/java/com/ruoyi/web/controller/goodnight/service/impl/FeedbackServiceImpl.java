package com.ruoyi.web.controller.goodnight.service.impl;

import java.util.List;

import com.ruoyi.web.controller.goodnight.domain.Feedback;
import com.ruoyi.web.controller.goodnight.mapper.FeedbackMapper;
import com.ruoyi.web.controller.goodnight.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 反馈与处理Service业务层处理
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService
{
    @Resource
    private FeedbackMapper feedbackMapper;

    /**
     * 查询反馈与处理
     * 
     * @param Id 反馈与处理主键
     * @return 反馈与处理
     */
    @Override
    public Feedback selectFeedbackById(Long Id)
    {
        return feedbackMapper.selectFeedbackById(Id);
    }

    /**
     * 查询反馈与处理列表
     * 
     * @param feedback 反馈与处理
     * @return 反馈与处理
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback)
    {
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增反馈与处理
     * 
     * @param feedback 反馈与处理
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback)
    {
        return feedbackMapper.insertFeedback(feedback);
    }

    /**
     * 修改反馈与处理
     * 
     * @param feedback 反馈与处理
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback)
    {
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 批量删除反馈与处理
     * 
     * @param Ids 需要删除的反馈与处理主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByIds(Long[] Ids)
    {
        return feedbackMapper.deleteFeedbackByIds(Ids);
    }

    /**
     * 删除反馈与处理信息
     * 
     * @param Id 反馈与处理主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackById(Long Id)
    {
        return feedbackMapper.deleteFeedbackById(Id);
    }
}
