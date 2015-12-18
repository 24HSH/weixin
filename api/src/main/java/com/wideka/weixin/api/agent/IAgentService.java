package com.wideka.weixin.api.agent;

import com.wideka.weixin.api.agent.bo.Agent;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IAgentService {

	String HTTPS_GET_AGENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_agent?suite_access_token=";

	String HTTPS_SET_AGENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/set_agent?suite_access_token=";

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

	/**
	 * 
	 * @param suiteAccessToken
	 * @param suiteId
	 * @param authCorpId
	 * @param permanentCode
	 * @param agent
	 * @return
	 * @throws RuntimeException
	 */
	Result setAgent(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode, Agent agent)
		throws RuntimeException;

}
