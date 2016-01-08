package com.wideka.weixin.tag.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.tag.ITagService;
import com.wideka.weixin.api.tag.bo.Tag;
import com.wideka.weixin.api.tag.bo.TagObject;
import com.wideka.weixin.api.tag.bo.TagResult;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class TagServiceImpl implements ITagService {

	private static Logger logger = Logger.getLogger(TagServiceImpl.class);

	@Override
	public Tag createTag(String accessToken, Tag tag) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (tag == null) {
			throw new RuntimeException("tag cannot be null.");
		}

		Tag result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(ITagService.HTTPS_CREATE_URL + accessToken.trim(), JSON.toJSONString(tag)), Tag.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(tag), e);

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
	public Result updateTag(String accessToken, Tag tag) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (tag == null) {
			throw new RuntimeException("tag cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(ITagService.HTTPS_UPDATE_URL + accessToken.trim(), JSON.toJSONString(tag)),
					Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(tag), e);

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
	public Result deleteTag(String accessToken, String tagId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(tagId)) {
			throw new RuntimeException("tagid cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(ITagService.HTTPS_DELETE_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$TAGID$", tagId.trim())), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + tagId, e);

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
	public TagResult getTag(String accessToken, String tagId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(tagId)) {
			throw new RuntimeException("tagid cannot be null.");
		}

		TagResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(ITagService.HTTPS_GET_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$TAGID$", tagId.trim())), TagResult.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + tagId, e);

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
	public TagResult addTagUsers(String accessToken, String tagId, TagObject tagObject) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(tagId)) {
			throw new RuntimeException("tagid cannot be null.");
		}

		if (tagObject == null) {
			throw new RuntimeException("tagObject cannot be null.");
		}

		tagObject.setTagId(tagId.trim());

		TagResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(ITagService.HTTPS_ADD_TAG_USERS_URL + accessToken.trim(),
						JSON.toJSONString(tagObject)), TagResult.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(tagObject), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		return result;
	}

	@Override
	public TagResult delTagUsers(String accessToken, String tagId, TagObject tagObject) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(tagId)) {
			throw new RuntimeException("tagid cannot be null.");
		}

		if (tagObject == null) {
			throw new RuntimeException("tagObject cannot be null.");
		}

		tagObject.setTagId(tagId.trim());

		TagResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(ITagService.HTTPS_DEL_TAG_USERS_URL + accessToken.trim(),
						JSON.toJSONString(tagObject)), TagResult.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(tagObject), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		return result;
	}

}
