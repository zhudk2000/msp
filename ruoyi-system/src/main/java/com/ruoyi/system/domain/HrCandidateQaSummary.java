package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 候选人答题结果汇总对象 hr_candidate_qa_summary
 * 
 * @author DK
 * @date 2021-08-04
 */
public class HrCandidateQaSummary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 外键 Position id */
    @Excel(name = "外键 Position id")
    private String positionId;

    /** 问题大类 */
    @Excel(name = "问题大类")
    private String questionCategory;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String positionName;

    /** 应聘者ID */
    @Excel(name = "应聘者ID")
    private String candidateId;

    /** 应聘者姓名 */
    @Excel(name = "应聘者姓名")
    private String candidateName;

    /** 得分 */
    @Excel(name = "得分")
    private Long candidateScore;

    /** 答题批次号 */
    @Excel(name = "答题批次号")
    private String answerBatch;

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
    public void setQuestionCategory(String questionCategory) 
    {
        this.questionCategory = questionCategory;
    }

    public String getQuestionCategory() 
    {
        return questionCategory;
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
            .append("positionId", getPositionId())
            .append("questionCategory", getQuestionCategory())
            .append("positionName", getPositionName())
            .append("candidateId", getCandidateId())
            .append("candidateName", getCandidateName())
            .append("candidateScore", getCandidateScore())
            .append("answerBatch", getAnswerBatch())
            .toString();
    }
}
