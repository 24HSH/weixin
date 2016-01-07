package com.wideka.weixin.api.material.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.message.bo.MPNews;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MaterialMPNews implements Serializable {

	private static final long serialVersionUID = 4900458198363750540L;

	@JSONField(name = "agentid")
	private int agentId;

	@JSONField(name = "media_id")
	private String mediaId;

	@JSONField(name = "mpnews")
	private MPNews mpNews;

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public MPNews getMpNews() {
		return mpNews;
	}

	public void setMpNews(MPNews mpNews) {
		this.mpNews = mpNews;
	}

}
