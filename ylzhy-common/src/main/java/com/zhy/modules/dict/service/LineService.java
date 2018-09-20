package com.zhy.modules.dict.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.dict.entity.LineEntity;

import java.util.Map;

/**
 * 回路列表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 15:04:39
 */
public interface LineService extends IService<LineEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
