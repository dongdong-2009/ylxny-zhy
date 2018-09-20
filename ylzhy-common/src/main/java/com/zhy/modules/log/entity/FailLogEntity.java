package com.zhy.modules.log.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 采集操作失败记录
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 17:58:02
 */
@TableName("dcr_fail_log")
public class FailLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 时间id 与事件记录表对应
	 */
	private Long event_id;
	/**
	 * 命令
	 */
	private String cmd;
	/**
	 * 命令描述
	 */
	private String cmd_desc;
	/**
	 * 发送的数据（16进制）
	 */
	private String send_data;
	/**
	 * 失败类型（1.超时 2.无返回）
	 */
	private Integer fail_type;
	/**
	 * 记录时间
	 */
	private Date create_time;

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
	 * 设置：时间id 与事件记录表对应
	 */
	public void setevent_id(Long event_id) {
		this.event_id = event_id;
	}
	/**
	 * 获取：时间id 与事件记录表对应
	 */
	public Long getevent_id() {
		return event_id;
	}
	/**
	 * 设置：命令
	 */
	public void setcmd(String cmd) {
		this.cmd = cmd;
	}
	/**
	 * 获取：命令
	 */
	public String getcmd() {
		return cmd;
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
	 * 设置：发送的数据（16进制）
	 */
	public void setsend_data(String send_data) {
		this.send_data = send_data;
	}
	/**
	 * 获取：发送的数据（16进制）
	 */
	public String getsend_data() {
		return send_data;
	}
	/**
	 * 设置：失败类型（1.超时 2.无返回）
	 */
	public void setfail_type(Integer fail_type) {
		this.fail_type = fail_type;
	}
	/**
	 * 获取：失败类型（1.超时 2.无返回）
	 */
	public Integer getfail_type() {
		return fail_type;
	}
	/**
	 * 设置：记录时间
	 */
	public void setcreate_time(Date create_time) {
		this.create_time = create_time;
	}
	/**
	 * 获取：记录时间
	 */
	public Date getcreate_time() {
		return create_time;
	}
}
