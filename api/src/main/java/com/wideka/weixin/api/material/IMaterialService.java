package com.wideka.weixin.api.material;

import com.wideka.weixin.api.material.bo.MaterialCount;
import com.wideka.weixin.api.material.bo.MaterialResult;
import com.wideka.weixin.api.message.bo.MPNews;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMaterialService {

	String HTTPS_ADD_MPNEWS_URL = "https://qyapi.weixin.qq.com/cgi-bin/material/add_mpnews?access_token=";

	String HTTPS_ADD_MATERIAL_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/material/add_material?agentid=$AGENTID$&type=$TYPE$&access_token=$ACCESS_TOKEN$";

	String HTTPS_GET_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/material/get?access_token=$ACCESS_TOKEN$&media_id=$MEDIA_ID$&agentid=$AGENTID$";

	String HTTPS_DEL_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/material/del?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$&media_id=$MEDIA_ID$";

	String HTTPS_UPDATE_MPNEWS_URL = "https://qyapi.weixin.qq.com/cgi-bin/material/update_mpnews?access_token=";

	String HTTPS_GET_COUNT_URL =
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
	 * 
	 * @param accessToken
	 * @param agentId
	 * @param mediaId
	 * @return
	 * @throws RuntimeException
	 */
	Result deleteMaterial(String accessToken, String agentId, String mediaId) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @param mediaId
	 * @param mpNews
	 * @return
	 * @throws RuntimeException
	 */
	Result updateMPNews(String accessToken, int agentId, String mediaId, MPNews mpNews) throws RuntimeException;

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
