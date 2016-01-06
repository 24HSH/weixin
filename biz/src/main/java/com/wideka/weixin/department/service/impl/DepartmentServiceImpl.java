package com.wideka.weixin.department.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.department.IDepartmentService;
import com.wideka.weixin.api.department.bo.Department;
import com.wideka.weixin.api.department.bo.DepartmentObject;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class DepartmentServiceImpl implements IDepartmentService {

	private static Logger logger = Logger.getLogger(DepartmentServiceImpl.class);

	@Override
	public Department createDepartment(String accessToken, Department department) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (department == null) {
			throw new RuntimeException("department cannot be null.");
		}

		Department result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IDepartmentService.HTTPS_CREATE_URL + accessToken.trim(),
						JSON.toJSONString(department)), Department.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(department), e);

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
	public Result updateDepartment(String accessToken, Department department) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (department == null) {
			throw new RuntimeException("department cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IDepartmentService.HTTPS_UPDATE_URL + accessToken.trim(),
						JSON.toJSONString(department)), Result.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(department), e);

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
	public Result deleteDepartment(String accessToken, String id) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id cannot be null.");
		}

		Result result = null;

		try {
			result =
				JSON.parseObject(HttpUtil.get(IDepartmentService.HTTPS_DELETE_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$ID$", id.trim())), Result.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + id, e);

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
	public DepartmentObject getDepartmentList(String accessToken, String id) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id cannot be null.");
		}

		DepartmentObject result = null;

		try {
			result =
				JSON.parseObject(HttpUtil.get(IDepartmentService.HTTPS_LIST_URL.replace("$ACCESS_TOKEN$",
					accessToken.trim()).replace("$ID$", id.trim())), DepartmentObject.class);
		} catch (Exception e) {
			logger.error(accessToken + "&" + id, e);

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
