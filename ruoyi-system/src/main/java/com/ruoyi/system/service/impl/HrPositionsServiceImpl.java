package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.uuid.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HrPositionsMapper;
import com.ruoyi.system.domain.HrPositions;
import com.ruoyi.system.service.IHrPositionsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 岗位信息Service业务层处理
 * 
 * @author DK
 * @date 2021-07-28
 */
@Service
public class HrPositionsServiceImpl implements IHrPositionsService 
{
    @Autowired
    private HrPositionsMapper hrPositionsMapper;

    /**
     * 查询岗位信息
     * 
     * @param id 岗位信息ID
     * @return 岗位信息
     */
    @Override
    public HrPositions selectHrPositionsById(String id)
    {
        return hrPositionsMapper.selectHrPositionsById(id);
    }

    /**
     * 查询岗位信息列表
     * 
     * @param hrPositions 岗位信息
     * @return 岗位信息
     */
    @Override
    public List<HrPositions> selectHrPositionsList(HrPositions hrPositions)
    {
        return hrPositionsMapper.selectHrPositionsList(hrPositions);
    }

    /**
     * 
     */
    public List<HrPositions> selectHrPositionsAll(){
    	return hrPositionsMapper.selectHrPositionsAll();
    }
    
    /**
     * 新增岗位信息
     * 
     * @param hrPositions 岗位信息
     * @return 结果
     */
    @Override
    public int insertHrPositions(HrPositions hrPositions)
    {
    	String userName = ShiroUtils.getLoginName();
    	hrPositions.setId(UUID.randomUUID().toString());
        hrPositions.setCreateTime(DateUtils.getNowDate());
        hrPositions.setCreateBy(userName);
        hrPositions.setIsEnabled(1L);
        return hrPositionsMapper.insertHrPositions(hrPositions);
    }

    /**
     * 修改岗位信息
     * 
     * @param hrPositions 岗位信息
     * @return 结果
     */
    @Override
    public int updateHrPositions(HrPositions hrPositions)
    {
    	hrPositions.setUpdateBy(ShiroUtils.getLoginName());
    	hrPositions.setUpdateTime(DateUtils.getNowDate());
        return hrPositionsMapper.updateHrPositions(hrPositions);
    }

    /**
     * 删除岗位信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHrPositionsByIds(String ids)
    {
        return hrPositionsMapper.deleteHrPositionsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除岗位信息信息
     * 
     * @param id 岗位信息ID
     * @return 结果
     */
    @Override
    public int deleteHrPositionsById(String id)
    {
        return hrPositionsMapper.deleteHrPositionsById(id);
    }
}
