package com.wideka.weixin.api.batch;

import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.Job;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IReplaceUserService {

	String HTTPS_REPLACE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceuser?access_token=";

	/**
	 * 
	 * @param accessToken
	 * @param mediaId
	 *            上传的csv文件的media_id.
	 * @param callback
	 * @return
	 * @throws RuntimeException
	 */
	Job replaceUser(String accessToken, String mediaId, Callback callback) throws RuntimeException;

}
