package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 题库维护对象 hr_interview_questions
 * 
 * @author DK
 * @date 2021-07-28
 */
public class HrInterviewQuestions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 问题内容 */
    @Excel(name = "问题内容")
    private String question;

    /** 问题类型 */
    @Excel(name = "问题类型")
    private String questionFormat;

    /** 正确答案 */
    @Excel(name = "正确答案")
    private String correctAnswer;

    /** 备选答案 */
    @Excel(name = "备选答案")
    private String answerList;

    /** 得分 */
    @Excel(name = "得分")
    private Long questionScore;

    /** 问题分类 */
    @Excel(name = "问题分类")
    private String category;

    /** 问题子类 */
    @Excel(name = "问题子类")
    private String subCategory;

    /**  */
    private Long isEnabled;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setQuestion(String question) 
    {
        this.question = question;
    }

    public String getQuestion() 
    {
        return question;
    }
    public void setQuestionFormat(String questionFormat) 
    {
        this.questionFormat = questionFormat;
    }

    public String getQuestionFormat() 
    {
        return questionFormat;
    }
    public void setCorrectAnswer(String correctAnswer) 
    {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() 
    {
        return correctAnswer;
    }
    public void setAnswerList(String answerList) 
    {
        this.answerList = answerList;
    }

    public String getAnswerList() 
    {
        return answerList;
    }
    public void setQuestionScore(Long questionScore) 
    {
        this.questionScore = questionScore;
    }

    public Long getQuestionScore() 
    {
        return questionScore;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setSubCategory(String subCategory) 
    {
        this.subCategory = subCategory;
    }

    public String getSubCategory() 
    {
        return subCategory;
    }
    public void setIsEnabled(Long isEnabled) 
    {
        this.isEnabled = isEnabled;
    }

    public Long getIsEnabled() 
    {
        return isEnabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("question", getQuestion())
            .append("questionFormat", getQuestionFormat())
            .append("correctAnswer", getCorrectAnswer())
            .append("answerList", getAnswerList())
            .append("questionScore", getQuestionScore())
            .append("category", getCategory())
            .append("subCategory", getSubCategory())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("isEnabled", getIsEnabled())
            .toString();
    }
}
