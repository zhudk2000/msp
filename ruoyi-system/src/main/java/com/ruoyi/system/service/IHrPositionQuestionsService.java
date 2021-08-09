package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HrPositionQuestions;

/**
 * 岗位考题维护Service接口
 * 
 * @author DK
 * @date 2021-07-28
 */
public interface IHrPositionQuestionsService 
{
    /**
     * 查询岗位考题维护
     * 
     * @param id 岗位考题维护ID
     * @return 岗位考题维护
     */
    public HrPositionQuestions selectHrPositionQuestionsById(String id);

    /**
     * 查询岗位考题维护列表
     * 
     * @param hrPositionQuestions 岗位考题维护
     * @return 岗位考题维护集合
     */
    public List<HrPositionQuestions> selectHrPositionQuestionsList(HrPositionQuestions hrPositionQuestions);

    public List<HrPositionQuestions> selectHrPositionQuestionsByPositionId(String positionId);
    
    /**
     * 新增岗位考题维护
     * 
     * @param hrPositionQuestions 岗位考题维护
     * @return 结果
     */
    public int insertHrPositionQuestions(HrPositionQuestions hrPositionQuestions);

    /**
     * 修改岗位考题维护
     * 
     * @param hrPositionQuestions 岗位考题维护
     * @return 结果
     */
    public int updateHrPositionQuestions(HrPositionQuestions hrPositionQuestions);

    /**
     * 批量删除岗位考题维护
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrPositionQuestionsByIds(String ids);

    /**
     * 删除岗位考题维护信息
     * 
     * @param id 岗位考题维护ID
     * @return 结果
     */
    public int deleteHrPositionQuestionsById(String id);
}
