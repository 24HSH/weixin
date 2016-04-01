package com.wideka.weixin.auth.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.weixin.api.auth.IPermanentService;
import com.wideka.weixin.api.auth.bo.PermanentCode;
import com.wideka.weixin.api.suite.bo.SuiteExtend;
import com.wideka.weixin.framework.util.HttpUtil;
import com.wideka.weixin.framework.util.LogUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class PermanentServiceImpl implements IPermanentService {

	private static Logger logger = Logger.getLogger(PermanentServiceImpl.class);

	@Override
	public PermanentCode getPermanentCode(String suiteAccessToken, String suiteId, String authCode) {
		if (StringUtils.isBlank(suiteAccessToken)) {
			throw new RuntimeException("suite_access_token cannot be null.");
		}

		if (StringUtils.isBlank(suiteId)) {
			throw new RuntimeException("suite_id cannot be null.");
		}

		if (StringUtils.isBlank(authCode)) {
			throw new RuntimeException("auth_code cannot be null.");
		}

		SuiteExtend suite = new SuiteExtend();
		suite.setSuiteId(suiteId.trim());
		suite.setAuthCode(authCode);

		PermanentCode permanentCode = null;

		try {
			permanentCode =
				JSON.parseObject(
					HttpUtil.post(IPermanentService.HTTPS_PERMANENT_CODE_URL + suiteAccessToken.trim(),
						JSON.toJSONString(suite)), PermanentCode.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(suite), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (permanentCode == null) {
			throw new RuntimeException("permanent_code is null.");
		}

		return permanentCode;
	}

}
