package com.wideka.weixin.user.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.weixin.api.user.IUserInfoService;
import com.wideka.weixin.api.user.bo.UserInfo;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserInfoServiceImpl implements IUserInfoService {

	private static Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

	@Override
	public UserInfo getUserInfo(String accessToken, String code) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(code)) {
			throw new RuntimeException("code cannot be null.");
		}

		UserInfo userInfo = null;

		try {
			userInfo =
				JSON.parseObject(
					HttpUtil.get(IUserInfoService.HTTPS_USER_INFO_URL.replace("$ACCESS_TOKEN$", accessToken).replace(
						"$CODE$", code)), UserInfo.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + code, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (userInfo == null) {
			throw new RuntimeException("user is null.");
		}

		String errCode = userInfo.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(userInfo.getErrMsg());
		}

		return userInfo;
	}

}
