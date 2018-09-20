package com.zhy.modules.company.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业设备信息
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-14 16:56:03
 */
@TableName("t_company_sbxx")
public class CompanySbxxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 设备ID，表主键
	 */
	@TableId
	private Long sbid;
	/**
	 * 企业ID
	 */
	private String companyid;
	/**
	 * 设备类型（dictlx表设备类型，记录打雷）
	 */
	private Long sblx;
	/**
	 * 
	 */
	private Long sbdetailid;
	/**
	 * 上家设备ID，比如，一个回路的上级是DtU，一个DtU的上级是电站
	 */
	private Long parentsbid;
	/**
	 * 备注 电报的类型，厂家等信息
	 */
	private String des;
	/**
	 * 选用标志
	 */
	private String xybz;
	/**
	 * 添加时间
	 */
	private Date createtime;
	/**
	 * 添加人
	 */
	private Long lrr;
	/**
	 * 修改时间
	 */
	private Date modifytime;
	/**
	 * 是否采集状态
	 */
	private String staus;
	/**
	 * 设备名称
	 */
	private String sbname;
	/**
	 * 设备编号
	 */
	private String sbnum;
	/**
	 * 表地址，唯一
	 */
	private String sbaddress;
	/**
	 * 支持的协议
	 */
	private String protocol;

	/**
	 * 设置：设备ID，表主键
	 */
	public void setSbid(Long sbid) {
		this.sbid = sbid;
	}
	/**
	 * 获取：设备ID，表主键
	 */
	public Long getSbid() {
		return sbid;
	}
	/**
	 * 设置：企业ID
	 */
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	/**
	 * 获取：企业ID
	 */
	public String getCompanyid() {
		return companyid;
	}
	/**
	 * 设置：设备类型（dictlx表设备类型，记录打雷）
	 */
	public void setSblx(Long sblx) {
		this.sblx = sblx;
	}
	/**
	 * 获取：设备类型（dictlx表设备类型，记录打雷）
	 */
	public Long getSblx() {
		return sblx;
	}
	/**
	 * 设置：
	 */
	public void setSbdetailid(Long sbdetailid) {
		this.sbdetailid = sbdetailid;
	}
	/**
	 * 获取：
	 */
	public Long getSbdetailid() {
		return sbdetailid;
	}
	/**
	 * 设置：上家设备ID，比如，一个回路的上级是DtU，一个DtU的上级是电站
	 */
	public void setParentsbid(Long parentsbid) {
		this.parentsbid = parentsbid;
	}
	/**
	 * 获取：上家设备ID，比如，一个回路的上级是DtU，一个DtU的上级是电站
	 */
	public Long getParentsbid() {
		return parentsbid;
	}
	/**
	 * 设置：备注 电报的类型，厂家等信息
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * 获取：备注 电报的类型，厂家等信息
	 */
	public String getDes() {
		return des;
	}
	/**
	 * 设置：选用标志
	 */
	public void setXybz(String xybz) {
		this.xybz = xybz;
	}
	/**
	 * 获取：选用标志
	 */
	public String getXybz() {
		return xybz;
	}
	/**
	 * 设置：添加时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：添加人
	 */
	public void setLrr(Long lrr) {
		this.lrr = lrr;
	}
	/**
	 * 获取：添加人
	 */
	public Long getLrr() {
		return lrr;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifytime() {
		return modifytime;
	}
	/**
	 * 设置：是否采集状态
	 */
	public void setStaus(String staus) {
		this.staus = staus;
	}
	/**
	 * 获取：是否采集状态
	 */
	public String getStaus() {
		return staus;
	}
	/**
	 * 设置：设备名称
	 */
	public void setSbname(String sbname) {
		this.sbname = sbname;
	}
	/**
	 * 获取：设备名称
	 */
	public String getSbname() {
		return sbname;
	}
	/**
	 * 设置：设备编号
	 */
	public void setSbnum(String sbnum) {
		this.sbnum = sbnum;
	}
	/**
	 * 获取：设备编号
	 */
	public String getSbnum() {
		return sbnum;
	}
	/**
	 * 设置：表地址，唯一
	 */
	public void setSbaddress(String sbaddress) {
		this.sbaddress = sbaddress;
	}
	/**
	 * 获取：表地址，唯一
	 */
	public String getSbaddress() {
		return sbaddress;
	}
	/**
	 * 设置：支持的协议
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	/**
	 * 获取：支持的协议
	 */
	public String getProtocol() {
		return protocol;
	}
}
