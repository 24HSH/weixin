package com.wideka.weixin.api.message.bo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MPNews implements Serializable {

	private static final long serialVersionUID = 7061489935805032955L;

	@JSONField(name = "media_id")
	private String mediaId;

	@JSONField(name = "articles")
	private List<Article> articleList;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

}
