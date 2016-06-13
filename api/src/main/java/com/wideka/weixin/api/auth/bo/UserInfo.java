package com.wideka.weixin.api.auth.bo;

import java.util.Arrays;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserInfo extends Result {

	private static final long serialVersionUID = -2395735172156627067L;

	/**
	 * 用户的唯一标识.
	 */
	@JSONField(name = "openid")
	private String openId;

	/**
	 * 用户昵称.
	 */
	@JSONField(name = "nickname")
	private String nickName;

	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知.
	 */
	@JSONField(name = "sex")
	private String sex;

	/**
	 * 用户个人资料填写的省份.
	 */
	@JSONField(name = "province")
	private String province;

	/**
	 * 普通用户个人资料填写的城市.
	 */
	@JSONField(name = "city")
	private String city;

	/**
	 * 国家，如中国为CN.
	 */
	@JSONField(name = "country")
	private String country;

	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
	 * .
	 */
	@JSONField(name = "headimgurl")
	private String headImgUrl;

	/**
	 * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）.
	 */
	@JSONField(name = "privilege")
	private String[] privilege;

	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段.
	 */
	@JSONField(name = "unionid")
	private String unionId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String[] getPrivilege() {
		return privilege != null ? Arrays.copyOf(privilege, privilege.length) : null;
	}

	public void setPrivilege(String[] privilege) {
		if (privilege != null) {
			this.privilege = Arrays.copyOf(privilege, privilege.length);
		}
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

}
