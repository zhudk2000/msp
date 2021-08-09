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
public class HrCandidateQaSum_Customize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String questionCategory;
	private Long maxScore;
    private Long score;
    private String candidateId;
    private String answerBatch;
    
    public String getQuestionCategory() {
		return questionCategory;
	}


	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}


	public Long getMaxScore() {
		return maxScore;
	}


	public void setMaxScore(Long maxScore) {
		this.maxScore = maxScore;
	}


	public Long getScore() {
		return score;
	}


	public void setScore(Long score) {
		this.score = score;
	}
   
	
    public String getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}


	public String getAnswerBatch() {
		return answerBatch;
	}


	public void setAnswerBatch(String answerBatch) {
		this.answerBatch = answerBatch;
	}


	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("questionCategory:",getQuestionCategory())
            .append("maxScore:",  getMaxScore().toString())
            .append("score:",  getScore().toString())
            .append("candidateId:", getCandidateId())
            .append("answerBatch:", getAnswerBatch())
            .toString();
    }
}
