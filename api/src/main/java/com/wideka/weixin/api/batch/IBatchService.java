package com.wideka.weixin.api.batch;

import com.wideka.weixin.api.batch.bo.Batch;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IBatchService {

	String HTTPS_GET_RESULT_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/batch/getresult?access_token=$ACCESS_TOKEN$&jobid=$JOBID$";

	/**
	 * 
	 * @param accessToken
	 * @param jobId
	 * @return
	 * @throws RuntimeException
	 */
	Batch getResult(String accessToken, String jobId) throws RuntimeException;

}
