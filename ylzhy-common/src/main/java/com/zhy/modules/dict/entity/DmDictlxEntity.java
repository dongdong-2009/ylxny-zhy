package com.zhy.modules.dict.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 代码类型表
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:27:51
 */
@TableName("sys_dm_dictlx")
public class DmDictlxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long lxId;
	/**
	 * 
	 */
	private String lxMc;
	/**
	 * 
	 */
	private String xybz;
	/**
	 * 
	 */
	private Integer lxPri;
	/**
	 * 
	 */
	private String lxBz;

	/**
	 * 设置：
	 */
	public void setLxId(Long lxId) {
		this.lxId = lxId;
	}
	/**
	 * 获取：
	 */
	public Long getLxId() {
		return lxId;
	}
	/**
	 * 设置：
	 */
	public void setLxMc(String lxMc) {
		this.lxMc = lxMc;
	}
	/**
	 * 获取：
	 */
	public String getLxMc() {
		return lxMc;
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
	public void setLxPri(Integer lxPri) {
		this.lxPri = lxPri;
	}
	/**
	 * 获取：
	 */
	public Integer getLxPri() {
		return lxPri;
	}
	/**
	 * 设置：
	 */
	public void setLxBz(String lxBz) {
		this.lxBz = lxBz;
	}
	/**
	 * 获取：
	 */
	public String getLxBz() {
		return lxBz;
	}
}
