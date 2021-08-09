package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HrCandidateQaSummary;

/**
 * 候选人答题结果汇总Mapper接口
 * 
 * @author DK
 * @date 2021-08-04
 */
public interface HrCandidateQaSummaryMapper 
{
    /**
     * 查询候选人答题结果汇总
     * 
     * @param id 候选人答题结果汇总ID
     * @return 候选人答题结果汇总
     */
    public HrCandidateQaSummary selectHrCandidateQaSummaryById(String id);

    /**
     * 查询候选人答题结果汇总列表
     * 
     * @param hrCandidateQaSummary 候选人答题结果汇总
     * @return 候选人答题结果汇总集合
     */
    public List<HrCandidateQaSummary> selectHrCandidateQaSummaryList(HrCandidateQaSummary hrCandidateQaSummary);

    /**
     * 新增候选人答题结果汇总
     * 
     * @param hrCandidateQaSummary 候选人答题结果汇总
     * @return 结果
     */
    public int insertHrCandidateQaSummary(HrCandidateQaSummary hrCandidateQaSummary);

    /**
     * 修改候选人答题结果汇总
     * 
     * @param hrCandidateQaSummary 候选人答题结果汇总
     * @return 结果
     */
    public int updateHrCandidateQaSummary(HrCandidateQaSummary hrCandidateQaSummary);

    /**
     * 删除候选人答题结果汇总
     * 
     * @param id 候选人答题结果汇总ID
     * @return 结果
     */
    public int deleteHrCandidateQaSummaryById(String id);

    /**
     * 批量删除候选人答题结果汇总
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrCandidateQaSummaryByIds(String[] ids);
}
