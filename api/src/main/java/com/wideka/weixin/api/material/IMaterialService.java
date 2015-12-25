package com.wideka.weixin.api.material;

import com.wideka.weixin.api.material.bo.MaterialCount;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMaterialService {

	String HTTPS_COUNT_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/material/get_count?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

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
