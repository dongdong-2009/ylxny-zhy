package com.zhy.modules.log.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.log.entity.FailLogEntity;

import java.util.Map;

/**
 * 采集操作失败记录
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 17:58:02
 */
public interface FailLogService extends IService<FailLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

