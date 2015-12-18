package com.wideka.weixin.api.auth.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class PreAuthCode extends Result {

	private static final long serialVersionUID = 6789848637410236083L;

	/**
	 * 预授权码.
	 */
	@JSONField(name = "pre_auth_code")
	private String preAuthCode;

	/**
	 * 有效期.
	 */
	@JSONField(name = "expires_in")
	private int expiresIn;

	public String getPreAuthCode() {
		return preAuthCode;
	}

	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
