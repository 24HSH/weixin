package com.wideka.weixin.api.material;

import com.wideka.weixin.api.material.bo.MaterialCount;
import com.wideka.weixin.api.material.bo.MaterialResult;
import com.wideka.weixin.api.message.bo.MPNews;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMaterialService {

	String HTTPS_ADD_MPNEWS_URL = "https://qyapi.weixin.qq.com/cgi-bin/material/add_mpnews?access_token=";

	String HTTPS_COUNT_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/material/get_count?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @param mpNews
	 * @return
	 * @throws RuntimeException
	 */
	MaterialResult addMPNews(String accessToken, int agentId, MPNews mpNews) throws RuntimeException;

	/**
	 * 本接口可以获取应用素材总数以及每种类型素材的数目.
	 * 
	 * @param accessToken
	 *            调用接口凭证.
	 * @param agentId
	 *            企业应用的id，整型。可在应用的设置页面查看.
	 * @return
	 * @throws RuntimeException
	 */
	MaterialCount getCount(String accessToken, String agentId) throws RuntimeException;

}
