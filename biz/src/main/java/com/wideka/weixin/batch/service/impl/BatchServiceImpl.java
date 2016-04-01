package com.wideka.weixin.batch.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.weixin.api.batch.IBatchService;
import com.wideka.weixin.api.batch.bo.Batch;
import com.wideka.weixin.framework.util.HttpUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class BatchServiceImpl implements IBatchService {

	private static Logger logger = Logger.getLogger(BatchServiceImpl.class);

	@Override
	public Batch getResult(String accessToken, String jobId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(jobId)) {
			throw new RuntimeException("jobid cannot be null.");
		}

		Batch result = null;

		try {
			result =
				JSON.parseObject(HttpUtil.get(IBatchService.HTTPS_GET_RESULT_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$JOBID$", jobId.trim())), Batch.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + jobId, e);

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
