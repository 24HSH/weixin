package com.wideka.weixin.api.tag.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class TagObject implements Serializable {

	private static final long serialVersionUID = -3479178962716304136L;

	/**
	 * 标签ID.
	 */
	@JSONField(name = "tagid")
	private String tagId;

	/**
	 * 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000.
	 */
	@JSONField(name = "userlist")
	private String[] userList;

	/**
	 * 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100.
	 */
	@JSONField(name = "partylist")
	private int[] partyList;

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String[] getUserList() {
		return userList;
	}

	public void setUserList(String[] userList) {
		this.userList = userList;
	}

	public int[] getPartyList() {
		return partyList;
	}

	public void setPartyList(int[] partyList) {
		this.partyList = partyList;
	}

}
