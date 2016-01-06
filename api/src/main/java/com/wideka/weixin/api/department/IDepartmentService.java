package com.wideka.weixin.api.department;

import com.wideka.weixin.api.department.bo.Department;
import com.wideka.weixin.api.department.bo.DepartmentObject;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IDepartmentService {

	String HTTPS_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=";

	String HTTPS_UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=";

	String HTTPS_DELETE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=$ACCESS_TOKEN$&id=$ID$";

	String HTTPS_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=$ACCESS_TOKEN$&id=$ID$";

	/**
	 * 创建部门.
	 * 
	 * @param accessToken
	 * @param department
	 * @return
	 * @throws RuntimeException
	 */
	Department createDepartment(String accessToken, Department department) throws RuntimeException;

	/**
	 * 更新部门.
	 * 
	 * @param accessToken
	 * @param department
	 * @return
	 * @throws RuntimeException
	 */
	Result updateDepartment(String accessToken, Department department) throws RuntimeException;

	/**
	 * 删除部门.
	 * 
	 * @param accessToken
	 * @param id
	 *            部门id。（注：不能删除根部门；不能删除含有子部门、成员的部门）.
	 * @return
	 * @throws RuntimeException
	 */
	Result deleteDepartment(String accessToken, String id) throws RuntimeException;

	/**
	 * 获取部门列表.
	 * 
	 * @param accessToken
	 * @param id
	 *            部门id。获取指定部门及其下的子部门.
	 * @return
	 * @throws RuntimeException
	 */
	DepartmentObject getDepartmentList(String accessToken, String id) throws RuntimeException;

}
