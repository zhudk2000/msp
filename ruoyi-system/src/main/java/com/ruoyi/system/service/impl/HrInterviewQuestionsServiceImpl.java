package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.uuid.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HrInterviewQuestionsMapper;
import com.ruoyi.system.domain.HrInterviewQuestions;
import com.ruoyi.system.service.IHrInterviewQuestionsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 题库维护Service业务层处理
 * 
 * @author DK
 * @date 2021-07-28
 */
@Service
public class HrInterviewQuestionsServiceImpl implements IHrInterviewQuestionsService 
{
    @Autowired
    private HrInterviewQuestionsMapper hrInterviewQuestionsMapper;

    /**
     * 查询题库维护
     * 
     * @param id 题库维护ID
     * @return 题库维护
     */
    @Override
    public HrInterviewQuestions selectHrInterviewQuestionsById(String id)
    {
        return hrInterviewQuestionsMapper.selectHrInterviewQuestionsById(id);
    }

    /**
     * 查询题库维护列表
     * 
     * @param hrInterviewQuestions 题库维护
     * @return 题库维护
     */
    @Override
    public List<HrInterviewQuestions> selectHrInterviewQuestionsList(HrInterviewQuestions hrInterviewQuestions)
    {
        return hrInterviewQuestionsMapper.selectHrInterviewQuestionsList(hrInterviewQuestions);
    }

    /**
     * 根据岗位与问题对应表的id，返回问题信息列表
     * @param id
     * @return 题库集合
     */
    @Override
    public List<HrInterviewQuestions> selectHrInterviewQuestionsByPQId(String id){
    	return hrInterviewQuestionsMapper.selectHrInterviewQuestionsByPQId(id);
    }
    
    /**
     * 返回所有大类和子类
     * @return 题库维护集合
     */
    @Override
    public List<HrInterviewQuestions> selectAllCateSubCate(){
    	return hrInterviewQuestionsMapper.selectAllCateSubCate();
    }
    
    /**
     * 新增题库维护
     * 
     * @param hrInterviewQuestions 题库维护
     * @return 结果
     */
    @Override
    public int insertHrInterviewQuestions(HrInterviewQuestions hrInterviewQuestions)
    {
    	hrInterviewQuestions.setId(UUID.randomUUID().toString());
    	hrInterviewQuestions.setCreateBy(ShiroUtils.getLoginName());
        hrInterviewQuestions.setCreateTime(DateUtils.getNowDate());
        return hrInterviewQuestionsMapper.insertHrInterviewQuestions(hrInterviewQuestions);
    }

    /**
     * 修改题库维护
     * 
     * @param hrInterviewQuestions 题库维护
     * @return 结果
     */
    @Override
    public int updateHrInterviewQuestions(HrInterviewQuestions hrInterviewQuestions)
    {
    	hrInterviewQuestions.setUpdateBy(ShiroUtils.getLoginName());
        hrInterviewQuestions.setUpdateTime(DateUtils.getNowDate());
        return hrInterviewQuestionsMapper.updateHrInterviewQuestions(hrInterviewQuestions);
    }

    /**
     * 删除题库维护对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrInterviewQuestionsByIds(String ids)
    {
        return hrInterviewQuestionsMapper.deleteHrInterviewQuestionsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除题库维护信息
     * 
     * @param id 题库维护ID
     * @return 结果
     */
    @Override
    public int deleteHrInterviewQuestionsById(String id)
    {
        return hrInterviewQuestionsMapper.deleteHrInterviewQuestionsById(id);
    }
}
