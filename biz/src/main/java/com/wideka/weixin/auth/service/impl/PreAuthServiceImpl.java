package com.wideka.weixin.auth.service.impl;

import org.apache.log4j.Logger;

import com.wideka.weixin.api.auth.IPreAuthService;
import com.wideka.weixin.api.auth.bo.PreAuthCode;

/**
 * 
 * @author JiakunXu
 * 
 */
public class PreAuthServiceImpl implements IPreAuthService {

	private static Logger logger = Logger.getLogger(PreAuthServiceImpl.class);

	@Override
	public PreAuthCode getPreAuthCode(String suiteAccessToken, String suiteId, int[] appid) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
