package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 候选人信息对象 hr_candidate
 * 
 * @author DK
 * @date 2021-07-27
 */
public class HrCandidate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 中文姓名 */
    @Excel(name = "中文姓名")
    private String cname;

    /** 英文姓名 */
    @Excel(name = "英文姓名")
    private String ename;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 工作经历 */
    @Excel(name = "工作经历")
    private String workingHistory;

    /** 学历信息 */
    @Excel(name = "学历信息")
    private String educationInfo;

    /** 初面时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "初面时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date interviewTime1;

    /** 面试人 */
    @Excel(name = "面试人")
    private String interviewBy1;

    /** HR联系时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "HR联系时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hrContactTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 求职岗位 */
    @Excel(name = "求职岗位")
    private String interviewPosition1;
    /** 求职岗位ID */
    @Excel(name = "求职岗位ID")
    private String interviewPosition1Id;

	/** 手机号码 */
    @Excel(name = "手机号码")
    private String contactInfo;

    /** 其他联系方式 */
    @Excel(name = "其他联系方式")
    private String otherContactInfo;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCname(String cname) 
    {
        this.cname = cname;
    }

    public String getCname() 
    {
        return cname;
    }
    public void setEname(String ename) 
    {
        this.ename = ename;
    }

    public String getEname() 
    {
        return ename;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setWorkingHistory(String workingHistory) 
    {
        this.workingHistory = workingHistory;
    }

    public String getWorkingHistory() 
    {
        return workingHistory;
    }
    public void setEducationInfo(String educationInfo) 
    {
        this.educationInfo = educationInfo;
    }

    public String getEducationInfo() 
    {
        return educationInfo;
    }
    public void setInterviewTime1(Date interviewTime1) 
    {
        this.interviewTime1 = interviewTime1;
    }

    public Date getInterviewTime1() 
    {
        return interviewTime1;
    }
    public void setInterviewBy1(String interviewBy1) 
    {
        this.interviewBy1 = interviewBy1;
    }

    public String getInterviewBy1() 
    {
        return interviewBy1;
    }
    public void setHrContactTime(Date hrContactTime) 
    {
        this.hrContactTime = hrContactTime;
    }

    public Date getHrContactTime() 
    {
        return hrContactTime;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setInterviewPosition1(String interviewPosition1) 
    {
        this.interviewPosition1 = interviewPosition1;
    }

    public String getInterviewPosition1() 
    {
        return interviewPosition1;
    }
    public String getInterviewPosition1Id() {
		return interviewPosition1Id;
	}

	public void setInterviewPosition1Id(String interviewPosition1Id) {
		this.interviewPosition1Id = interviewPosition1Id;
	}
    public void setContactInfo(String contactInfo) 
    {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() 
    {
        return contactInfo;
    }
    public void setOtherContactInfo(String otherContactInfo) 
    {
        this.otherContactInfo = otherContactInfo;
    }

    public String getOtherContactInfo() 
    {
        return otherContactInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cname", getCname())
            .append("ename", getEname())
            .append("gender", getGender())
            .append("age", getAge())
            .append("workingHistory", getWorkingHistory())
            .append("educationInfo", getEducationInfo())
            .append("interviewTime1", getInterviewTime1())
            .append("interviewBy1", getInterviewBy1())
            .append("hrContactTime", getHrContactTime())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("interviewPosition1", getInterviewPosition1())
            .append("contactInfo", getContactInfo())
            .append("otherContactInfo", getOtherContactInfo())
            .append("interviewPosition1Id", getInterviewPosition1Id())
            .toString();
    }
}
