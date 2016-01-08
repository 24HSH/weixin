package com.wideka.weixin.api.tag;

import com.wideka.weixin.api.tag.bo.Tag;
import com.wideka.weixin.api.tag.bo.TagResult;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ITagService {

	String HTTPS_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=";

	String HTTPS_UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=";

	String HTTPS_DELETE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=$ACCESS_TOKEN$&tagid=$TAGID$";

	String HTTPS_GET_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=$ACCESS_TOKEN$&tagid=$TAGID$";

	/**
	 * 创建标签.
	 * 
	 * @param accessToken
	 * @param tag
	 * @return
	 * @throws RuntimeException
	 */
	Tag createTag(String accessToken, Tag tag) throws RuntimeException;

	/**
	 * 更新标签名字.
	 * 
	 * @param accessToken
	 * @param tag
	 * @return
	 * @throws RuntimeException
	 */
	Result updateTag(String accessToken, Tag tag) throws RuntimeException;

	/**
	 * 删除标签.
	 * 
	 * @param accessToken
	 * @param tagId
	 * @return
	 * @throws RuntimeException
	 */
	Result deleteTag(String accessToken, String tagId) throws RuntimeException;

	/**
	 * 获取标签成员.
	 * 
	 * @param accessToken
	 * @param tagId
	 * @return
	 * @throws RuntimeException
	 */
	TagResult getTag(String accessToken, String tagId) throws RuntimeException;

}
