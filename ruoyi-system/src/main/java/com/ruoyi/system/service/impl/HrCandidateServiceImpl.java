package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HrCandidateMapper;
import com.ruoyi.system.domain.HrCandidate;
import com.ruoyi.system.service.IHrCandidateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 候选人信息Service业务层处理
 * 
 * @author DK
 * @date 2021-07-27
 */
@Service
public class HrCandidateServiceImpl implements IHrCandidateService 
{
    @Autowired
    private HrCandidateMapper hrCandidateMapper;

    /**
     * 查询候选人信息
     * 
     * @param id 候选人信息ID
     * @return 候选人信息
     */
    @Override
    public HrCandidate selectHrCandidateById(String id)
    {
        return hrCandidateMapper.selectHrCandidateById(id);
    }

    /**
     * 查询候选人信息列表
     * 
     * @param hrCandidate 候选人信息
     * @return 候选人信息
     */
    @Override
    public List<HrCandidate> selectHrCandidateList(HrCandidate hrCandidate)
    {
        return hrCandidateMapper.selectHrCandidateList(hrCandidate);
    }

    /**
     * 新增候选人信息
     * 
     * @param hrCandidate 候选人信息
     * @return 结果
     */
    @Override
    public int insertHrCandidate(HrCandidate hrCandidate)
    {
        hrCandidate.setCreateTime(DateUtils.getNowDate());
        hrCandidate.setId(UUID.randomUUID().toString());
        return hrCandidateMapper.insertHrCandidate(hrCandidate);
    }

    /**
     * 修改候选人信息
     * 
     * @param hrCandidate 候选人信息
     * @return 结果
     */
    @Override
    public int updateHrCandidate(HrCandidate hrCandidate)
    {
        return hrCandidateMapper.updateHrCandidate(hrCandidate);
    }

    /**
     * 删除候选人信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateByIds(String ids)
    {
        return hrCandidateMapper.deleteHrCandidateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除候选人信息信息
     * 
     * @param id 候选人信息ID
     * @return 结果
     */
    @Override
    public int deleteHrCandidateById(String id)
    {
        return hrCandidateMapper.deleteHrCandidateById(id);
    }
}
