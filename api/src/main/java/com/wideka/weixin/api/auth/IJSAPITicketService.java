package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.Ticket;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IJSAPITicketService {

	String HTTPS_TICKET_URL = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=";

	/**
	 * 
	 * @param accessToken
	 * @return
	 * @throws RuntimeException
	 */
	Ticket getTicket(String accessToken) throws RuntimeException;

}
