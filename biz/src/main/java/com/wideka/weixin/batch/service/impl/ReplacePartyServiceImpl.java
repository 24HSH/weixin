package com.wideka.weixin.batch.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.batch.IReplacePartyService;
import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.Job;
import com.wideka.weixin.api.batch.bo.ReplaceParty;

/**
 * 
 * @author JiakunXu
 * 
 */
public class ReplacePartyServiceImpl implements IReplacePartyService {

	private static Logger logger = Logger.getLogger(ReplacePartyServiceImpl.class);

	@Override
	public Job replaceParty(String accessToken, String mediaId, Callback callback) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(mediaId)) {
			throw new RuntimeException("media_id cannot be null.");
		}

		ReplaceParty replaceParty = new ReplaceParty();
		replaceParty.setMediaId(mediaId.trim());
		replaceParty.setCallback(callback);

		Job result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IReplacePartyService.HTTPS_REPLACE_PARTY_URL + accessToken.trim(),
						JSON.toJSONString(replaceParty)), Job.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(replaceParty), e);

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
