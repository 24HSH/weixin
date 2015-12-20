package com.wideka.weixin.api.suite.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.agent.bo.Agent;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SuiteExtend extends Suite {

	private static final long serialVersionUID = -6358122226044239616L;

	/**
	 * 临时授权码会在授权成功时附加在redirect_uri中跳转回应用提供商网站.
	 */
	@JSONField(name = "auth_code")
	private String authCode;

	/**
	 * 授权方corpid.
	 */
	@JSONField(name = "auth_corpid")
	private String authCorpId;

	/**
	 * 永久授权码，通过get_permanent_code获取.
	 */
	@JSONField(name = "permanent_code")
	private String permanentCode;

	/**
	 * 授权方应用id.
	 */
	@JSONField(name = "agentid")
	private int agentId;

	/**
	 * 要设置的企业应用的信息.
	 */
	@JSONField(name = "agent")
	private Agent agent;

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthCorpId() {
		return authCorpId;
	}

	public void setAuthCorpId(String authCorpId) {
		this.authCorpId = authCorpId;
	}

	public String getPermanentCode() {
		return permanentCode;
	}

	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
