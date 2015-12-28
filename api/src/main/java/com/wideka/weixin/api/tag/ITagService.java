package com.wideka.weixin.api.tag;

import com.wideka.weixin.api.tag.bo.Tag;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ITagService {

	String HTTPS_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=";

	/**
	 * 创建标签.
	 * 
	 * @param accessToken
	 * @param tag
	 * @return
	 * @throws RuntimeException
	 */
	Tag createTag(String accessToken, Tag tag) throws RuntimeException;

}
