package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HrCandidateQaSummaryMapper;
import com.ruoyi.system.domain.HrCandidateQaSummary;
import com.ruoyi.system.service.IHrCandidateQaSummaryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 候选人答题结果汇总Service业务层处理
 * 
 * @author DK
 * @date 2021-08-04
 */
@Service
public class HrCandidateQaSummaryServiceImpl implements IHrCandidateQaSummaryService 
{
    @Autowired
    private HrCandidateQaSummaryMapper hrCandidateQaSummaryMapper;

    /**
     * 查询候选人答题结果汇总
     * 
     * @param id 候选人答题结果汇总ID
     * @return 候选人答题结果汇总
     */
    @Override
    public HrCandidateQaSummary selectHrCandidateQaSummaryById(String id)
    {
        return hrCandidateQaSummaryMapper.selectHrCandidateQaSummaryById(id);
    }

    /**
     * 查询候选人答题结果汇总列表
     * 
     * @param hrCandidateQaSummary 候选人答题结果汇总
     * @return 候选人答题结果汇总
     */
    @Override
    public List<HrCandidateQaSummary> selectHrCandidateQaSummaryList(HrCandidateQaSummary hrCandidateQaSummary)
    {
        return hrCandidateQaSummaryMapper.selectHrCandidateQaSummaryList(hrCandidateQaSummary);
    }

    /**
     * 新增候选人答题结果汇总
     * 
     * @param hrCandidateQaSummary 候选人答题结果汇总
     * @return 结果
     */
    @Override
    public int insertHrCandidateQaSummary(HrCandidateQaSummary hrCandidateQaSummary)
    {
        return hrCandidateQaSummaryMapper.insertHrCandidateQaSummary(hrCandidateQaSummary);
    }

    /**
     * 修改候选人答题结果汇总
     * 
     * @param hrCandidateQaSummary 候选人答题结果汇总
     * @return 结果
     */
    @Override
    public int updateHrCandidateQaSummary(HrCandidateQaSummary hrCandidateQaSummary)
    {
        return hrCandidateQaSummaryMapper.updateHrCandidateQaSummary(hrCandidateQaSummary);
    }

    /**
     * 删除候选人答题结果汇总对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateQaSummaryByIds(String ids)
    {
        return hrCandidateQaSummaryMapper.deleteHrCandidateQaSummaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除候选人答题结果汇总信息
     * 
     * @param id 候选人答题结果汇总ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateQaSummaryById(String id)
    {
        return hrCandidateQaSummaryMapper.deleteHrCandidateQaSummaryById(id);
    }
}
