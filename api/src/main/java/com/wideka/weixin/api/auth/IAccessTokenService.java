package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.AccessToken;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IAccessTokenService {

	String HTTPS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=$id$&corpsecret=$secrect$";

	String HTTPS_CORP_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_corp_token?suite_access_token=";

	/**
	 * 
	 * @param corpId
	 *            企业Id.
	 * @param corpSecret
	 *            管理组的凭证密钥.
	 * @return
	 * @throws RuntimeException
	 */
	AccessToken getToken(String corpId, String corpSecret) throws RuntimeException;

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 *            应用套件id.
	 * @param authCorpId
	 *            授权方corpid.
	 * @param permanentCode
	 *            永久授权码，通过get_permanent_code获取.
	 * @return
	 * @throws RuntimeException
	 */
	AccessToken getCorpToken(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode)
		throws RuntimeException;

}
