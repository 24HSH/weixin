package com.wideka.weixin.api.menu.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MenuObject extends Result {

	private static final long serialVersionUID = -1199171625426745183L;

	@JSONField(name = "menu")
	private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
