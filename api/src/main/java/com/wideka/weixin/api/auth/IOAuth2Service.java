package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.AccessToken;
import com.wideka.weixin.api.auth.bo.UserInfo;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IOAuth2Service {

	String HTTPS_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

	String HTTPS_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code";

	String HTTPS_USER_INFO_URL =
		"https://api.weixin.qq.com/sns/userinfo?access_token=$ACCESS_TOKEN$&openid=$OPENID$&lang=zh_CN";

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

	/**
	 * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和openid拉取用户信息了.
	 * 
	 * @param accessToken
	 * @param openId
	 * @return
	 * @throws RuntimeException
	 */
	UserInfo getUserInfo(String accessToken, String openId) throws RuntimeException;

}
