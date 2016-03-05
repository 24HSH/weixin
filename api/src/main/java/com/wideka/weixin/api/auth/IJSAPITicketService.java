package com.wideka.weixin.api.auth;

import com.wideka.weixin.api.auth.bo.Ticket;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IJSAPITicketService {

	String HTTPS_TICKET_URL =
		"https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=$accessToken$&type=jsapi";

	String HTTPS_TICKET_ULR = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=";

	/**
	 * 
	 * @param accessToken
	 * @return
	 * @throws RuntimeException
	 */
	Ticket getTicket(String accessToken) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @return
	 * @throws RuntimeException
	 */
	Ticket getTicket4Corp(String accessToken) throws RuntimeException;

}
