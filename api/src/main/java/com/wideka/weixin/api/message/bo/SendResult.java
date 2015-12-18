package com.wideka.weixin.api.message.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SendResult extends Result {

	private static final long serialVersionUID = 2091112238761729828L;

	@JSONField(name = "invaliduser")
	private String invalidUser;

	@JSONField(name = "invalidparty")
	private String invalidParty;

	@JSONField(name = "invalidtag")
	private String invalidTag;

	public String getInvalidUser() {
		return invalidUser;
	}

	public void setInvalidUser(String invalidUser) {
		this.invalidUser = invalidUser;
	}

	public String getInvalidParty() {
		return invalidParty;
	}

	public void setInvalidParty(String invalidParty) {
		this.invalidParty = invalidParty;
	}

	public String getInvalidTag() {
		return invalidTag;
	}

	public void setInvalidTag(String invalidTag) {
		this.invalidTag = invalidTag;
	}

}
