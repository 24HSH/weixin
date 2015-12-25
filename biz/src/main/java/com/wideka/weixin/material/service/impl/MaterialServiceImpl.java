package com.wideka.weixin.material.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.weixin.api.material.IMaterialService;
import com.wideka.weixin.api.material.bo.MaterialCount;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MaterialServiceImpl implements IMaterialService {

	private static Logger logger = Logger.getLogger(MaterialServiceImpl.class);

	@Override
	public MaterialCount getCount(String accessToken, String agentId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		MaterialCount materialCount = null;

		try {
			materialCount =
				JSON.parseObject(HttpUtil.get(IMaterialService.HTTPS_COUNT_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$AGENTID$", agentId.trim())), MaterialCount.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (materialCount == null) {
			throw new RuntimeException("access_token is null.");
		}

		String errCode = materialCount.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(materialCount.getErrMsg());
		}

		return materialCount;
	}

}
