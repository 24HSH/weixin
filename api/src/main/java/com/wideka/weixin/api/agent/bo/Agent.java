package com.wideka.weixin.api.agent.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Err;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Agent extends Err {

	private static final long serialVersionUID = 5689861487465980259L;

	/**
	 * 授权方应用id.
	 */
	@JSONField(name = "agentid")
	private int agentId;

	/**
	 * 授权方应用名字.
	 */
	@JSONField(name = "name")
	private String name;

	/**
	 * 授权方应用圆形头像.
	 */
	@JSONField(name = "round_logo_url")
	private String roundLogoUrl;

	/**
	 * 授权方应用方形头像.
	 */
	@JSONField(name = "square_logo_url")
	private String squareLogoUrl;

	/**
	 * 服务商套件中的对应应用id.
	 */
	@JSONField(name = "app_id")
	private int appId;

	/**
	 * 授权方应用敏感权限组，目前仅有get_location，表示是否有权限设置应用获取地理位置的开关.
	 */
	@JSONField(name = "api_group")
	private String[] apiGroup;

	/**
	 * 授权方企业应用详情.
	 */
	@JSONField(name = "description")
	private String description;

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoundLogoUrl() {
		return roundLogoUrl;
	}

	public void setRoundLogoUrl(String roundLogoUrl) {
		this.roundLogoUrl = roundLogoUrl;
	}

	public String getSquareLogoUrl() {
		return squareLogoUrl;
	}

	public void setSquareLogoUrl(String squareLogoUrl) {
		this.squareLogoUrl = squareLogoUrl;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String[] getApiGroup() {
		return apiGroup;
	}

	public void setApiGroup(String[] apiGroup) {
		this.apiGroup = apiGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
