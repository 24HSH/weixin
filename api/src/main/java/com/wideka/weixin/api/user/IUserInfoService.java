package com.wideka.weixin.api.user;

import com.wideka.weixin.api.user.bo.User;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IUserInfoService {

	String HTTPS_USER_INFO_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=$ACCESS_TOKEN$&code=$CODE$";

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

}
