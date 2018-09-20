package com.zhy.modules.dict.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.dict.entity.DmDictlxEntity;

/**
 * 代码类型表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:27:51
 */
public interface DmDictlxService extends IService<DmDictlxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

