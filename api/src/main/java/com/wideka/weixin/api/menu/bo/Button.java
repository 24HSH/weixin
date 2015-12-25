package com.wideka.weixin.api.menu.bo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Button implements Serializable {

	private static final long serialVersionUID = -6521524656116169591L;

	/**
	 * 菜单的响应动作类型.
	 */
	private String type;

	/**
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节.
	 */
	private String name;

	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节.
	 */
	private String key;

	/**
	 * 网页链接，成员点击菜单可打开链接，不超过256字节.
	 */
	private String url;

	/**
	 * 二级菜单数组，个数应为1~5个.
	 */
	@JSONField(name = "sub_button")
	private List<Button> buttonList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Button> getButtonList() {
		return buttonList;
	}

	public void setButtonList(List<Button> buttonList) {
		this.buttonList = buttonList;
	}

}
