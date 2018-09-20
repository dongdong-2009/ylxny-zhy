package com.zhy.modules.dict.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统代码表
 * 系统代码别，不要跟采集系统代码表混淆
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:35:15
 */
@TableName("sys_dm_dict")
public class DmDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long lxid;
	/**
	 * 
	 */
	@TableId
	private Long zdid;
	/**
	 * 对应的字段值（比如指标嘛）
	 */
	private String zdcode;
	/**
	 * 
	 */
	private Long parentid;
	/**
	 * 
	 */
	private String zdmc;
	/**
	 * 属性 （冗余字段）
	 */
	private String property;
	/**
	 * 
	 */
	private String xybz;
	/**
	 * 
	 */
	private Long zdorder;
	/**
	 * 备注
	 */
	private String bz;
	/**
	 * 
	 */
	private String en;

	/**
	 * 设置：
	 */
	public void setLxid(Long lxid) {
		this.lxid = lxid;
	}
	/**
	 * 获取：
	 */
	public Long getLxid() {
		return lxid;
	}
	/**
	 * 设置：
	 */
	public void setZdid(Long zdid) {
		this.zdid = zdid;
	}
	/**
	 * 获取：
	 */
	public Long getZdid() {
		return zdid;
	}
	/**
	 * 设置：对应的字段值（比如指标嘛）
	 */
	public void setZdcode(String zdcode) {
		this.zdcode = zdcode;
	}
	/**
	 * 获取：对应的字段值（比如指标嘛）
	 */
	public String getZdcode() {
		return zdcode;
	}
	/**
	 * 设置：
	 */
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：
	 */
	public Long getParentid() {
		return parentid;
	}
	/**
	 * 设置：
	 */
	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}
	/**
	 * 获取：
	 */
	public String getZdmc() {
		return zdmc;
	}
	/**
	 * 设置：属性 （冗余字段）
	 */
	public void setProperty(String property) {
		this.property = property;
	}
	/**
	 * 获取：属性 （冗余字段）
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * 设置：
	 */
	public void setXybz(String xybz) {
		this.xybz = xybz;
	}
	/**
	 * 获取：
	 */
	public String getXybz() {
		return xybz;
	}
	/**
	 * 设置：
	 */
	public void setZdorder(Long zdorder) {
		this.zdorder = zdorder;
	}
	/**
	 * 获取：
	 */
	public Long getZdorder() {
		return zdorder;
	}
	/**
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * 设置：
	 */
	public void setEn(String en) {
		this.en = en;
	}
	/**
	 * 获取：
	 */
	public String getEn() {
		return en;
	}
}
