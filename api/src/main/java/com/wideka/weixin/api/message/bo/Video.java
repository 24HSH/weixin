package com.wideka.weixin.api.message.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Video implements Serializable {

	private static final long serialVersionUID = -6001711073891320714L;

	/**
	 * 视频媒体文件id，可以调用上传临时素材或者永久素材接口获取.
	 */
	@JSONField(name = "media_id")
	private String mediaId;

	/**
	 * 视频消息的标题.
	 */
	@JSONField(name = "title")
	private String title;

	/**
	 * 视频消息的描述.
	 */
	@JSONField(name = "description")
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
