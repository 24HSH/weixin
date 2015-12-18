package com.wideka.weixin.agent.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.agent.IAgentService;
import com.wideka.weixin.api.agent.bo.Agent;
import com.wideka.weixin.api.suite.bo.SuiteExtends;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AgentServiceImpl implements IAgentService {

	private static Logger logger = Logger.getLogger(AgentServiceImpl.class);

	@Override
	public Agent getAgent(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode, int agentId)
		throws RuntimeException {
		if (StringUtils.isBlank(suiteAccessToken)) {
			throw new RuntimeException("suite_access_token cannot be null.");
		}

		if (StringUtils.isBlank(suiteId)) {
			throw new RuntimeException("suite_id cannot be null.");
		}

		if (StringUtils.isBlank(authCorpId)) {
			throw new RuntimeException("auth_corpid cannot be null.");
		}

		if (StringUtils.isBlank(permanentCode)) {
			throw new RuntimeException("permanent_code cannot be null.");
		}

		SuiteExtends suite = new SuiteExtends();
		suite.setSuiteId(suiteId.trim());
		suite.setAuthCorpId(authCorpId.trim());
		suite.setPermanentCode(permanentCode.trim());
		suite.setAgentId(agentId);

		Agent agent = null;

		try {
			agent =
				JSON.parseObject(HttpUtil.post(IAgentService.HTTPS_GET_AGENT_URL + suiteAccessToken.trim(),
					JSON.toJSONString(suite)), Agent.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(suite), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (agent == null) {
			throw new RuntimeException("agent is null.");
		}

		String errCode = agent.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(agent.getErrMsg());
		}

		return agent;
	}

	@Override
	public Result setAgent(String suiteAccessToken, String suiteId, String authCorpId, String permanentCode, Agent agent)
		throws RuntimeException {
		if (StringUtils.isBlank(suiteAccessToken)) {
			throw new RuntimeException("suite_access_token cannot be null.");
		}

		if (StringUtils.isBlank(suiteId)) {
			throw new RuntimeException("suite_id cannot be null.");
		}

		if (StringUtils.isBlank(authCorpId)) {
			throw new RuntimeException("auth_corpid cannot be null.");
		}

		if (StringUtils.isBlank(permanentCode)) {
			throw new RuntimeException("permanent_code cannot be null.");
		}

		if (agent == null) {
			throw new RuntimeException("agent cannot be null.");
		}

		SuiteExtends suite = new SuiteExtends();
		suite.setSuiteId(suiteId.trim());
		suite.setAuthCorpId(authCorpId.trim());
		suite.setPermanentCode(permanentCode.trim());
		suite.setAgent(agent);

		Result result = null;

		try {
			result =
				JSON.parseObject(HttpUtil.post(IAgentService.HTTPS_SET_AGENT_URL + suiteAccessToken.trim(),
					JSON.toJSONString(suite)), Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(suite), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result;
	}

}
