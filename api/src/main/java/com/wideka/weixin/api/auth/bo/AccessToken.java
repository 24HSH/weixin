package com.wideka.weixin.api.auth.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.suite.bo.Err;

/**
 * 
 * @author xujiakun
 * 
 */
public class AccessToken extends Err {

	private static final long serialVersionUID = -2503242169338259649L;

	/**
	 * 获取到的凭证.
	 */
	@JSONField(name = "access_token")
	private String accessToken;

	/**
	 * 凭证的有效时间（秒）.
	 */
	@JSONField(name = "expires_in")
	private int expiresIn;

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

}
