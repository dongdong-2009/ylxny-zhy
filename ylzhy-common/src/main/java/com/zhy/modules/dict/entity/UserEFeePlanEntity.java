package com.zhy.modules.dict.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 电价方案
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-11 15:55:52
 */
@TableName("user_e_fee_plan")
public class UserEFeePlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 峰1最低值
	 */
	private Double peak1LowValue;
	/**
	 * 峰1最高值
	 */
	private Double peak1HighValue;
	/**
	 * 峰2最低值
	 */
	private Double peak2LowValue;
	/**
	 * 峰2最高值
	 */
	private Double peak2HighValue;
	/**
	 * 平1最低值
	 */
	private Double flat1LowValue;
	/**
	 * 平1最高值
	 */
	private Double flat1HighValue;
	/**
	 * 平2最低值
	 */
	private Double flat2LowValue;
	/**
	 * 平2最高值
	 */
	private Double flat2HighValue;
	/**
	 * 谷1最低值
	 */
	private Double ravine1LowValue;
	/**
	 * 谷1最高值
	 */
	private Double ravine1HighValue;
	/**
	 * 谷2最低值
	 */
	private Double ravine2LowValue;
	/**
	 * 谷2最高值
	 */
	private Double ravine2HighValue;
	/**
	 * 尖1最低值
	 */
	private Double tip1LowValue;
	/**
	 * 尖1最高值
	 */
	private Double tip1HighValue;
	/**
	 * 尖2最低值
	 */
	private Double tip2LowValue;
	/**
	 * 尖2最高值
	 */
	private Double tip2HighValue;
	/**
	 * 回路id
	 */
	private Long lineId;
	/**
	 * 采集设备id
	 */
	private String deviceId;
	/**
	 * 公司id
	 */
	private Long companyId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：峰1最低值
	 */
	public void setPeak1LowValue(Double peak1LowValue) {
		this.peak1LowValue = peak1LowValue;
	}
	/**
	 * 获取：峰1最低值
	 */
	public Double getPeak1LowValue() {
		return peak1LowValue;
	}
	/**
	 * 设置：峰1最高值
	 */
	public void setPeak1HighValue(Double peak1HighValue) {
		this.peak1HighValue = peak1HighValue;
	}
	/**
	 * 获取：峰1最高值
	 */
	public Double getPeak1HighValue() {
		return peak1HighValue;
	}
	/**
	 * 设置：峰2最低值
	 */
	public void setPeak2LowValue(Double peak2LowValue) {
		this.peak2LowValue = peak2LowValue;
	}
	/**
	 * 获取：峰2最低值
	 */
	public Double getPeak2LowValue() {
		return peak2LowValue;
	}
	/**
	 * 设置：峰2最高值
	 */
	public void setPeak2HighValue(Double peak2HighValue) {
		this.peak2HighValue = peak2HighValue;
	}
	/**
	 * 获取：峰2最高值
	 */
	public Double getPeak2HighValue() {
		return peak2HighValue;
	}
	/**
	 * 设置：平1最低值
	 */
	public void setFlat1LowValue(Double flat1LowValue) {
		this.flat1LowValue = flat1LowValue;
	}
	/**
	 * 获取：平1最低值
	 */
	public Double getFlat1LowValue() {
		return flat1LowValue;
	}
	/**
	 * 设置：平1最高值
	 */
	public void setFlat1HighValue(Double flat1HighValue) {
		this.flat1HighValue = flat1HighValue;
	}
	/**
	 * 获取：平1最高值
	 */
	public Double getFlat1HighValue() {
		return flat1HighValue;
	}
	/**
	 * 设置：平2最低值
	 */
	public void setFlat2LowValue(Double flat2LowValue) {
		this.flat2LowValue = flat2LowValue;
	}
	/**
	 * 获取：平2最低值
	 */
	public Double getFlat2LowValue() {
		return flat2LowValue;
	}
	/**
	 * 设置：平2最高值
	 */
	public void setFlat2HighValue(Double flat2HighValue) {
		this.flat2HighValue = flat2HighValue;
	}
	/**
	 * 获取：平2最高值
	 */
	public Double getFlat2HighValue() {
		return flat2HighValue;
	}
	/**
	 * 设置：谷1最低值
	 */
	public void setRavine1LowValue(Double ravine1LowValue) {
		this.ravine1LowValue = ravine1LowValue;
	}
	/**
	 * 获取：谷1最低值
	 */
	public Double getRavine1LowValue() {
		return ravine1LowValue;
	}
	/**
	 * 设置：谷1最高值
	 */
	public void setRavine1HighValue(Double ravine1HighValue) {
		this.ravine1HighValue = ravine1HighValue;
	}
	/**
	 * 获取：谷1最高值
	 */
	public Double getRavine1HighValue() {
		return ravine1HighValue;
	}
	/**
	 * 设置：谷2最低值
	 */
	public void setRavine2LowValue(Double ravine2LowValue) {
		this.ravine2LowValue = ravine2LowValue;
	}
	/**
	 * 获取：谷2最低值
	 */
	public Double getRavine2LowValue() {
		return ravine2LowValue;
	}
	/**
	 * 设置：谷2最高值
	 */
	public void setRavine2HighValue(Double ravine2HighValue) {
		this.ravine2HighValue = ravine2HighValue;
	}
	/**
	 * 获取：谷2最高值
	 */
	public Double getRavine2HighValue() {
		return ravine2HighValue;
	}
	/**
	 * 设置：尖1最低值
	 */
	public void setTip1LowValue(Double tip1LowValue) {
		this.tip1LowValue = tip1LowValue;
	}
	/**
	 * 获取：尖1最低值
	 */
	public Double getTip1LowValue() {
		return tip1LowValue;
	}
	/**
	 * 设置：尖1最高值
	 */
	public void setTip1HighValue(Double tip1HighValue) {
		this.tip1HighValue = tip1HighValue;
	}
	/**
	 * 获取：尖1最高值
	 */
	public Double getTip1HighValue() {
		return tip1HighValue;
	}
	/**
	 * 设置：尖2最低值
	 */
	public void setTip2LowValue(Double tip2LowValue) {
		this.tip2LowValue = tip2LowValue;
	}
	/**
	 * 获取：尖2最低值
	 */
	public Double getTip2LowValue() {
		return tip2LowValue;
	}
	/**
	 * 设置：尖2最高值
	 */
	public void setTip2HighValue(Double tip2HighValue) {
		this.tip2HighValue = tip2HighValue;
	}
	/**
	 * 获取：尖2最高值
	 */
	public Double getTip2HighValue() {
		return tip2HighValue;
	}
	/**
	 * 设置：回路id
	 */
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	/**
	 * 获取：回路id
	 */
	public Long getLineId() {
		return lineId;
	}
	/**
	 * 设置：采集设备id
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：采集设备id
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：公司id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：公司id
	 */
	public Long getCompanyId() {
		return companyId;
	}
}
