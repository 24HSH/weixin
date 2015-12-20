package com.wideka.weixin.api.suite.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class IP implements Serializable {

	private static final long serialVersionUID = 1826579923131323945L;

	@JSONField(name = "ip_list")
	private String[] ipList;

	public String[] getIpList() {
		return ipList;
	}

	public void setIpList(String[] ipList) {
		this.ipList = ipList;
	}

}
