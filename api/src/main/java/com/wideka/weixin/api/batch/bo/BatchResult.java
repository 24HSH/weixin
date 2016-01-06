package com.wideka.weixin.api.batch.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class BatchResult extends Result {

	private static final long serialVersionUID = 4412378098198627952L;

	/**
	 * 成员UserID。对应管理端的帐号.
	 */
	@JSONField(name = "userid")
	private String userId;

	/**
	 * 邀请类型：0 没有邀请方式或未邀请 1 微信邀请 2 邮件邀请.
	 */
	@JSONField(name = "invitetype")
	private int inviteType;

	/**
	 * A. 操作类型（按位或）：1 表示修改，2 表示新增
	 * B. 操作类型（按位或）：1 新建部门 ，2 更改部门名称， 4 移动部门， 8 修改部门排序.
	 */
	@JSONField(name = "action")
	private int action;

	/**
	 * 部门ID.
	 */
	@JSONField(name = "partyid")
	private int partyId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getInviteType() {
		return inviteType;
	}

	public void setInviteType(int inviteType) {
		this.inviteType = inviteType;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

}
