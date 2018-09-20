package com.zhy.modules.summary.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 统计表（按天统计）
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-20 10:42:06
 */
@TableName("dc_summary_year")
public class SummaryYearEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 年份
	 */
	private Integer year;
	/**
	 * 年度用电量
	 */
	private Double year_power;
	/**
	 * 年度总电量 即年度电表读数
	 */
	private Double year_total_power;
	/**
	 * 站点id
	 */
	private Long station_id;
	/**
	 * 站点名称
	 */
	private String station_name;
	/**
	 * 回路id
	 */
	private Long line_id;
	/**
	 * 回路名称
	 */
	private String line_name;
	/**
	 * 公司id
	 */
	private Long company_id;
	/**
	 * 日最大负荷
	 */
	private Double max_fuhe;
	/**
	 * 日最大负荷时间
	 */
	private Date max_fuhe_time;
	/**
	 * 日功率因数
	 */
	private Double power_factor;
	/**
	 * 最小负荷
	 */
	private Double min_fuhe;
	/**
	 * 最小负荷时间
	 */
	private Date min_fuhe_time;
	/**
	 * 平均负荷
	 */
	private Double avg_fuhe;
	/**
	 * 峰谷差
	 */
	private Double p_r_aprt;
	/**
	 * 峰谷率
	 */
	private Double p_r_rate;
	/**
	 * 负荷率
	 */
	private Double fuhe_rate;

	/**
	 * 设置：
	 */
	public void setid(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getid() {
		return id;
	}
	/**
	 * 设置：年份
	 */
	public void setyear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年份
	 */
	public Integer getyear() {
		return year;
	}
	/**
	 * 设置：年度用电量
	 */
	public void setyear_power(Double year_power) {
		this.year_power = year_power;
	}
	/**
	 * 获取：年度用电量
	 */
	public Double getyear_power() {
		return year_power;
	}
	/**
	 * 设置：年度总电量 即年度电表读数
	 */
	public void setyear_total_power(Double year_total_power) {
		this.year_total_power = year_total_power;
	}
	/**
	 * 获取：年度总电量 即年度电表读数
	 */
	public Double getyear_total_power() {
		return year_total_power;
	}
	/**
	 * 设置：站点id
	 */
	public void setstation_id(Long station_id) {
		this.station_id = station_id;
	}
	/**
	 * 获取：站点id
	 */
	public Long getstation_id() {
		return station_id;
	}
	/**
	 * 设置：站点名称
	 */
	public void setstation_name(String station_name) {
		this.station_name = station_name;
	}
	/**
	 * 获取：站点名称
	 */
	public String getstation_name() {
		return station_name;
	}
	/**
	 * 设置：回路id
	 */
	public void setline_id(Long line_id) {
		this.line_id = line_id;
	}
	/**
	 * 获取：回路id
	 */
	public Long getline_id() {
		return line_id;
	}
	/**
	 * 设置：回路名称
	 */
	public void setline_name(String line_name) {
		this.line_name = line_name;
	}
	/**
	 * 获取：回路名称
	 */
	public String getline_name() {
		return line_name;
	}
	/**
	 * 设置：公司id
	 */
	public void setcompany_id(Long company_id) {
		this.company_id = company_id;
	}
	/**
	 * 获取：公司id
	 */
	public Long getcompany_id() {
		return company_id;
	}
	/**
	 * 设置：日最大负荷
	 */
	public void setmax_fuhe(Double max_fuhe) {
		this.max_fuhe = max_fuhe;
	}
	/**
	 * 获取：日最大负荷
	 */
	public Double getmax_fuhe() {
		return max_fuhe;
	}
	/**
	 * 设置：日最大负荷时间
	 */
	public void setmax_fuhe_time(Date max_fuhe_time) {
		this.max_fuhe_time = max_fuhe_time;
	}
	/**
	 * 获取：日最大负荷时间
	 */
	public Date getmax_fuhe_time() {
		return max_fuhe_time;
	}
	/**
	 * 设置：日功率因数
	 */
	public void setpower_factor(Double power_factor) {
		this.power_factor = power_factor;
	}
	/**
	 * 获取：日功率因数
	 */
	public Double getpower_factor() {
		return power_factor;
	}
	/**
	 * 设置：最小负荷
	 */
	public void setmin_fuhe(Double min_fuhe) {
		this.min_fuhe = min_fuhe;
	}
	/**
	 * 获取：最小负荷
	 */
	public Double getmin_fuhe() {
		return min_fuhe;
	}
	/**
	 * 设置：最小负荷时间
	 */
	public void setmin_fuhe_time(Date min_fuhe_time) {
		this.min_fuhe_time = min_fuhe_time;
	}
	/**
	 * 获取：最小负荷时间
	 */
	public Date getmin_fuhe_time() {
		return min_fuhe_time;
	}
	/**
	 * 设置：平均负荷
	 */
	public void setavg_fuhe(Double avg_fuhe) {
		this.avg_fuhe = avg_fuhe;
	}
	/**
	 * 获取：平均负荷
	 */
	public Double getavg_fuhe() {
		return avg_fuhe;
	}
	/**
	 * 设置：峰谷差
	 */
	public void setp_r_aprt(Double p_r_aprt) {
		this.p_r_aprt = p_r_aprt;
	}
	/**
	 * 获取：峰谷差
	 */
	public Double getp_r_aprt() {
		return p_r_aprt;
	}
	/**
	 * 设置：峰谷率
	 */
	public void setp_r_rate(Double p_r_rate) {
		this.p_r_rate = p_r_rate;
	}
	/**
	 * 获取：峰谷率
	 */
	public Double getp_r_rate() {
		return p_r_rate;
	}
	/**
	 * 设置：负荷率
	 */
	public void setfuhe_rate(Double fuhe_rate) {
		this.fuhe_rate = fuhe_rate;
	}
	/**
	 * 获取：负荷率
	 */
	public Double getfuhe_rate() {
		return fuhe_rate;
	}
}
