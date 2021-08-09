package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HrInterviewQuestions;

/**
 * 题库维护Service接口
 * 
 * @author DK
 * @date 2021-07-28
 */
public interface IHrInterviewQuestionsService 
{
    /**
     * 查询题库维护
     * 
     * @param id 题库维护ID
     * @return 题库维护
     */
    public HrInterviewQuestions selectHrInterviewQuestionsById(String id);

    /**
     * 查询题库维护列表
     * 
     * @param hrInterviewQuestions 题库维护
     * @return 题库维护集合
     */
    public List<HrInterviewQuestions> selectHrInterviewQuestionsList(HrInterviewQuestions hrInterviewQuestions);

    /**
     * 根据岗位与问题对应表的id，返回问题信息列表
     * @param id
     * @return 题库集合
     */
    public List<HrInterviewQuestions> selectHrInterviewQuestionsByPQId(String id);
    
    
    /**
     * 返回所有大类和子类
     * @return 题库维护集合
     */
    public List<HrInterviewQuestions> selectAllCateSubCate();
    
    /**
     * 新增题库维护
     * 
     * @param hrInterviewQuestions 题库维护
     * @return 结果
     */
    public int insertHrInterviewQuestions(HrInterviewQuestions hrInterviewQuestions);

    /**
     * 修改题库维护
     * 
     * @param hrInterviewQuestions 题库维护
     * @return 结果
     */
    public int updateHrInterviewQuestions(HrInterviewQuestions hrInterviewQuestions);

    /**
     * 批量删除题库维护
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrInterviewQuestionsByIds(String ids);

    /**
     * 删除题库维护信息
     * 
     * @param id 题库维护ID
     * @return 结果
     */
    public int deleteHrInterviewQuestionsById(String id);
}
