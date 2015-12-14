package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.PreAuthCode;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IPreAuthService {

	String HTTPS_PRE_AUTH_CODE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code?suite_access_token=";

	String HTTPS_SESSION_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info?suite_access_token=";

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 * @param appId
	 * @return
	 * @throws RuntimeException
	 */
	PreAuthCode getPreAuthCode(String suiteAccessToken, String suiteId, int[] appId) throws RuntimeException;

}
