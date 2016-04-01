package com.wideka.weixin.suite.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.weixin.api.suite.ISuiteService;
import com.wideka.weixin.api.suite.bo.Suite;
import com.wideka.weixin.api.suite.bo.SuiteAccessToken;
import com.wideka.weixin.framework.util.HttpUtil;
import com.wideka.weixin.framework.util.LogUtil;

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

		Suite suite = new Suite();
		suite.setSuiteId(suiteId.trim());
		suite.setSuiteSecret(suiteSecret.trim());
		suite.setSuiteTicket(suiteTicket.trim());

		SuiteAccessToken suiteAccessToken = null;

		try {
			suiteAccessToken =
				JSON.parseObject(HttpUtil.post(ISuiteService.HTTPS_SUITE_TOKEN_URL, JSON.toJSONString(suite)),
					SuiteAccessToken.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(suite), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (suiteAccessToken == null) {
			throw new RuntimeException("suite_access_token is null.");
		}

		if (StringUtils.isBlank(suiteAccessToken.getSuiteAccessToken())) {
			throw new RuntimeException("suite_access_token is blank.");
		}

		return suiteAccessToken;
	}
}
