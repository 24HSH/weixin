package com.wideka.weixin.suite.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.suite.ISuiteService;
import com.wideka.weixin.api.suite.bo.SuiteAccessToken;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SuiteServiceImpl implements ISuiteService {

	private static Logger logger = Logger.getLogger(SuiteServiceImpl.class);

	@Override
	public SuiteAccessToken getSuiteToken(String suiteId, String suiteSecret, String suiteTicket)
		throws RuntimeException {
		if (StringUtils.isBlank(suiteId)) {
			throw new RuntimeException("suite_id cannot be null.");
		}

		if (StringUtils.isBlank(suiteSecret)) {
			throw new RuntimeException("suite_secret cannot be null.");
		}

		if (StringUtils.isBlank(suiteTicket)) {
			throw new RuntimeException("suite_ticket cannot be null.");
		}

		Map<String, String> params = new HashMap<String, String>();
		params.put("suite_id", suiteId);
		params.put("suite_secret", suiteSecret);
		params.put("suite_ticket", suiteTicket);

		SuiteAccessToken suiteAccessToken = null;

		try {
			suiteAccessToken =
				JSON.parseObject(HttpUtil.post(ISuiteService.HTTPS_TOKEN_URL, params), SuiteAccessToken.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(params), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (suiteAccessToken == null) {
			throw new RuntimeException("suite_access_token is null.");
		}

		return suiteAccessToken;
	}

}
