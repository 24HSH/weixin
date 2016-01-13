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
	@JSONField(name = "userid")
	private String userId;

	/**
	 * 企业号成员userid对应的openid，若有传参agentid，则是针对该agentid的openid。否则是针对企业号corpid的openid.
	 */
	@JSONField(name = "openid")
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

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	/**
	 * 整型，需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数.
	 */
	@JSONField(name = "agentid")
	private Integer agentId;

	/**
	 * 应用的appid，若请求包中不包含agentid则不返回appid。该appid在使用微信红包时会用到.
	 */
	@JSONField(name = "appid")
	private String appId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

}
