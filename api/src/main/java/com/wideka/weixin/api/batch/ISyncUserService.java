package com.wideka.weixin.api.batch;

import com.wideka.weixin.api.batch.bo.Callback;
import com.wideka.weixin.api.batch.bo.Job;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ISyncUserService {

	String HTTPS_SYNC_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/batch/syncuser?access_token=";

	/**
	 * 
	 * @param accessToken
	 * @param mediaId
	 *            上传的csv文件的media_id.
	 * @param callback
	 * @return
	 * @throws RuntimeException
	 */
	Job syncUser(String accessToken, String mediaId, Callback callback) throws RuntimeException;

}
