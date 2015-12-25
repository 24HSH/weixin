package com.wideka.weixin.api.menu;

import com.wideka.weixin.api.menu.bo.Menu;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMenuService {

	String HTTPS_GET_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @return
	 * @throws RuntimeException
	 */
	Menu getMenu(String accessToken, String agentId) throws RuntimeException;

}
