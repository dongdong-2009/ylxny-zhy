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
@TableName("dcd_protocol_dict")
public class ProtocolDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 协议代码
	 */
	private String protocol_code;
	/**
	 * 协议类型
	 */
	private Integer protocol_type;
	/**
	 * 协议描述
	 */
	private String protocol_desc;
	/**
	 * 协议执行方式（1.并行 2.串行）
	 */
	private Integer executor_type;

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
	 * 设置：协议代码
	 */
	public void setprotocol_code(String protocol_code) {
		this.protocol_code = protocol_code;
	}
	/**
	 * 获取：协议代码
	 */
	public String getprotocol_code() {
		return protocol_code;
	}
	/**
	 * 设置：协议类型
	 */
	public void setprotocol_type(Integer protocol_type) {
		this.protocol_type = protocol_type;
	}
	/**
	 * 获取：协议类型
	 */
	public Integer getprotocol_type() {
		return protocol_type;
	}
	/**
	 * 设置：协议描述
	 */
	public void setprotocol_desc(String protocol_desc) {
		this.protocol_desc = protocol_desc;
	}
	/**
	 * 获取：协议描述
	 */
	public String getprotocol_desc() {
		return protocol_desc;
	}
	/**
	 * 设置：协议执行方式（1.并行 2.串行）
	 */
	public void setexecutor_type(Integer executor_type) {
		this.executor_type = executor_type;
	}
	/**
	 * 获取：协议执行方式（1.并行 2.串行）
	 */
	public Integer getexecutor_type() {
		return executor_type;
	}
}
