package com.wideka.weixin.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.user.IUserService;
import com.wideka.weixin.api.user.bo.User;
import com.wideka.weixin.api.user.bo.UserInfo;
import com.wideka.weixin.api.user.bo.UserObject;
import com.wideka.weixin.api.user.bo.UserResult;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserServiceImpl implements IUserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public UserInfo getUserInfo(String accessToken, String code) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(code)) {
			throw new RuntimeException("code cannot be null.");
		}

		UserInfo user = null;

		try {
			user =
				JSON.parseObject(HttpUtil.get(IUserService.HTTPS_GET_USER_INFO_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$CODE$", code.trim())), UserInfo.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + code, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (user == null) {
			throw new RuntimeException("user is null.");
		}

		String errCode = user.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(user.getErrMsg());
		}

		return user;
	}

	@Override
	public Result authSucc(String accessToken, String userId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(userId)) {
			throw new RuntimeException("userid cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(HttpUtil.get(IUserService.HTTPS_AUTH_SUCC_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$USERID$", userId.trim())), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + userId, e);

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
	public Result createUser(String accessToken, User user) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (user == null) {
			throw new RuntimeException("user cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IUserService.HTTPS_CREATE_URL + accessToken.trim(), JSON.toJSONString(user)),
					Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(user), e);

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
	public Result updateUser(String accessToken, User user) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (user == null) {
			throw new RuntimeException("user cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IUserService.HTTPS_UPDATE_URL + accessToken.trim(), JSON.toJSONString(user)),
					Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(user), e);

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
	public Result deleteUser(String accessToken, String userId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(userId)) {
			throw new RuntimeException("userid cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(IUserService.HTTPS_DELETE_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$USERID$", userId.trim())), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + userId, e);

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
	public Result batchDeleteUser(String accessToken, String[] userIdList) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (userIdList == null || userIdList.length == 0) {
			throw new RuntimeException("userIdList cannot be null.");
		}

		UserObject userObject = new UserObject();
		userObject.setUserIdList(userIdList);

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IUserService.HTTPS_BATCH_DELETE_URL + accessToken.trim(),
						JSON.toJSONString(userObject)), Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(userObject), e);

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
	public User getUser(String accessToken, String userId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(userId)) {
			throw new RuntimeException("userid cannot be null.");
		}

		User result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(IUserService.HTTPS_GET_URL.replace("$ACCESS_TOKEN$", accessToken.trim()).replace(
						"$USERID$", userId.trim())), User.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + userId, e);

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
	public List<User> getSimpleUserList(String accessToken, String departmentId, String fetchChild, String status)
		throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(departmentId)) {
			throw new RuntimeException("department_id cannot be null.");
		}

		if (StringUtils.isBlank(fetchChild)) {
			throw new RuntimeException("fetch_child cannot be null.");
		}

		if (StringUtils.isBlank(status)) {
			throw new RuntimeException("status cannot be null.");
		}

		UserResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(IUserService.HTTPS_SIMPLE_LIST_URL.replace("$ACCESS_TOKEN$", accessToken.trim())
						.replace("$DEPARTMENT_ID$", departmentId.trim()).replace("$FETCH_CHILD$", fetchChild.trim())
						.replace("$STATUS$", status.trim())), UserResult.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + departmentId + "&" + fetchChild + "&" + status, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result.getUserList();
	}

	@Override
	public List<User> getUserList(String accessToken, String departmentId, String fetchChild, String status)
		throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(departmentId)) {
			throw new RuntimeException("department_id cannot be null.");
		}

		if (StringUtils.isBlank(fetchChild)) {
			throw new RuntimeException("fetch_child cannot be null.");
		}

		if (StringUtils.isBlank(status)) {
			throw new RuntimeException("status cannot be null.");
		}

		UserResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.get(IUserService.HTTPS_LIST_URL.replace("$ACCESS_TOKEN$", accessToken.trim())
						.replace("$DEPARTMENT_ID$", departmentId.trim()).replace("$FETCH_CHILD$", fetchChild.trim())
						.replace("$STATUS$", status.trim())), UserResult.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + departmentId + "&" + fetchChild + "&" + status, e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result.getUserList();
	}

	@Override
	public UserResult inviteUser(String accessToken, String userId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(userId)) {
			throw new RuntimeException("userid cannot be null.");
		}

		User user = new User();
		user.setUserId(userId.trim());

		UserResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IUserService.HTTPS_INVITE_URL + accessToken.trim(), JSON.toJSONString(user)),
					UserResult.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + userId, e);

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
	public User convertToOpenId(String accessToken, String userId, int agentId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(userId)) {
			throw new RuntimeException("userid cannot be null.");
		}

		User user = new User();
		user.setUserId(userId.trim());
		user.setAgentId(agentId);

		User result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IUserService.HTTPS_CONVERT_TO_OPEN_ID_URL + accessToken.trim(),
						JSON.toJSONString(user)), User.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + userId, e);

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
	public User convertToUserId(String accessToken, String openId) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(openId)) {
			throw new RuntimeException("openid cannot be null.");
		}

		User user = new User();
		user.setOpenId(openId.trim());

		User result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IUserService.HTTPS_CONVERT_TO_USER_ID_URL + accessToken.trim(),
						JSON.toJSONString(user)), User.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + openId, e);

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

}
