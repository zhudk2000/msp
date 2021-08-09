package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HrPositions;

/**
 * 岗位信息Mapper接口
 * 
 * @author DK
 * @date 2021-07-28
 */
public interface HrPositionsMapper 
{
    /**
     * 查询岗位信息
     * 
     * @param id 岗位信息ID
     * @return 岗位信息
     */
    public HrPositions selectHrPositionsById(String id);

    /**
     * 查询岗位信息列表
     * 
     * @param hrPositions 岗位信息
     * @return 岗位信息集合
     */
    public List<HrPositions> selectHrPositionsList(HrPositions hrPositions);

    /**
     * 
     */
    public List<HrPositions> selectHrPositionsAll();
    
    /**
     * 新增岗位信息
     * 
     * @param hrPositions 岗位信息
     * @return 结果
     */
    public int insertHrPositions(HrPositions hrPositions);

    /**
     * 修改岗位信息
     * 
     * @param hrPositions 岗位信息
     * @return 结果
     */
    public int updateHrPositions(HrPositions hrPositions);

    /**
     * 删除岗位信息
     * 
     * @param id 岗位信息ID
     * @return 结果
     */
    public int deleteHrPositionsById(String id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrPositionsByIds(String[] ids);
}
