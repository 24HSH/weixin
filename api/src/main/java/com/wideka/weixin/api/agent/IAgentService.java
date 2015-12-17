package com.wideka.weixin.api.agent;

import com.wideka.weixin.api.agent.bo.Agent;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IAgentService {

	String HTTPS_AGENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_agent?suite_access_token=";

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 *            应用套件id.
	 * @param authCorpId
	 * @param permanentCode
	 * @param agentId
	 * @throws RuntimeException
	 */
	Agent getAgent(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode, int agentId)
		throws RuntimeException;

}
