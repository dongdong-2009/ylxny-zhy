package com.zhy.modules.summary.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhy.modules.summary.entity.SummaryHourEntity;

/**
 * 统计表（按天统计）
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-14 17:38:33
 */
public interface SummaryHourDao extends BaseMapper<SummaryHourEntity> {

	List<SummaryHourEntity> selectMaxFuheFull(Map<String,String> params);
	
}
