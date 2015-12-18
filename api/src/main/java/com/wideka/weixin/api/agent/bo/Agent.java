package com.wideka.weixin.api.agent.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Agent extends Result {

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

	// >>>>>>>>>>以下是基本属性<<<<<<<<<<

	/**
	 * 授权方企业应用详情.
	 */
	@JSONField(name = "description")
	private String description;

	/**
	 * 授权方企业应用可见范围（人员），其中包括userid和关注状态state.
	 */
	@JSONField(name = "allow_userinfos")
	private AllowUserInfos allowUserInfos;

	/**
	 * 授权方企业应用可见范围（部门）.
	 */
	@JSONField(name = "allow_partys")
	private AllowPartys allowPartys;

	/**
	 * 授权方企业应用可见范围（标签）.
	 */
	@JSONField(name = "allow_tags")
	private AllowTags allowTags;

	/**
	 * 授权方企业应用是否被禁用.
	 */
	@JSONField(name = "close")
	private int close;

	/**
	 * 授权方企业应用可信域名.
	 */
	@JSONField(name = "redirect_domain")
	private String redirectDomain;

	/**
	 * report_location_flag 授权方企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报.
	 */
	@JSONField(name = "report_location_flag")
	private int reportLocationFlag;

	/**
	 * 是否接收用户变更通知。0：不接收；1：接收.
	 */
	@JSONField(name = "isreportuser")
	private int isReportUser;

	/**
	 * 是否上报用户进入应用事件。0：不接收；1：接收.
	 */
	@JSONField(name = "isreportenter")
	private int isReportEnter;

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

	public AllowUserInfos getAllowUserInfos() {
		return allowUserInfos;
	}

	public void setAllowUserInfos(AllowUserInfos allowUserInfos) {
		this.allowUserInfos = allowUserInfos;
	}

	public AllowPartys getAllowPartys() {
		return allowPartys;
	}

	public void setAllowPartys(AllowPartys allowPartys) {
		this.allowPartys = allowPartys;
	}

	public AllowTags getAllowTags() {
		return allowTags;
	}

	public void setAllowTags(AllowTags allowTags) {
		this.allowTags = allowTags;
	}

	public int getClose() {
		return close;
	}

	public void setClose(int close) {
		this.close = close;
	}

	public String getRedirectDomain() {
		return redirectDomain;
	}

	public void setRedirectDomain(String redirectDomain) {
		this.redirectDomain = redirectDomain;
	}

	public int getReportLocationFlag() {
		return reportLocationFlag;
	}

	public void setReportLocationFlag(int reportLocationFlag) {
		this.reportLocationFlag = reportLocationFlag;
	}

	public int getIsReportUser() {
		return isReportUser;
	}

	public void setIsReportUser(int isReportUser) {
		this.isReportUser = isReportUser;
	}

	public int getIsReportEnter() {
		return isReportEnter;
	}

	public void setIsReportEnter(int isReportEnter) {
		this.isReportEnter = isReportEnter;
	}

}
