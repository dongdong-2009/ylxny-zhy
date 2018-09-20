package com.zhy.modules.summary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.summary.dao.SummaryWeekDao;
import com.zhy.modules.summary.entity.SummaryWeekEntity;
import com.zhy.modules.summary.service.SummaryWeekService;


@Service("summaryWeekService")
public class SummaryWeekServiceImpl extends ServiceImpl<SummaryWeekDao, SummaryWeekEntity> implements SummaryWeekService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SummaryWeekEntity> page = this.selectPage(
                new Query<SummaryWeekEntity>(params).getPage(),
                new EntityWrapper<SummaryWeekEntity>()
        );

        return new PageUtils(page);
    }

}
