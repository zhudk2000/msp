package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.uuid.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HrPositionQuestionsMapper;
import com.ruoyi.system.domain.HrPositionQuestions;
import com.ruoyi.system.service.IHrPositionQuestionsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 岗位考题维护Service业务层处理
 * 
 * @author DK
 * @date 2021-07-28
 */
@Service
public class HrPositionQuestionsServiceImpl implements IHrPositionQuestionsService 
{
    @Autowired
    private HrPositionQuestionsMapper hrPositionQuestionsMapper;

    /**
     * 查询岗位考题维护
     * 
     * @param id 岗位考题维护ID
     * @return 岗位考题维护
     */
    @Override
    public HrPositionQuestions selectHrPositionQuestionsById(String id)
    {
        return hrPositionQuestionsMapper.selectHrPositionQuestionsById(id);
    }

    /**
     * 查询岗位考题维护列表
     * 
     * @param hrPositionQuestions 岗位考题维护
     * @return 岗位考题维护
     */
    @Override
    public List<HrPositionQuestions> selectHrPositionQuestionsList(HrPositionQuestions hrPositionQuestions)
    {
        return hrPositionQuestionsMapper.selectHrPositionQuestionsList(hrPositionQuestions);
    }

    @Override
    public List<HrPositionQuestions> selectHrPositionQuestionsByPositionId(String positionId){
    	return hrPositionQuestionsMapper.selectHrPositionQuestionsByPositionId(positionId);
    }
    /**
     * 新增岗位考题维护
     * 
     * @param hrPositionQuestions 岗位考题维护
     * @return 结果
     */
    @Override
    public int insertHrPositionQuestions(HrPositionQuestions hrPositionQuestions)
    {
    	hrPositionQuestions.setId(UUID.randomUUID().toString());
    	hrPositionQuestions.setCreateBy(ShiroUtils.getLoginName());
        hrPositionQuestions.setCreateTime(DateUtils.getNowDate());
        return hrPositionQuestionsMapper.insertHrPositionQuestions(hrPositionQuestions);
    }

    /**
     * 修改岗位考题维护
     * 
     * @param hrPositionQuestions 岗位考题维护
     * @return 结果
     */
    @Override
    public int updateHrPositionQuestions(HrPositionQuestions hrPositionQuestions)
    {
    	hrPositionQuestions.setUpdateBy(ShiroUtils.getLoginName());
    	hrPositionQuestions.setUpdateTime(DateUtils.getNowDate());
        return hrPositionQuestionsMapper.updateHrPositionQuestions(hrPositionQuestions);
    }

    /**
     * 删除岗位考题维护对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrPositionQuestionsByIds(String ids)
    {
        return hrPositionQuestionsMapper.deleteHrPositionQuestionsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除岗位考题维护信息
     * 
     * @param id 岗位考题维护ID
     * @return 结果
     */
    @Override
    public int deleteHrPositionQuestionsById(String id)
    {
        return hrPositionQuestionsMapper.deleteHrPositionQuestionsById(id);
    }
}
