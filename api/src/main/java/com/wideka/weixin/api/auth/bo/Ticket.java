package com.wideka.weixin.api.auth.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Ticket extends Result {

	private static final long serialVersionUID = -2605908836535531385L;

	/**
	 * 获取到的凭证.
	 */
	@JSONField(name = "ticket")
	private String ticket;

	/**
	 * 凭证的有效时间（秒）.
	 */
	@JSONField(name = "expires_in")
	private int expiresIn;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
