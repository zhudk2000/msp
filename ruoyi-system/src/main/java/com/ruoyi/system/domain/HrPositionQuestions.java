package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 岗位考题维护对象 hr_position_questions
 * 
 * @author DK
 * @date 2021-07-28
 */
public class HrPositionQuestions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 岗位编号 */
    @Excel(name = "岗位编号")
    private String positionId;

    /** 问题编号 */
    @Excel(name = "问题编号")
    private String questionId;

    /** 问题大类 */
    @Excel(name = "问题大类")
    private String questionCategory;

    /** 问题子类 */
    @Excel(name = "问题子类")
    private String questionSubCategory;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String positionName;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPositionId(String positionId) 
    {
        this.positionId = positionId;
    }

    public String getPositionId() 
    {
        return positionId;
    }
    public void setQuestionId(String questionId) 
    {
        this.questionId = questionId;
    }

    public String getQuestionId() 
    {
        return questionId;
    }
    public void setQuestionCategory(String questionCategory) 
    {
        this.questionCategory = questionCategory;
    }

    public String getQuestionCategory() 
    {
        return questionCategory;
    }
    public void setQuestionSubCategory(String questionSubCategory) 
    {
        this.questionSubCategory = questionSubCategory;
    }

    public String getQuestionSubCategory() 
    {
        return questionSubCategory;
    }
    public void setPositionName(String positionName) 
    {
        this.positionName = positionName;
    }

    public String getPositionName() 
    {
        return positionName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("positionId", getPositionId())
            .append("questionId", getQuestionId())
            .append("questionCategory", getQuestionCategory())
            .append("questionSubCategory", getQuestionSubCategory())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("positionName", getPositionName())
            .toString();
    }
}
