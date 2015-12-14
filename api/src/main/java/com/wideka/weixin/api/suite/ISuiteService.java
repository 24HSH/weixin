package com.wideka.weixin.api.suite;

import com.wideka.weixin.api.suite.bo.SuiteAccessToken;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ISuiteService {

	String HTTPS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token";

	/**
	 * 
	 * @param suiteId
	 * @param suiteSecret
	 * @param suiteTicket
	 * @return
	 * @throws RuntimeException
	 */
	SuiteAccessToken getSuiteToken(String suiteId, String suiteSecret, String suiteTicket) throws RuntimeException;

}
