package com.wideka.weixin.api.batch.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Job extends Result {

	private static final long serialVersionUID = -6716763274175612362L;

	/**
	 * 异步任务id，最大长度为64字节.
	 */
	@JSONField(name = "jobid")
	private String jobId;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
