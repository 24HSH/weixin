package com.wideka.weixin.api.auth;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IPermanentService {

	String HTTPS_PERMANENT_CODE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code?suite_access_token=";

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 *            应用套件id.
	 * @param authCode
	 *            临时授权码会在授权成功时附加在redirect_uri中跳转回应用提供商网站.
	 */
	void get_permanent_code(String suiteAccessToken, String suiteId, String authCode);

}
