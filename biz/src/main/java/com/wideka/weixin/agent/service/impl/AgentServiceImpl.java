package com.wideka.weixin.agent.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.weixin.api.agent.IAgentService;
import com.wideka.weixin.api.agent.bo.Agent;
import com.wideka.weixin.api.agent.bo.AgentObject;
import com.wideka.weixin.api.suite.bo.SuiteExtend;
import com.wideka.weixin.framework.bo.Result;
import com.wideka.weixin.framework.util.HttpUtil;
import com.wideka.weixin.framework.util.LogUtil;

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

		SuiteExtend suite = new SuiteExtend();
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

		SuiteExtend suite = new SuiteExtend();
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

	@Override
	public Agent getAgent(String accessToken, String agentId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		Agent agent = null;

		try {
			agent =
				JSON.parseObject(
					HttpUtil.get(IAgentService.HTTPS_GET_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$AGENTID$", agentId.trim())), Agent.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

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
	public Result setAgent(String accessToken, Agent agent) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (agent == null) {
			throw new RuntimeException("agent cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IAgentService.HTTPS_SET_URL + accessToken.trim(), JSON.toJSONString(agent)),
					Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(agent), e);

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

	@Override
	public List<Agent> getAgentList(String accessToken) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		AgentObject agentObject = null;

		try {
			agentObject =
				JSON.parseObject(HttpUtil.get(IAgentService.HTTPS_LIST_URL + accessToken.trim()), AgentObject.class);
		} catch (Exception e) {
			logger.error(accessToken, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (agentObject == null || agentObject.getAgentList() == null || agentObject.getAgentList().size() == 0) {
			throw new RuntimeException("agent is null.");
		}

		String errCode = agentObject.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(agentObject.getErrMsg());
		}

		return agentObject.getAgentList();
	}
}
