package com.wideka.weixin.batch.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.weixin.api.batch.IReplaceUserService;
import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.Job;
import com.wideka.weixin.api.batch.bo.ReplaceUser;
import com.wideka.weixin.framework.util.HttpUtil;
import com.wideka.weixin.framework.util.LogUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class ReplaceUserServiceImpl implements IReplaceUserService {

	private static Logger logger = Logger.getLogger(ReplaceUserServiceImpl.class);

	@Override
	public Job replaceUser(String accessToken, String mediaId, Callback callback) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(mediaId)) {
			throw new RuntimeException("media_id cannot be null.");
		}

		ReplaceUser replaceUser = new ReplaceUser();
		replaceUser.setMediaId(mediaId.trim());
		replaceUser.setCallback(callback);

		Job result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IReplaceUserService.HTTPS_REPLACE_USER_URL + accessToken.trim(),
						JSON.toJSONString(replaceUser)), Job.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(replaceUser), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result;
	}

}
