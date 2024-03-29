package com.zhy.modules.alarm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 报警设置
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-19 18:35:20
 */
@TableName("t_sys_alarm_setting")
public class SysAlarmSettingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 公司id
	 */
	private Long company_id;
	/**
	 * 采集器id
	 */
	private String device_id;
	/**
	 * 回路id
	 */
	private Long line_id;
	/**
	 * 报警类型
	 */
	private Integer alarm_type;
	/**
	 * 报警父类别
	 */
	private Integer alarm_parent_type;
	/**
	 * 指标名称
	 */
	private String name;
	/**
	 * 越限报警水位默认最高值
	 */
	private Double default_value_top;
	/**
	 * 越限报警水位默认最低值
	 */
	private Double default_value_bottom;
	/**
	 * 报警级别
	 */
	private Integer alarm_level;
	/**
	 * 报警级别名称
	 */
	private String alarm_level_name;

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
	 * 设置：采集器id
	 */
	public void setdevice_id(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * 获取：采集器id
	 */
	public String getdevice_id() {
		return device_id;
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
	 * 设置：报警类型
	 */
	public void setalarm_type(Integer alarm_type) {
		this.alarm_type = alarm_type;
	}
	/**
	 * 获取：报警类型
	 */
	public Integer getalarm_type() {
		return alarm_type;
	}
	/**
	 * 设置：报警父类别
	 */
	public void setalarm_parent_type(Integer alarm_parent_type) {
		this.alarm_parent_type = alarm_parent_type;
	}
	/**
	 * 获取：报警父类别
	 */
	public Integer getalarm_parent_type() {
		return alarm_parent_type;
	}
	/**
	 * 设置：指标名称
	 */
	public void setname(String name) {
		this.name = name;
	}
	/**
	 * 获取：指标名称
	 */
	public String getname() {
		return name;
	}
	/**
	 * 设置：越限报警水位默认最高值
	 */
	public void setdefault_value_top(Double default_value_top) {
		this.default_value_top = default_value_top;
	}
	/**
	 * 获取：越限报警水位默认最高值
	 */
	public Double getdefault_value_top() {
		return default_value_top;
	}
	/**
	 * 设置：越限报警水位默认最低值
	 */
	public void setdefault_value_bottom(Double default_value_bottom) {
		this.default_value_bottom = default_value_bottom;
	}
	/**
	 * 获取：越限报警水位默认最低值
	 */
	public Double getdefault_value_bottom() {
		return default_value_bottom;
	}
	/**
	 * 设置：报警级别
	 */
	public void setalarm_level(Integer alarm_level) {
		this.alarm_level = alarm_level;
	}
	/**
	 * 获取：报警级别
	 */
	public Integer getalarm_level() {
		return alarm_level;
	}
	/**
	 * 设置：报警级别名称
	 */
	public void setalarm_level_name(String alarm_level_name) {
		this.alarm_level_name = alarm_level_name;
	}
	/**
	 * 获取：报警级别名称
	 */
	public String getalarm_level_name() {
		return alarm_level_name;
	}
}
