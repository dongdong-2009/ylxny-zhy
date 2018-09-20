package com.zhy.modules.dict.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 15:04:39
 */
@TableName("dcd_device")
public class DeviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 站点id
	 */
	private Integer station_id;
	/**
	 * 采集设备唯一id
	 */
	private String device_id;
	/**
	 * 是否启用 （0 启用 1 不启用）
	 */
	private Integer inUse;
	/**
	 * 采集设备在线状态（0 启用 1 停用）
	 */
	private Integer online_status;
	/**
	 * sim卡号
	 */
	private String sim;
	/**
	 * 安装位置
	 */
	private String place;
	/**
	 *  上线时间
	 */
	private Date onlinetime;
	/**
	 * 采集器最后在线时间
	 */
	private Date lasttime;
	/**
	 * 默认采集器下回路的协议都是一样的
	 */
	private Integer protocol_type;

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
	 * 设置：站点id
	 */
	public void setstation_id(Integer station_id) {
		this.station_id = station_id;
	}
	/**
	 * 获取：站点id
	 */
	public Integer getstation_id() {
		return station_id;
	}
	/**
	 * 设置：采集设备唯一id
	 */
	public void setdevice_id(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * 获取：采集设备唯一id
	 */
	public String getdevice_id() {
		return device_id;
	}
	/**
	 * 设置：是否启用 （0 启用 1 不启用）
	 */
	public void setinUse(Integer inUse) {
		this.inUse = inUse;
	}
	/**
	 * 获取：是否启用 （0 启用 1 不启用）
	 */
	public Integer getinUse() {
		return inUse;
	}
	/**
	 * 设置：采集设备在线状态（0 启用 1 停用）
	 */
	public void setonline_status(Integer online_status) {
		this.online_status = online_status;
	}
	/**
	 * 获取：采集设备在线状态（0 启用 1 停用）
	 */
	public Integer getonline_status() {
		return online_status;
	}
	/**
	 * 设置：sim卡号
	 */
	public void setsim(String sim) {
		this.sim = sim;
	}
	/**
	 * 获取：sim卡号
	 */
	public String getsim() {
		return sim;
	}
	/**
	 * 设置：安装位置
	 */
	public void setplace(String place) {
		this.place = place;
	}
	/**
	 * 获取：安装位置
	 */
	public String getplace() {
		return place;
	}
	/**
	 * 设置： 上线时间
	 */
	public void setonlinetime(Date onlinetime) {
		this.onlinetime = onlinetime;
	}
	/**
	 * 获取： 上线时间
	 */
	public Date getonlinetime() {
		return onlinetime;
	}
	/**
	 * 设置：采集器最后在线时间
	 */
	public void setlasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	/**
	 * 获取：采集器最后在线时间
	 */
	public Date getlasttime() {
		return lasttime;
	}
	/**
	 * 设置：默认采集器下回路的协议都是一样的
	 */
	public void setprotocol_type(Integer protocol_type) {
		this.protocol_type = protocol_type;
	}
	/**
	 * 获取：默认采集器下回路的协议都是一样的
	 */
	public Integer getprotocol_type() {
		return protocol_type;
	}
}
