package com.wideka.weixin.api.tag.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.user.bo.User;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class TagResult extends Result {

	private static final long serialVersionUID = -3529767670769908067L;

	/**
	 * 成员列表.
	 */
	@JSONField(name = "userlist")
	private List<User> userList;

	/**
	 * 部门列表.
	 */
	@JSONField(name = "partylist")
	private int[] partyList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int[] getPartyList() {
		return partyList;
	}

	public void setPartyList(int[] partyList) {
		this.partyList = partyList;
	}

}
