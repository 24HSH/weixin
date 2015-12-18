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
	 * 该API用于通过永久授权码换取企业号的授权信息。 永久code的获取，是通过临时授权码使用get_permanent_code 接口获取到的permanent_code.
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
