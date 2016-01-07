package com.wideka.weixin.api.menu;

import com.wideka.weixin.api.menu.bo.Menu;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMenuService {

	String HTTPS_CREATE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

	String HTTPS_DELETE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

	String HTTPS_GET_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=$ACCESS_TOKEN$&agentid=$AGENTID$";

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @param menu
	 * @return
	 * @throws RuntimeException
	 */
	Result createMenu(String accessToken, String agentId, Menu menu) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @return
	 * @throws RuntimeException
	 */
	Result deleteMenu(String accessToken, String agentId) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param agentId
	 * @return
	 * @throws RuntimeException
	 */
	Menu getMenu(String accessToken, String agentId) throws RuntimeException;

}
