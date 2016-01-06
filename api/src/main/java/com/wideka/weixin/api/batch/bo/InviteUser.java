package com.wideka.weixin.api.batch.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class InviteUser implements Serializable {

	private static final long serialVersionUID = -6340953157176084655L;

	@JSONField(name = "touser")
	private String toUser;

	@JSONField(name = "toparty")
	private String toParty;

	@JSONField(name = "totag")
	private String toTag;

	@JSONField(name = "callback")
	private Callback callback;

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToParty() {
		return toParty;
	}

	public void setToParty(String toParty) {
		this.toParty = toParty;
	}

	public String getToTag() {
		return toTag;
	}

	public void setToTag(String toTag) {
		this.toTag = toTag;
	}

	public Callback getCallback() {
		return callback;
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

}
