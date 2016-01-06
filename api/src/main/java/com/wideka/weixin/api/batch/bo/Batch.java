package com.wideka.weixin.api.batch.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Batch extends Result {

	private static final long serialVersionUID = 4412378098198627952L;

	/**
	 * 任务状态，整型，1表示任务开始，2表示任务进行中，3表示任务已完成.
	 */
	@JSONField(name = "status")
	private int status;

	/**
	 * 操作类型，字节串，目前分别有：
	 * 1. sync_user(增量更新成员)
	 * 2. replace_user(全量覆盖成员)
	 * 3. invite_user(邀请成员关注)
	 * 4. replace_party(全量覆盖部门).
	 */
	@JSONField(name = "type")
	private String type;

	/**
	 * 任务运行总条数.
	 */
	@JSONField(name = "total")
	private int total;

	/**
	 * 目前运行百分比，当任务完成时为100.
	 */
	@JSONField(name = "percentage")
	private int percentage;

	/**
	 * 预估剩余时间（单位：分钟），当任务完成时为0.
	 */
	@JSONField(name = "remaintime")
	private int remainTime;

	/**
	 * 详细的处理结果，具体格式参考下面说明。当任务完成后此字段有效.
	 */
	@JSONField(name = "result")
	private List<BatchResult> batchResultList;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}

	public List<BatchResult> getBatchResultList() {
		return batchResultList;
	}

	public void setBatchResultList(List<BatchResult> batchResultList) {
		this.batchResultList = batchResultList;
	}

}
