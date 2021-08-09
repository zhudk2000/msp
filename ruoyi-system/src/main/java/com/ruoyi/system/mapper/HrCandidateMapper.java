package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HrCandidate;

/**
 * 候选人信息Mapper接口
 * 
 * @author DK
 * @date 2021-07-27
 */
public interface HrCandidateMapper 
{
    /**
     * 查询候选人信息
     * 
     * @param id 候选人信息ID
     * @return 候选人信息
     */
    public HrCandidate selectHrCandidateById(String id);

    /**
     * 查询候选人信息列表
     * 
     * @param hrCandidate 候选人信息
     * @return 候选人信息集合
     */
    public List<HrCandidate> selectHrCandidateList(HrCandidate hrCandidate);

    /**
     * 新增候选人信息
     * 
     * @param hrCandidate 候选人信息
     * @return 结果
     */
    public int insertHrCandidate(HrCandidate hrCandidate);

    /**
     * 修改候选人信息
     * 
     * @param hrCandidate 候选人信息
     * @return 结果
     */
    public int updateHrCandidate(HrCandidate hrCandidate);

    /**
     * 删除候选人信息
     * 
     * @param id 候选人信息ID
     * @return 结果
     */
    public int deleteHrCandidateById(String id);

    /**
     * 批量删除候选人信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrCandidateByIds(String[] ids);
}
