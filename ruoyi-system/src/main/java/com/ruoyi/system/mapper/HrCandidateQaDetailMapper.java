package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HrCandidateQaDetail;
import com.ruoyi.system.domain.HrCandidateQaSum_Customize;

/**
 * 候选人答题结果Mapper接口
 * 
 * @author DK
 * @date 2021-08-04
 */
public interface HrCandidateQaDetailMapper 
{
    /**
     * 查询候选人答题结果
     * 
     * @param id 候选人答题结果ID
     * @return 候选人答题结果
     */
    public HrCandidateQaDetail selectHrCandidateQaDetailById(String id);

    /**
     * 查询候选人答题结果列表
     * 
     * @param hrCandidateQaDetail 候选人答题结果
     * @return 候选人答题结果集合
     */
    public List<HrCandidateQaDetail> selectHrCandidateQaDetailList(HrCandidateQaDetail hrCandidateQaDetail);
    
    /**
     * 根据候选人ID，查询候选人最新的答题结果列表
     * 
     * @param id 候选人ID
     * @return 候选人答题结果集合
     */
    public List<HrCandidateQaDetail> selectHrCandidateQaDetailByCandidateId(String id);
    
    /**
     * 根据候选人ID、答题批次号，查询候选人各大类的得分情况
     * 
     * @param id 候选人ID 答题批次号
     * @return 候选人答题结果按category大类汇总的分数
     */
    public List<HrCandidateQaSum_Customize> selectScoreSummaryByCategoryByCan_Batch(HrCandidateQaSum_Customize obj);
    //<select id="selectScoreSummaryByCategoryByCan_Batch"  parameterType="HrCandidateQaSum_Customize" resultMap="HrCandidateQaSum_Customize">
    
    /**
     * 新增候选人答题结果
     * 
     * @param hrCandidateQaDetail 候选人答题结果
     * @return 结果
     */
    public int insertHrCandidateQaDetail(HrCandidateQaDetail hrCandidateQaDetail);

    /**
     * 修改候选人答题结果
     * 
     * @param hrCandidateQaDetail 候选人答题结果
     * @return 结果
     */
    public int updateHrCandidateQaDetail(HrCandidateQaDetail hrCandidateQaDetail);

    /**
     * 删除候选人答题结果
     * 
     * @param id 候选人答题结果ID
     * @return 结果
     */
    public int deleteHrCandidateQaDetailById(String id);

    /**
     * 批量删除候选人答题结果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrCandidateQaDetailByIds(String[] ids);
}
