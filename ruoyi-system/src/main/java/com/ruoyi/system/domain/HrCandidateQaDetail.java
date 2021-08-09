package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 候选人答题结果对象 hr_candidate_qa_detail
 * 
 * @author DK
 * @date 2021-08-04
 */
public class HrCandidateQaDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 外键position question id */
    @Excel(name = "外键position question id")
    private String positionQuestionId;

    /** 外键 Position.id */
    @Excel(name = "外键 Position.id")
    private String positionId;

    /** 外键 Interview_Question.ID */
    @Excel(name = "外键 Interview_Question.ID")
    private String questionId;

    /** 问题大类 */
    @Excel(name = "问题大类")
    private String questionCategory;

    /** 问题子类 */
    @Excel(name = "问题子类")
    private String questionSubCategory;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String positionName;

    /** 应聘者ID */
    @Excel(name = "应聘者ID")
    private String candidateId;

    /** 应聘者姓名 */
    @Excel(name = "应聘者姓名")
    private String candidateName;

    /** 回答内容 */
    @Excel(name = "回答内容")
    private String candidateAnswer;

    /** 得分 */
    @Excel(name = "得分")
    private Long candidateScore;

    /** 答题批次号 */
    @Excel(name = "答题批次号")
    private String answerBatch;
    
    /** 题目描述 */
    @Excel(name = "题目描述")
    private String question;
    
    /** 题目分数 */
    @Excel(name = "题目分数")
    private Long questionScore;

    public Long getQuestionScore() {
		return questionScore;
	}

	public void setQuestionScore(Long questionScore) {
		this.questionScore = questionScore;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPositionQuestionId(String positionQuestionId) 
    {
        this.positionQuestionId = positionQuestionId;
    }

    public String getPositionQuestionId() 
    {
        return positionQuestionId;
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
    public void setCandidateId(String candidateId) 
    {
        this.candidateId = candidateId;
    }

    public String getCandidateId() 
    {
        return candidateId;
    }
    public void setCandidateName(String candidateName) 
    {
        this.candidateName = candidateName;
    }

    public String getCandidateName() 
    {
        return candidateName;
    }
    public void setCandidateAnswer(String candidateAnswer) 
    {
        this.candidateAnswer = candidateAnswer;
    }

    public String getCandidateAnswer() 
    {
        return candidateAnswer;
    }
    public void setCandidateScore(Long candidateScore) 
    {
        this.candidateScore = candidateScore;
    }

    public Long getCandidateScore() 
    {
        return candidateScore;
    }
    public void setAnswerBatch(String answerBatch) 
    {
        this.answerBatch = answerBatch;
    }

    public String getAnswerBatch() 
    {
        return answerBatch;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("positionQuestionId", getPositionQuestionId())
            .append("positionId", getPositionId())
            .append("questionId", getQuestionId())
            .append("questionCategory", getQuestionCategory())
            .append("questionSubCategory", getQuestionSubCategory())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("positionName", getPositionName())
            .append("candidateId", getCandidateId())
            .append("candidateName", getCandidateName())
            .append("candidateAnswer", getCandidateAnswer())
            .append("candidateScore", getCandidateScore())
            .append("answerBatch", getAnswerBatch())
            .toString();
    }
}
