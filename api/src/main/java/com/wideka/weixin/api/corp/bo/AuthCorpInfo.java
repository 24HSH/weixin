package com.wideka.weixin.api.corp.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AuthCorpInfo implements Serializable {

	private static final long serialVersionUID = 125749599836207935L;

	/**
	 * 授权方企业号id.
	 */
	@JSONField(name = "corpid")
	private String corpId;

	/**
	 * 授权方企业号名称.
	 */
	@JSONField(name = "corp_name")
	private String corpName;

	/**
	 * 授权方企业号类型，认证号：verified, 注册号：unverified，体验号：test.
	 */
	@JSONField(name = "corp_type")
	private String corpType;

	/**
	 * 授权方企业号圆形头像.
	 */
	@JSONField(name = "corp_round_logo_url")
	private String corpRoundLogoUrl;

	/**
	 * 授权方企业号方形头像.
	 */
	@JSONField(name = "corp_square_logo_url")
	private String corpSquareLogoUrl;

	/**
	 * 授权方企业号用户规模.
	 */
	@JSONField(name = "corp_user_max")
	private int corpUserMax;

	/**
	 * 授权方企业号应用规模.
	 */
	@JSONField(name = "corp_agent_max")
	private int corpAgentMax;

	/**
	 * 授权方企业号二维码.
	 */
	@JSONField(name = "corp_wxqrcode")
	private String corpWxqrcode;

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpType() {
		return corpType;
	}

	public void setCorpType(String corpType) {
		this.corpType = corpType;
	}

	public String getCorpRoundLogoUrl() {
		return corpRoundLogoUrl;
	}

	public void setCorpRoundLogoUrl(String corpRoundLogoUrl) {
		this.corpRoundLogoUrl = corpRoundLogoUrl;
	}

	public String getCorpSquareLogoUrl() {
		return corpSquareLogoUrl;
	}

	public void setCorpSquareLogoUrl(String corpSquareLogoUrl) {
		this.corpSquareLogoUrl = corpSquareLogoUrl;
	}

	public int getCorpUserMax() {
		return corpUserMax;
	}

	public void setCorpUserMax(int corpUserMax) {
		this.corpUserMax = corpUserMax;
	}

	public int getCorpAgentMax() {
		return corpAgentMax;
	}

	public void setCorpAgentMax(int corpAgentMax) {
		this.corpAgentMax = corpAgentMax;
	}

	public String getCorpWxqrcode() {
		return corpWxqrcode;
	}

	public void setCorpWxqrcode(String corpWxqrcode) {
		this.corpWxqrcode = corpWxqrcode;
	}

}
