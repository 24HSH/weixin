package com.wideka.weixin.api.agent;

import java.util.List;

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

	String HTTPS_GET_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

	String HTTPS_SET_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token=";

	String HTTPS_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=";

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

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @return
	 * @throws RuntimeException
	 */
	Agent getAgent(String accessToken, String agentId) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param agent
	 * @return
	 * @throws RuntimeException
	 */
	Result setAgent(String accessToken, Agent agent) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @return
	 * @throws RuntimeException
	 */
	List<Agent> getAgentList(String accessToken) throws RuntimeException;

}
