package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.PermanentCode;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IPermanentService {

	String HTTPS_PERMANENT_CODE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code?suite_access_token=";

	/**
	 * 该API用于使用临时授权码换取授权方的永久授权码，并换取授权信息、企业access_token.
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 *            应用套件id.
	 * @param authCode
	 *            临时授权码会在授权成功时附加在redirect_uri中跳转回应用提供商网站.
	 */
	PermanentCode getPermanentCode(String suiteAccessToken, String suiteId, String authCode);

}
