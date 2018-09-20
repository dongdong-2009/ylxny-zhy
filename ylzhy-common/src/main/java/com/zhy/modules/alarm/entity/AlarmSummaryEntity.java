package com.zhy.modules.alarm.entity;

/**
 * @Package com.zhy.modules.alarm.entity
 * @Description:
 * @User: zengqiang
 * @Date: 2018-09-17
 */
public class AlarmSummaryEntity {
    private long company_id;
    private long station_id;
    private long line_id;
    private String line_name;
    private int counts;

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public long getStation_id() {
        return station_id;
    }

    public void setStation_id(long station_id) {
        this.station_id = station_id;
    }

    public long getLine_id() {
        return line_id;
    }

    public void setLine_id(long line_id) {
        this.line_id = line_id;
    }

    public String getLine_name() {
        return line_name;
    }

    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}