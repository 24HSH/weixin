package com.wideka.weixin.api.menu.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Menu extends Result {

	private static final long serialVersionUID = 5248355303376072657L;

	/**
	 * 一级菜单数组，个数应为1~3个.
	 */
	@JSONField(name = "button")
	private List<Button> buttonList;

	public List<Button> getButtonList() {
		return buttonList;
	}

	public void setButtonList(List<Button> buttonList) {
		this.buttonList = buttonList;
	}

}
