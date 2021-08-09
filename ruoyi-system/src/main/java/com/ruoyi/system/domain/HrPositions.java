package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 岗位信息对象 hr_positions
 * 
 * @author DK
 * @date 2021-07-28
 */
public class HrPositions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String positionName;

    /** 岗位类型 */
    @Excel(name = "岗位类型")
    private String category;

    /** 需求部门 */
    @Excel(name = "需求部门")
    private String requestDepartment;

    /** 岗位职责 */
    @Excel(name = "岗位职责")
    private String responsibility;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private Long isEnabled;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPositionName(String positionName) 
    {
        this.positionName = positionName;
    }

    public String getPositionName() 
    {
        return positionName;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setRequestDepartment(String requestDepartment) 
    {
        this.requestDepartment = requestDepartment;
    }

    public String getRequestDepartment() 
    {
        return requestDepartment;
    }
    public void setResponsibility(String responsibility) 
    {
        this.responsibility = responsibility;
    }

    public String getResponsibility() 
    {
        return responsibility;
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
            .append("positionName", getPositionName())
            .append("category", getCategory())
            .append("requestDepartment", getRequestDepartment())
            .append("responsibility", getResponsibility())
            .append("isEnabled", getIsEnabled())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
