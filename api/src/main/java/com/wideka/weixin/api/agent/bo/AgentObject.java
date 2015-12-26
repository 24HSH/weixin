package com.wideka.weixin.api.agent.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AgentObject extends Result {

	private static final long serialVersionUID = -2116918171269623887L;

	@JSONField(name = "agentlist")
	private List<Agent> agentList;

	public List<Agent> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<Agent> agentList) {
		this.agentList = agentList;
	}

}
