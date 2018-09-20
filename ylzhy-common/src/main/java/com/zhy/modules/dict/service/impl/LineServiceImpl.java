package com.zhy.modules.dict.service.impl;

import com.zhy.modules.dict.entity.LineEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.dict.dao.LineDao;
import com.zhy.modules.dict.service.LineService;


@Service("lineService")
public class LineServiceImpl extends ServiceImpl<LineDao, LineEntity> implements LineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LineEntity> page = this.selectPage(
                new Query<LineEntity>(params).getPage(),
                new EntityWrapper<LineEntity>()
        );

        return new PageUtils(page);
    }

}
