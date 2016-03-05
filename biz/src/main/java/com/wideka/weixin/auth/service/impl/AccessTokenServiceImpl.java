package com.wideka.weixin.auth.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.weixin.api.auth.IAccessTokenService;
import com.wideka.weixin.api.auth.bo.AccessToken;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AccessTokenServiceImpl implements IAccessTokenService {

	private static Logger logger = Logger.getLogger(AccessTokenServiceImpl.class);

	@Override
	public AccessToken getToken(String grantType, String appId, String appSecret) throws RuntimeException {
		if (StringUtils.isBlank(grantType)) {
			throw new RuntimeException("grant_type cannot be null.");
		}

		if (StringUtils.isBlank(appId)) {
			throw new RuntimeException("appid cannot be null.");
		}

		if (StringUtils.isBlank(appSecret)) {
			throw new RuntimeException("secret cannot be null.");
		}

		AccessToken accessToken = null;

		try {
			accessToken =
				JSON.parseObject(
					HttpUtil.get(IAccessTokenService.HTTPS_TOKEN_URL.replace("$grantType$", grantType.trim())
						.replace("$appId$", appId.trim()).replace("$appSecret$", appSecret.trim())), AccessToken.class);
		} catch (Exception e) {
			logger.error(grantType + "&" + appId + "&" + appSecret, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (accessToken == null) {
			throw new RuntimeException("access_token is null.");
		}

		String errCode = accessToken.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(accessToken.getErrMsg());
		}

		String token = accessToken.getAccessToken();

		if (StringUtils.isBlank(token)) {
			throw new RuntimeException("access_token is blank.");
		}

		return accessToken;
	}

	@Override
	public AccessToken getToken(String corpId, String corpSecret) throws RuntimeException {
		if (StringUtils.isBlank(corpId)) {
			throw new RuntimeException("corpid cannot be null.");
		}

		if (StringUtils.isBlank(corpSecret)) {
			throw new RuntimeException("corpsecret cannot be null.");
		}

		AccessToken accessToken = null;

		try {
			accessToken =
				JSON.parseObject(
					HttpUtil.get(IAccessTokenService.HTTPS_TOKEN_ULR.replace("$id$", corpId.trim()).replace(
						"$secrect$", corpSecret.trim())), AccessToken.class);
		} catch (Exception e) {
			logger.error(corpId + "&" + corpSecret, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (accessToken == null) {
			throw new RuntimeException("access_token is null.");
		}

		String errCode = accessToken.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(accessToken.getErrMsg());
		}

		String token = accessToken.getAccessToken();

		if (StringUtils.isBlank(token)) {
			throw new RuntimeException("access_token is blank.");
		}

		return accessToken;
	}

	@Override
	public AccessToken getCorpToken(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode)
		throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
