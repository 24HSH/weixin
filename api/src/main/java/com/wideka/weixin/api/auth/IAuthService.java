package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.Info;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IAuthService {

	String HTTPS_AUTH_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info?suite_access_token=";

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 * @param authCorpId
	 * @param permanentCode
	 * @return
	 * @throws RuntimeException
	 */
	Info getAuthInfo(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode)
		throws RuntimeException;

}
