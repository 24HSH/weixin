package com.wideka.weixin.api.material.bo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.api.message.bo.Article;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Material implements Serializable {

	private static final long serialVersionUID = -2238073644703099551L;

	/**
	 * 图文素材的媒体id.
	 */
	@JSONField(name = "media_id")
	private String mediaId;

	@JSONField(name = "filename")
	private String fileName;

	@JSONField(name = "update_time")
	private int updateTime;

	/**
	 * 图文消息，一个图文消息支持1到10个图文.
	 */
	@JSONField(name = "articles")
	private List<Article> articleList;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

}
