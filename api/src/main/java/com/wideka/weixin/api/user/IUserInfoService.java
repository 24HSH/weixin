package com.wideka.weixin.api.user;

import com.wideka.weixin.api.user.bo.User;
import com.wideka.weixin.api.user.bo.UserResult;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IUserInfoService {

	String HTTPS_USER_INFO_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=$ACCESS_TOKEN$&code=$CODE$";

	String HTTPS_AUTH_SUCC_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=$ACCESS_TOKEN$&userid=$USERID$";

	String HTTPS_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=";

	String HTTPS_UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=";

	String HTTPS_DELETE_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=$ACCESS_TOKEN$&userid=$USERID$";

	String HTTPS_BATCH_DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=";

	String HTTPS_GET_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=$ACCESS_TOKEN$&userid=$USERID$";

	String HTTPS_SIMPLE_LIST_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=$ACCESS_TOKEN$&department_id=$DEPARTMENT_ID$&fetch_child=$FETCH_CHILD$&status=$STATUS$";

	String HTTPS_LIST_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=$ACCESS_TOKEN$&department_id=$DEPARTMENT_ID$&fetch_child=$FETCH_CHILD$&status=$STATUS$";

	/**
	 * 
	 * @param accessToken
	 *            调用接口凭证.
	 * @param code
	 *            通过成员授权获取到的code，每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期.
	 * @return
	 * @throws RuntimeException
	 */
	User getUserInfo(String accessToken, String code) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param userId
	 * @return
	 * @throws RuntimeException
	 */
	Result authSucc(String accessToken, String userId) throws RuntimeException;

	/**
	 * 创建成员.
	 * 
	 * @param accessToken
	 * @param user
	 * @return
	 * @throws RuntimeException
	 */
	Result createUser(String accessToken, User user) throws RuntimeException;

	/**
	 * 更新成员.
	 * 
	 * @param accessToken
	 * @param user
	 * @return
	 * @throws RuntimeException
	 */
	Result updateUser(String accessToken, User user) throws RuntimeException;

	/**
	 * 删除成员.
	 * 
	 * @param accessToken
	 *            调用接口凭证.
	 * @param userId
	 *            成员UserID。对应管理端的帐号.
	 * @return
	 * @throws RuntimeException
	 */
	Result deleteUser(String accessToken, String userId) throws RuntimeException;

	/**
	 * 批量删除成员.
	 * 
	 * @param accessToken
	 * @param userIdList
	 * @return
	 * @throws RuntimeException
	 */
	Result batchDeleteUser(String accessToken, String[] userIdList) throws RuntimeException;

	/**
	 * 获取成员.
	 * 
	 * @param accessToken
	 * @param userId
	 * @return
	 * @throws RuntimeException
	 */
	User getUser(String accessToken, String userId) throws RuntimeException;

	/**
	 * 获取部门成员.
	 * 
	 * @param accessToken
	 * @param departmentId
	 * @param fetchChild
	 * @param status
	 * @return
	 */
	UserResult getSimpleUserList(String accessToken, String departmentId, String fetchChild, String status);

	/**
	 * 获取部门成员(详情).
	 * 
	 * @param accessToken
	 * @param departmentId
	 * @param fetchChild
	 * @param status
	 * @return
	 */
	UserResult getUserList(String accessToken, String departmentId, String fetchChild, String status);

}
