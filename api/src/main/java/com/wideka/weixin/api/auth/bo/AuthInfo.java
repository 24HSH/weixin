package com.wideka.weixin.api.auth.bo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.agent.bo.Agent;
import com.wideka.weixin.api.department.bo.Department;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AuthInfo implements Serializable {

	private static final long serialVersionUID = 2651195800551735848L;

	/**
	 * 授权的应用信息.
	 */
	@JSONField(name = "agent")
	private List<Agent> agentList;

	/**
	 * 授权的通讯录部门.
	 */
	@JSONField(name = "department")
	private List<Department> departmentList;

	public List<Agent> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<Agent> agentList) {
		this.agentList = agentList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

}
