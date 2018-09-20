package com.zhy.modules.dict.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 回路列表
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 15:04:39
 */
@TableName("dcd_line")
public class LineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 回路名称
	 */
	private String name;
	/**
	 * 回路唯一地址
	 */
	private String address;
	/**
	 * 回路挂接的采集器唯一id
	 */
	private String device_id;
	/**
	 * 回路的协议（1.DLT645 2.MODBUS）
	 */
	private Integer protocol;

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
	 * 设置：回路名称
	 */
	public void setname(String name) {
		this.name = name;
	}
	/**
	 * 获取：回路名称
	 */
	public String getname() {
		return name;
	}
	/**
	 * 设置：回路唯一地址
	 */
	public void setaddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：回路唯一地址
	 */
	public String getaddress() {
		return address;
	}
	/**
	 * 设置：回路挂接的采集器唯一id
	 */
	public void setdevice_id(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * 获取：回路挂接的采集器唯一id
	 */
	public String getdevice_id() {
		return device_id;
	}
	/**
	 * 设置：回路的协议（1.DLT645 2.MODBUS）
	 */
	public void setprotocol(Integer protocol) {
		this.protocol = protocol;
	}
	/**
	 * 获取：回路的协议（1.DLT645 2.MODBUS）
	 */
	public Integer getprotocol() {
		return protocol;
	}
}
