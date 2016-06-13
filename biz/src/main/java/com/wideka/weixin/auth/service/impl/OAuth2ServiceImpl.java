package com.wideka.weixin.auth.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.weixin.api.auth.IOAuth2Service;
import com.wideka.weixin.api.auth.bo.AccessToken;
import com.wideka.weixin.api.auth.bo.UserInfo;
import com.wideka.weixin.framework.util.HttpUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class OAuth2ServiceImpl implements IOAuth2Service {

	private static Logger logger = Logger.getLogger(OAuth2ServiceImpl.class);

	@Override
	public String authorize(String appId, String redirectUrl, String scope, String state) throws RuntimeException {
		if (StringUtils.isBlank(appId)) {
			throw new RuntimeException("appid 公众号的唯一标识 不能为空.");
		}

		if (StringUtils.isBlank(redirectUrl)) {
			throw new RuntimeException("redirect_url 授权后重定向的回调链接地址 不能为空.");
		}

		StringBuilder sb = new StringBuilder(IOAuth2Service.HTTPS_AUTHORIZE_URL);
		sb.append("?appid=").append(appId).append("&redirect_uri=").append(redirectUrl)
			.append("&response_type=code&scope=").append(scope).append("&state=").append(state)
			.append("#wechat_redirect");

		return sb.toString();
	}

	@Override
	public AccessToken accessToken(String appId, String appSecret, String code) throws RuntimeException {
		if (StringUtils.isBlank(appId)) {
			throw new RuntimeException("appid 公众号的唯一标识 不能为空.");
		}

		if (StringUtils.isBlank(appSecret)) {
			throw new RuntimeException("secret 公众号的appsecret 不能为空.");
		}

		if (StringUtils.isBlank(code)) {
			throw new RuntimeException("code code参数 不能为空.");
		}

		StringBuilder sb = new StringBuilder(IOAuth2Service.HTTPS_ACCESS_TOKEN_URL);
		sb.append("&appid=").append(appId).append("&secret=").append(appSecret).append("&code=").append(code);

		AccessToken accessToken = null;

		try {
			accessToken = JSON.parseObject(HttpUtil.get(sb.toString()), AccessToken.class);
		} catch (Exception e) {
			logger.error(sb, e);

			throw new RuntimeException("HttpUtil error.");
		}

		if (accessToken == null) {
			throw new RuntimeException("access_token is null.");
		}

		String errCode = accessToken.getErrCode();
		if (StringUtils.isNotBlank(errCode)) {
			throw new RuntimeException(accessToken.getErrMsg());
		}

		return accessToken;
	}

	@Override
	public UserInfo getUserInfo(String accessToken, String openId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(openId)) {
			throw new RuntimeException("openId cannot be null.");
		}

		UserInfo user = null;

		try {
			user =
				JSON.parseObject(HttpUtil.get(IOAuth2Service.HTTPS_USER_INFO_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$OPENID$", openId.trim())), UserInfo.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + openId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (user == null) {
			throw new RuntimeException("user is null.");
		}

		String errCode = user.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(user.getErrMsg());
		}

		return user;
	}

}
