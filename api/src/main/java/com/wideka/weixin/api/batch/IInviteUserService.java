package com.wideka.weixin.api.batch;

import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.Job;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IInviteUserService {

	String HTTPS_INVITE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/batch/inviteuser?access_token=";

	/**
	 * 
	 * @param accessToken
	 *            企业的access_token.
	 * @param toUser
	 *            成员ID列表，多个接收者用‘|’分隔，最多支持1000个。.
	 * @param toParty
	 *            部门ID列表，多个接收者用‘|’分隔，最多支持100个。.
	 * @param toTag
	 *            标签ID列表，多个接收者用‘|’分隔。.
	 * @param callback
	 *            回调信息。如填写该项则任务完成后，通过callback推送事件给企业。具体请参考应用回调模式中的相应选项.
	 * @return
	 * @throws RuntimeException
	 */
	Job inviteUser(String accessToken, String toUser, String toParty, String toTag, Callback callback)
		throws RuntimeException;

}
