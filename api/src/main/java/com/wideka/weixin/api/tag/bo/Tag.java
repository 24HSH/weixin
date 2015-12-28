package com.wideka.weixin.api.tag.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Tag extends Result {

	private static final long serialVersionUID = 1903306699405752832L;

	/**
	 * 标签名称，长度为1~64个字节，标签名不可与其他标签重名。.
	 */
	@JSONField(name = "tagname")
	private String tagName;

	/**
	 * 标签id，整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。.
	 */
	@JSONField(name = "tagid")
	private int tagId;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

}
