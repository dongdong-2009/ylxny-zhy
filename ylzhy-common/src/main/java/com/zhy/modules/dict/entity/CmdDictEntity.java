package com.zhy.modules.dict.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 协议字典表
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 15:04:39
 */
@TableName("dcd_cmd_dict")
public class CmdDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 协议类型（1.DLT645 2.MODBUS）
	 */
	private Integer protocol_type;
	/**
	 * 协议名称
	 */
	private String protocol_name;
	/**
	 * 统一命令码 与协议无关
	 */
	private String cmd_code;
	/**
	 * 命令标识 与采集数据记录的字段名对应
	 */
	private String cmd_flag;
	/**
	 * 命令描述
	 */
	private String cmd_desc;
	/**
	 * 命令类型 跟具体协议相关 如果为空则查看操作类型
	 */
	private String cmd_type;
	/**
	 * 命令字符串参考 跟具体协议相关
	 */
	private String cmd;
	/**
	 * 返回数据的单位
	 */
	private String measurement;
	/**
	 * 单位的名称
	 */
	private String measurement_name;
	/**
	 * 返回数据的格式 用#号表示 如###.###
	 */
	private String format;
	/**
	 * 返回数据的因子
	 */
	private Float factor;
	/**
	 * 返回数据操作类型(1.直读电表 2.计算)
	 */
	private Integer data_oper_type;
	/**
	 * 操作函数
	 */
	private String data_oper_func;
	/**
	 * 采集频率
	 */
	private Integer frequency;
	/**
	 * 读到的数据操作（1.直接写入数据库 2.计算）
	 */
	private Integer data_write_oper;
	/**
	 * 数据写入需要计算的公式
	 */
	private String data_write_formula;
	/**
	 * 所读数据作为公式参数的索引
	 */
	private Integer data_write_param_index;
	/**
	 * 计算结果对应的code
	 */
	private String data_write_result_code;

	/**
	 * 设置：
	 */
	public void setid(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getid() {
		return id;
	}
	/**
	 * 设置：协议类型（1.DLT645 2.MODBUS）
	 */
	public void setprotocol_type(Integer protocol_type) {
		this.protocol_type = protocol_type;
	}
	/**
	 * 获取：协议类型（1.DLT645 2.MODBUS）
	 */
	public Integer getprotocol_type() {
		return protocol_type;
	}
	/**
	 * 设置：协议名称
	 */
	public void setprotocol_name(String protocol_name) {
		this.protocol_name = protocol_name;
	}
	/**
	 * 获取：协议名称
	 */
	public String getprotocol_name() {
		return protocol_name;
	}
	/**
	 * 设置：统一命令码 与协议无关
	 */
	public void setcmd_code(String cmd_code) {
		this.cmd_code = cmd_code;
	}
	/**
	 * 获取：统一命令码 与协议无关
	 */
	public String getcmd_code() {
		return cmd_code;
	}
	/**
	 * 设置：命令标识 与采集数据记录的字段名对应
	 */
	public void setcmd_flag(String cmd_flag) {
		this.cmd_flag = cmd_flag;
	}
	/**
	 * 获取：命令标识 与采集数据记录的字段名对应
	 */
	public String getcmd_flag() {
		return cmd_flag;
	}
	/**
	 * 设置：命令描述
	 */
	public void setcmd_desc(String cmd_desc) {
		this.cmd_desc = cmd_desc;
	}
	/**
	 * 获取：命令描述
	 */
	public String getcmd_desc() {
		return cmd_desc;
	}
	/**
	 * 设置：命令类型 跟具体协议相关 如果为空则查看操作类型
	 */
	public void setcmd_type(String cmd_type) {
		this.cmd_type = cmd_type;
	}
	/**
	 * 获取：命令类型 跟具体协议相关 如果为空则查看操作类型
	 */
	public String getcmd_type() {
		return cmd_type;
	}
	/**
	 * 设置：命令字符串参考 跟具体协议相关
	 */
	public void setcmd(String cmd) {
		this.cmd = cmd;
	}
	/**
	 * 获取：命令字符串参考 跟具体协议相关
	 */
	public String getcmd() {
		return cmd;
	}
	/**
	 * 设置：返回数据的单位
	 */
	public void setmeasurement(String measurement) {
		this.measurement = measurement;
	}
	/**
	 * 获取：返回数据的单位
	 */
	public String getmeasurement() {
		return measurement;
	}
	/**
	 * 设置：单位的名称
	 */
	public void setmeasurement_name(String measurement_name) {
		this.measurement_name = measurement_name;
	}
	/**
	 * 获取：单位的名称
	 */
	public String getmeasurement_name() {
		return measurement_name;
	}
	/**
	 * 设置：返回数据的格式 用#号表示 如###.###
	 */
	public void setformat(String format) {
		this.format = format;
	}
	/**
	 * 获取：返回数据的格式 用#号表示 如###.###
	 */
	public String getformat() {
		return format;
	}
	/**
	 * 设置：返回数据的因子
	 */
	public void setfactor(Float factor) {
		this.factor = factor;
	}
	/**
	 * 获取：返回数据的因子
	 */
	public Float getfactor() {
		return factor;
	}
	/**
	 * 设置：返回数据操作类型(1.直读电表 2.计算)
	 */
	public void setdata_oper_type(Integer data_oper_type) {
		this.data_oper_type = data_oper_type;
	}
	/**
	 * 获取：返回数据操作类型(1.直读电表 2.计算)
	 */
	public Integer getdata_oper_type() {
		return data_oper_type;
	}
	/**
	 * 设置：操作函数
	 */
	public void setdata_oper_func(String data_oper_func) {
		this.data_oper_func = data_oper_func;
	}
	/**
	 * 获取：操作函数
	 */
	public String getdata_oper_func() {
		return data_oper_func;
	}
	/**
	 * 设置：采集频率
	 */
	public void setfrequency(Integer frequency) {
		this.frequency = frequency;
	}
	/**
	 * 获取：采集频率
	 */
	public Integer getfrequency() {
		return frequency;
	}
	/**
	 * 设置：读到的数据操作（1.直接写入数据库 2.计算）
	 */
	public void setdata_write_oper(Integer data_write_oper) {
		this.data_write_oper = data_write_oper;
	}
	/**
	 * 获取：读到的数据操作（1.直接写入数据库 2.计算）
	 */
	public Integer getdata_write_oper() {
		return data_write_oper;
	}
	/**
	 * 设置：数据写入需要计算的公式
	 */
	public void setdata_write_formula(String data_write_formula) {
		this.data_write_formula = data_write_formula;
	}
	/**
	 * 获取：数据写入需要计算的公式
	 */
	public String getdata_write_formula() {
		return data_write_formula;
	}
	/**
	 * 设置：所读数据作为公式参数的索引
	 */
	public void setdata_write_param_index(Integer data_write_param_index) {
		this.data_write_param_index = data_write_param_index;
	}
	/**
	 * 获取：所读数据作为公式参数的索引
	 */
	public Integer getdata_write_param_index() {
		return data_write_param_index;
	}
	/**
	 * 设置：计算结果对应的code
	 */
	public void setdata_write_result_code(String data_write_result_code) {
		this.data_write_result_code = data_write_result_code;
	}
	/**
	 * 获取：计算结果对应的code
	 */
	public String getdata_write_result_code() {
		return data_write_result_code;
	}
}
