package com.wideka.weixin.batch.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.batch.IInviteUserService;
import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.InviteUser;
import com.wideka.weixin.api.batch.bo.Job;

/**
 * 
 * @author JiakunXu
 * 
 */
public class InviteUserServiceImpl implements IInviteUserService {

	private static Logger logger = Logger.getLogger(InviteUserServiceImpl.class);

	@Override
	public Job inviteUser(String accessToken, String toUser, String toParty, String toTag, Callback callback)
		throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		InviteUser inviteUser = new InviteUser();
		inviteUser.setToUser(StringUtils.trim(toUser));
		inviteUser.setToParty(StringUtils.trim(toParty));
		inviteUser.setToTag(StringUtils.trim(toTag));
		inviteUser.setCallback(callback);

		Job result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IInviteUserService.HTTPS_INVITE_USER_URL + accessToken.trim(),
						JSON.toJSONString(inviteUser)), Job.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(inviteUser), e);

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
