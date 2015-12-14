package com.wideka.weixin.api.suite.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Suite implements Serializable {

	private static final long serialVersionUID = -576933360630351605L;

	@JSONField(name = "suite_id")
	private String suiteId;

	@JSONField(name = "suite_secret")
	private String suiteSecret;

	@JSONField(name = "suite_ticket")
	private String suiteTicket;

	public String getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}

	public String getSuiteSecret() {
		return suiteSecret;
	}

	public void setSuiteSecret(String suiteSecret) {
		this.suiteSecret = suiteSecret;
	}

	public String getSuiteTicket() {
		return suiteTicket;
	}

	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}

}
