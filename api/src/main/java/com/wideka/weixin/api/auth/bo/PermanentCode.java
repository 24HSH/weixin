package com.wideka.weixin.api.auth.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.corp.bo.Corp;
import com.wideka.weixin.api.user.bo.User;

/**
 * 
 * @author JiakunXu
 * 
 */
public class PermanentCode implements Serializable {

	private static final long serialVersionUID = 7042734689198445582L;

	/**
	 * 授权方（企业）access_token.
	 */
	@JSONField(name = "access_token")
	private String accessToken;

	/**
	 * 授权方（企业）access_token超时时间.
	 */
	@JSONField(name = "expires_in")
	private int expiresIn;

	/**
	 * 企业号永久授权码.
	 */
	@JSONField(name = "permanent_code")
	private String permanentCode;

	/**
	 * 授权方企业信息.
	 */
	@JSONField(name = "auth_corp_info")
	private Corp corp;

	/**
	 * 授权信息.
	 */
	@JSONField(name = "auth_info")
	private AuthInfo authInfo;

	/**
	 * 授权管理员的信息.
	 */
	@JSONField(name = "auth_user_info")
	private User user;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getPermanentCode() {
		return permanentCode;
	}

	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
