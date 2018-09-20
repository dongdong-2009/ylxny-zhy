package com.zhy.modules.report.entity;

import java.util.List;

/**
 * @Package com.zhy.modules.report.entity
 * @Description:
 * @User: zengqiang
 * @Date: 2018-09-19
 */
public class FuheReportEntity {
    private String stationName;
    private String lineName;
    private double maxFuhe;
    private String maxFuheTime;
    private double minFuhe;
    private String minFuheTime;
    private double avgFuhe;
    private double p_r_aprt;
    private double p_r_rate;
    private double fuhe_rate;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public double getMaxFuhe() {
        return maxFuhe;
    }

    public void setMaxFuhe(double maxFuhe) {
        this.maxFuhe = maxFuhe;
    }

    public String getMaxFuheTime() {
        return maxFuheTime;
    }

    public void setMaxFuheTime(String maxFuheTime) {
        this.maxFuheTime = maxFuheTime;
    }

    public double getMinFuhe() {
        return minFuhe;
    }

    public void setMinFuhe(double minFuhe) {
        this.minFuhe = minFuhe;
    }

    public String getMinFuheTime() {
        return minFuheTime;
    }

    public void setMinFuheTime(String minFuheTime) {
        this.minFuheTime = minFuheTime;
    }

    public double getAvgFuhe() {
        return avgFuhe;
    }

    public void setAvgFuhe(double avgFuhe) {
        this.avgFuhe = avgFuhe;
    }

    public double getP_r_aprt() {
        return p_r_aprt;
    }

    public void setP_r_aprt(double p_r_aprt) {
        this.p_r_aprt = p_r_aprt;
    }

    public double getP_r_rate() {
        return p_r_rate;
    }

    public void setP_r_rate(double p_r_rate) {
        this.p_r_rate = p_r_rate;
    }

    public double getFuhe_rate() {
        return fuhe_rate;
    }

    public void setFuhe_rate(double fuhe_rate) {
        this.fuhe_rate = fuhe_rate;
    }
}