package com.zhy.modules.alarm.entity;

import java.util.Date;

/**
 * @Package com.zhy.modules.alarm.entity
 * @Description:
 * @User: zengqiang
 * @Date: 2018-09-17
 */
public class AlarmRankEntity {
    private String alarm_name;

    private int counts;

    private Date alarm_time;

    public String getAlarm_name() {
        return alarm_name;
    }

    public void setAlarm_name(String alarm_name) {
        this.alarm_name = alarm_name;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public Date getAlarm_time() {
        return alarm_time;
    }

    public void setAlarm_time(Date alarm_time) {
        this.alarm_time = alarm_time;
    }
}