package com.wideka.weixin.api.material.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Parameter implements Serializable {

	private static final long serialVersionUID = -8729567237858807739L;

	/**
	 * 素材类型，可以为图文(mpnews)、图片（image）、音频（voice）、视频（video）、文件（file）.
	 */
	@JSONField(name = "type")
	private String type;

	/**
	 * 企业应用的id，整型。可在应用的设置页面查看.
	 */
	@JSONField(name = "agentid")
	private int agentId;

	/**
	 * 从该类型素材的该偏移位置开始返回，0表示从第一个素材 返回.
	 */
	@JSONField(name = "offset")
	private int offset;

	/**
	 * 返回素材的数量，取值在1到50之间.
	 */
	@JSONField(name = "count")
	private int count;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
