package com.wideka.weixin.api.user.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserResult extends Result {

	private static final long serialVersionUID = 5861135332734253260L;

	/**
	 * 成员列表.
	 */
	@JSONField(name = "userlist")
	private List<User> userList;

	/**
	 * 1:微信邀请 2.邮件邀请.
	 */
	@JSONField(name = "type")
	private String type;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
