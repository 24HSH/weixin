package com.wideka.weixin.api.user.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class User extends Result {

	private static final long serialVersionUID = 4716372335911707525L;

	/**
	 * 成员UserID.
	 */
	@JSONField(name = "UserId")
	private String userId;

	/**
	 * 手机设备号(由微信在安装时随机生成，删除重装会改变，升级不受影响).
	 */
	@JSONField(name = "DeviceId")
	private String deviceId;

	/**
	 * 非企业成员的标识，对当前企业号唯一.
	 */
	@JSONField(name = "OpenId")
	private String openId;

	@JSONField(name = "status")
	private int status;

	// >>>>>>>>>>以下是基本属性<<<<<<<<<<

	/**
	 * 成员名称。长度为1~64个字节.
	 */
	@JSONField(name = "name")
	private String name;

	/**
	 * 成员所属部门id列表。注意，每个部门的直属成员上限为1000个.
	 */
	@JSONField(name = "department")
	private int[] department;

	/**
	 * 职位信息。长度为0~64个字节.
	 */
	@JSONField(name = "position")
	private String position;

	/**
	 * 手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空.
	 */
	@JSONField(name = "mobile")
	private String mobile;

	/**
	 * 性别。1表示男性，2表示女性.
	 */
	@JSONField(name = "gender")
	private String gender;

	/**
	 * 邮箱。长度为0~64个字节。企业内必须唯一.
	 */
	@JSONField(name = "email")
	private String email;

	/**
	 * 微信号。企业内必须唯一。（注意：是微信号，不是微信的名字）.
	 */
	@JSONField(name = "weixinid")
	private String weixinId;

	/**
	 * 成员头像的mediaid，通过多媒体接口上传图片获得的mediaid.
	 */
	@JSONField(name = "avatar_mediaid")
	private String avatarMediaId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getDepartment() {
		return department;
	}

	public void setDepartment(int[] department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeixinId() {
		return weixinId;
	}

	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}

	public String getAvatarMediaId() {
		return avatarMediaId;
	}

	public void setAvatarMediaId(String avatarMediaId) {
		this.avatarMediaId = avatarMediaId;
	}

}
