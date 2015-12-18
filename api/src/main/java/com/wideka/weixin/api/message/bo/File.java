package com.wideka.weixin.api.message.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class File implements Serializable {

	private static final long serialVersionUID = -6934333491697745215L;

	/**
	 * 媒体文件id，可以调用上传临时素材或者永久素材接口获取.
	 */
	@JSONField(name = "media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
