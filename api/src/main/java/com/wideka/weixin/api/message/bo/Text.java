package com.wideka.weixin.api.message.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Text implements Serializable {

	private static final long serialVersionUID = 552698313157925708L;

	/**
	 * 消息内容.
	 */
	@JSONField(name = "content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
