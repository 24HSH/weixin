package com.wideka.weixin.auth.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.auth.IAuthService;
import com.wideka.weixin.api.auth.bo.Info;
import com.wideka.weixin.api.suite.bo.Suite;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AuthServiceImpl implements IAuthService {

	private static Logger logger = Logger.getLogger(AuthServiceImpl.class);

	@Override
	public Info getAuthInfo(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode)
		throws RuntimeException {
		if (StringUtils.isBlank(suiteAccessToken)) {
			throw new RuntimeException("suite_access_token cannot be null.");
		}

		if (StringUtils.isBlank(suiteId)) {
			throw new RuntimeException("suite_id cannot be null.");
		}

		if (StringUtils.isBlank(authCorpId)) {
			throw new RuntimeException("auth_corpid cannot be null.");
		}

		if (StringUtils.isBlank(permanentCode)) {
			throw new RuntimeException("permanent_code cannot be null.");
		}

		Suite suite = new Suite();
		suite.setSuiteId(suiteId.trim());
		suite.setAuthCorpId(authCorpId.trim());
		suite.setPermanentCode(permanentCode.trim());

		Info info = null;

		try {
			info =
				JSON.parseObject(
					HttpUtil.post(IAuthService.HTTPS_AUTH_INFO_URL + suiteAccessToken.trim(), JSON.toJSONString(suite)),
					Info.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(suite), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (info == null) {
			throw new RuntimeException("auth_info is null.");
		}

		return info;
	}

}
