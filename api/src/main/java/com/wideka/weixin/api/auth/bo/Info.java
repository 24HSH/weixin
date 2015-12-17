package com.wideka.weixin.api.auth.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.corp.bo.AuthCorpInfo;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Info implements Serializable {

	private static final long serialVersionUID = 2346040866732279592L;

	/**
	 * 授权方企业信息.
	 */
	@JSONField(name = "auth_corp_info")
	private AuthCorpInfo authCorpInfo;

	/**
	 * 授权信息.
	 */
	@JSONField(name = "auth_info")
	private AuthInfo authInfo;

	public AuthCorpInfo getAuthCorpInfo() {
		return authCorpInfo;
	}

	public void setAuthCorpInfo(AuthCorpInfo authCorpInfo) {
		this.authCorpInfo = authCorpInfo;
	}

	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

}
