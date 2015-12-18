package com.wideka.weixin.api.agent.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AllowPartys implements Serializable {

	private static final long serialVersionUID = -7327327865683891937L;

	@JSONField(name = "partyid")
	private int[] partyId;

	public int[] getPartyId() {
		return partyId;
	}

	public void setPartyId(int[] partyId) {
		this.partyId = partyId;
	}

}
