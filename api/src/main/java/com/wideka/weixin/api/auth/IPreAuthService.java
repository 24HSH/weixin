package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.PreAuthCode;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IPreAuthService {

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 * @param appid
	 * @return
	 * @throws RuntimeException
	 */
	PreAuthCode getPreAuthCode(String suiteAccessToken, String suiteId, int[] appid) throws RuntimeException;

}
