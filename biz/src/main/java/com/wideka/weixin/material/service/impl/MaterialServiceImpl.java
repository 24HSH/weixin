package com.wideka.weixin.material.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.material.IMaterialService;
import com.wideka.weixin.api.material.bo.MaterialCount;
import com.wideka.weixin.api.material.bo.MaterialMPNews;
import com.wideka.weixin.api.material.bo.MaterialResult;
import com.wideka.weixin.api.message.bo.MPNews;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MaterialServiceImpl implements IMaterialService {

	private static Logger logger = Logger.getLogger(MaterialServiceImpl.class);

	@Override
	public MaterialResult addMPNews(String accessToken, int agentId, MPNews mpNews) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (mpNews == null) {
			throw new RuntimeException("mpnews cannot be null.");
		}

		MaterialMPNews materialMPNews = new MaterialMPNews();
		materialMPNews.setAgentId(agentId);
		materialMPNews.setMpNews(mpNews);

		MaterialResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IMaterialService.HTTPS_ADD_MPNEWS_URL + accessToken.trim(),
						JSON.toJSONString(materialMPNews)), MaterialResult.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(materialMPNews), e);

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

	@Override
	public Result deleteMaterial(String accessToken, String agentId, String mediaId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		if (StringUtils.isBlank(mediaId)) {
			throw new RuntimeException("media_id cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(IMaterialService.HTTPS_DEL_URL.replace("$ACCESS_TOKEN$", accessToken.trim())
						.replace("$AGENTID$", agentId.trim()).replace("$MEDIA_ID$", mediaId.trim())), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId + "&" + mediaId, e);

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

	@Override
	public Result updateMPNews(String accessToken, int agentId, String mediaId, MPNews mpNews) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(mediaId)) {
			throw new RuntimeException("media_id cannot be null.");
		}

		if (mpNews == null) {
			throw new RuntimeException("mpnews cannot be null.");
		}

		MaterialMPNews materialMPNews = new MaterialMPNews();
		materialMPNews.setAgentId(agentId);
		materialMPNews.setMediaId(mediaId.trim());
		materialMPNews.setMpNews(mpNews);

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IMaterialService.HTTPS_UPDATE_MPNEWS_URL + accessToken.trim(),
						JSON.toJSONString(materialMPNews)), Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(materialMPNews), e);

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
				JSON.parseObject(HttpUtil.get(IMaterialService.HTTPS_GET_COUNT_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$AGENTID$", agentId.trim())), MaterialCount.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (materialCount == null) {
			throw new RuntimeException("material_count is null.");
		}

		String errCode = materialCount.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(materialCount.getErrMsg());
		}

		return materialCount;
	}

}
