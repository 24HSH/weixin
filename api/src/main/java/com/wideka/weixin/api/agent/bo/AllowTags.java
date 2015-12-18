package com.wideka.weixin.api.agent.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class AllowTags implements Serializable {

	private static final long serialVersionUID = 6214635229713129395L;

	@JSONField(name = "tagid")
	private int[] tagId;

	public int[] getTagId() {
		return tagId;
	}

	public void setTagId(int[] tagId) {
		this.tagId = tagId;
	}

}
