package com.wideka.weixin.menu.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.weixin.api.menu.IMenuService;
import com.wideka.weixin.api.menu.bo.Menu;
import com.wideka.weixin.api.menu.bo.MenuObject;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MenuServiceImpl implements IMenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

	@Override
	public Result createMenu(String accessToken, String agentId, Menu menu) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		if (menu == null) {
			throw new RuntimeException("menu cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(
						IMenuService.HTTPS_CREATE_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
							"$AGENTID$", agentId.trim()), JSON.toJSONString(menu)), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result;
	}

	@Override
	public Result deleteMenu(String accessToken, String agentId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(IMenuService.HTTPS_DELETE_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$AGENTID$", agentId.trim())), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result;
	}

	@Override
	public Menu getMenu(String accessToken, String agentId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(agentId)) {
			throw new RuntimeException("agentid cannot be null.");
		}

		MenuObject menuObject = null;

		try {
			menuObject =
				JSON.parseObject(
					HttpUtil.get(IMenuService.HTTPS_GET_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$AGENTID$", agentId.trim())), MenuObject.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + agentId, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (menuObject == null || menuObject.getMenu() == null) {
			throw new RuntimeException("menu is null.");
		}

		String errCode = menuObject.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(menuObject.getErrMsg());
		}

		return menuObject.getMenu();
	}

}
