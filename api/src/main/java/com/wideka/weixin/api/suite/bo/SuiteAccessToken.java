package com.wideka.weixin.api.suite.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SuiteAccessToken implements Serializable {

	private static final long serialVersionUID = -1278639395134356080L;

	/**
	 * 应用套件access_token.
	 */
	@JSONField(name = "suite_access_token")
	private String suiteAccessToken;

	/**
	 * 有效期.
	 */
	@JSONField(name = "expires_in")
	private int expiresIn;

	public String getSuiteAccessToken() {
		return suiteAccessToken;
	}

	public void setSuiteAccessToken(String suiteAccessToken) {
		this.suiteAccessToken = suiteAccessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
