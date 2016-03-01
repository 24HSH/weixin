package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.AccessToken;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IOAuth2Service {

	String HTTPS_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

	String HTTPS_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code";

	/**
	 * 
	 * @param appId
	 * @param redirectUrl
	 * @param scope
	 * @param state
	 * @return
	 * @throws RuntimeException
	 */
	String authorize(String appId, String redirectUrl, String scope, String state) throws RuntimeException;

	/**
	 * 
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 * @throws RuntimeException
	 */
	AccessToken accessToken(String appId, String appSecret, String code) throws RuntimeException;

}
