package com.wideka.weixin.batch.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.batch.ISyncUserService;
import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.Job;
import com.wideka.weixin.api.batch.bo.SyncUser;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SyncUserServiceImpl implements ISyncUserService {

	private static Logger logger = Logger.getLogger(SyncUserServiceImpl.class);

	@Override
	public Job syncUser(String accessToken, String mediaId, Callback callback) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(mediaId)) {
			throw new RuntimeException("media_id cannot be null.");
		}

		SyncUser syncUser = new SyncUser();
		syncUser.setMediaId(mediaId.trim());
		syncUser.setCallback(callback);

		Job result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(ISyncUserService.HTTPS_SYNC_USER_URL + accessToken.trim(),
						JSON.toJSONString(syncUser)), Job.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(syncUser), e);

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
