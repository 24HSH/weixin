package com.wideka.weixin.api.user.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserObject implements Serializable {

	private static final long serialVersionUID = -5201996196454578847L;

	@JSONField(name = "useridlist")
	private String[] userIdList;

	public String[] getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(String[] userIdList) {
		this.userIdList = userIdList;
	}

}
