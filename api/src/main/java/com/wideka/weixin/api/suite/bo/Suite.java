package com.wideka.weixin.api.suite.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Suite implements Serializable {

	private static final long serialVersionUID = -576933360630351605L;

	@JSONField(name = "suite_id")
	private String suiteId;

	@JSONField(name = "suite_secret")
	private String suiteSecret;

	@JSONField(name = "suite_ticket")
	private String suiteTicket;

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	/**
	 * 临时授权码会在授权成功时附加在redirect_uri中跳转回应用提供商网站.
	 */
	@JSONField(name = "auth_code")
	private String authCode;

	/**
	 * 授权方corpid.
	 */
	@JSONField(name = "auth_corpid")
	private String authCorpId;

	/**
	 * 永久授权码，通过get_permanent_code获取.
	 */
	@JSONField(name = "permanent_code")
	private String permanentCode;

	public String getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}

	public String getSuiteSecret() {
		return suiteSecret;
	}

	public void setSuiteSecret(String suiteSecret) {
		this.suiteSecret = suiteSecret;
	}

	public String getSuiteTicket() {
		return suiteTicket;
	}

	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthCorpId() {
		return authCorpId;
	}

	public void setAuthCorpId(String authCorpId) {
		this.authCorpId = authCorpId;
	}

	public String getPermanentCode() {
		return permanentCode;
	}

	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}

}
