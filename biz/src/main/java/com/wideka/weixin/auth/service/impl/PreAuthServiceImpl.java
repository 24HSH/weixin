package com.wideka.weixin.auth.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.auth.IPreAuthService;
import com.wideka.weixin.api.auth.bo.PreAuthCode;
import com.wideka.weixin.api.suite.bo.Err;
import com.wideka.weixin.api.suite.bo.Suite;

/**
 * 
 * @author JiakunXu
 * 
 */
public class PreAuthServiceImpl implements IPreAuthService {

	private static Logger logger = Logger.getLogger(PreAuthServiceImpl.class);

	@Override
	public PreAuthCode getPreAuthCode(String suiteAccessToken, String suiteId, int[] appId) throws RuntimeException {
		if (StringUtils.isBlank(suiteAccessToken)) {
			throw new RuntimeException("suite_access_token cannot be null.");
		}

		if (StringUtils.isBlank(suiteId)) {
			throw new RuntimeException("suite_id cannot be null.");
		}

		Suite suite = new Suite();
		suite.setSuiteId(suiteId.trim());

		PreAuthCode preAuthCode = null;

		try {
			preAuthCode =
				JSON.parseObject(
					HttpUtil.post(IPreAuthService.HTTPS_PRE_AUTH_CODE_URL + suiteAccessToken.trim(),
						JSON.toJSONString(suite)), PreAuthCode.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(suite), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (preAuthCode == null) {
			throw new RuntimeException("pre_auth_code is null.");
		}

		if (!"0".equals(preAuthCode.getErrCode())) {
			throw new RuntimeException(preAuthCode.getErrMsg());
		}

		String code = preAuthCode.getPreAuthCode();

		if (StringUtils.isBlank(code)) {
			throw new RuntimeException("pre_auth_code is blank.");
		}

		if (!setSessionInfo(suiteAccessToken.trim(), code, appId)) {
			throw new RuntimeException("set_session_info error.");
		}

		return preAuthCode;
	}

	private boolean setSessionInfo(String suiteAccessToken, String preAuthCode, int[] appId) {
		if (appId == null || appId.length == 0) {
			return true;
		}

		StringBuilder ids = new StringBuilder();
		for (int id : appId) {
			if (ids.length() > 0) {
				ids.append(",");
			}
			ids.append(id);
		}

		StringBuilder params = new StringBuilder();
		params.append("{");
		params.append("\"pre_auth_code\":\"" + preAuthCode + "\",");
		params.append("\"session_info\":");
		params.append("{");
		params.append("\"appid\":[" + ids + "]");
		params.append("}");
		params.append("}");

		Err err = null;

		try {
			err =
				JSON.parseObject(
					HttpUtil.post(IPreAuthService.HTTPS_SESSION_INFO_URL + suiteAccessToken, params.toString()),
					Err.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(params), e);

			return false;
		}

		if (err == null) {
			return false;
		}

		if (!"0".equals(err.getErrCode())) {
			return false;
		}

		return true;
	}
}
