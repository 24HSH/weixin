package com.wideka.weixin.tag.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.tag.ITagService;
import com.wideka.weixin.api.tag.bo.Tag;

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

		Tag result = new Tag();

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

}
