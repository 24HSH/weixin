package com.wideka.weixin.auth.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.weixin.api.auth.IJSAPITicketService;
import com.wideka.weixin.api.auth.bo.Ticket;

/**
 * 
 * @author JiakunXu
 * 
 */
public class JSAPITicketServiceImpl implements IJSAPITicketService {

	private static Logger logger = Logger.getLogger(JSAPITicketServiceImpl.class);

	@Override
	public Ticket getTicket(String accessToken) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		Ticket ticket = null;

		try {
			ticket =
				JSON.parseObject(
					HttpUtil.get(IJSAPITicketService.HTTPS_TICKET_URL.replace("$accessToken$", accessToken.trim())),
					Ticket.class);
		} catch (Exception e) {
			logger.error(accessToken, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (ticket == null) {
			throw new RuntimeException("ticket is null.");
		}

		String errCode = ticket.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(ticket.getErrMsg());
		}

		String token = ticket.getTicket();

		if (StringUtils.isBlank(token)) {
			throw new RuntimeException("ticket is blank.");
		}

		return ticket;
	}

	@Override
	public Ticket getTicket4Corp(String accessToken) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		Ticket ticket = null;

		try {
			ticket =
				JSON.parseObject(HttpUtil.get(IJSAPITicketService.HTTPS_TICKET_ULR + accessToken.trim()), Ticket.class);
		} catch (Exception e) {
			logger.error(accessToken, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (ticket == null) {
			throw new RuntimeException("ticket is null.");
		}

		String errCode = ticket.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(ticket.getErrMsg());
		}

		String token = ticket.getTicket();

		if (StringUtils.isBlank(token)) {
			throw new RuntimeException("ticket is blank.");
		}

		return ticket;
	}

}
