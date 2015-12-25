package com.wideka.weixin.menu.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.weixin.api.menu.IMenuService;
import com.wideka.weixin.api.menu.bo.Menu;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MenuServiceImpl implements IMenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

	@Override
	public Menu getMenu(String accessToken, String agentId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		Menu menu = null;

		try {
			menu =
				JSON.parseObject(
					HttpUtil.get(IMenuService.HTTPS_GET_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$AGENTID$", agentId.trim())), Menu.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (menu == null) {
			throw new RuntimeException("menu is null.");
		}

		String errCode = menu.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(menu.getErrMsg());
		}

		return menu;
	}

}
