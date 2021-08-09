package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HrCandidateQaDetailMapper;
import com.ruoyi.system.domain.HrCandidateQaDetail;
import com.ruoyi.system.domain.HrCandidateQaSum_Customize;
import com.ruoyi.system.service.IHrCandidateQaDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 候选人答题结果Service业务层处理
 * 
 * @author DK
 * @date 2021-08-04
 */
@Service
public class HrCandidateQaDetailServiceImpl implements IHrCandidateQaDetailService 
{
    @Autowired
    private HrCandidateQaDetailMapper hrCandidateQaDetailMapper;

    /**
     * 查询候选人答题结果
     * 
     * @param id 候选人答题结果ID
     * @return 候选人答题结果
     */
    @Override
    public HrCandidateQaDetail selectHrCandidateQaDetailById(String id)
    {
        return hrCandidateQaDetailMapper.selectHrCandidateQaDetailById(id);
    }

    /**
     * 查询候选人答题结果列表
     * 
     * @param hrCandidateQaDetail 候选人答题结果
     * @return 候选人答题结果
     */
    @Override
    public List<HrCandidateQaDetail> selectHrCandidateQaDetailList(HrCandidateQaDetail hrCandidateQaDetail)
    {
        return hrCandidateQaDetailMapper.selectHrCandidateQaDetailList(hrCandidateQaDetail);
    }

    /**
     * 根据候选人ID，查询候选人最新的答题结果列表
     * 
     * @param id 候选人ID
     * @return 候选人答题结果集合
     */
    public List<HrCandidateQaDetail> selectHrCandidateQaDetailByCandidateId(String id){
    	return hrCandidateQaDetailMapper.selectHrCandidateQaDetailByCandidateId(id);
    }
    
    /**
     * 根据候选人ID、答题批次号，查询候选人各大类的得分情况
     * 
     * @param id 候选人ID 答题批次号
     * @return 候选人答题结果按category大类汇总的分数
     */
    public List<HrCandidateQaSum_Customize> selectScoreSummaryByCategoryByCan_Batch(HrCandidateQaSum_Customize obj){
    	return hrCandidateQaDetailMapper.selectScoreSummaryByCategoryByCan_Batch(obj);
    }
    
    /**
     * 新增候选人答题结果
     * 
     * @param hrCandidateQaDetail 候选人答题结果
     * @return 结果
     */
    @Override
    public int insertHrCandidateQaDetail(HrCandidateQaDetail hrCandidateQaDetail)
    {
        hrCandidateQaDetail.setCreateTime(DateUtils.getNowDate());
        return hrCandidateQaDetailMapper.insertHrCandidateQaDetail(hrCandidateQaDetail);
    }

    /**
     * 修改候选人答题结果
     * 
     * @param hrCandidateQaDetail 候选人答题结果
     * @return 结果
     */
    @Override
    public int updateHrCandidateQaDetail(HrCandidateQaDetail hrCandidateQaDetail)
    {
        return hrCandidateQaDetailMapper.updateHrCandidateQaDetail(hrCandidateQaDetail);
    }

    /**
     * 删除候选人答题结果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateQaDetailByIds(String ids)
    {
        return hrCandidateQaDetailMapper.deleteHrCandidateQaDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除候选人答题结果信息
     * 
     * @param id 候选人答题结果ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateQaDetailById(String id)
    {
        return hrCandidateQaDetailMapper.deleteHrCandidateQaDetailById(id);
    }
}
