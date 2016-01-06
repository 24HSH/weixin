package com.wideka.weixin.api.batch.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class ReplaceUser implements Serializable {

	private static final long serialVersionUID = 2740473735423832096L;

	/**
	 * 上传的csv文件的media_id.
	 */
	@JSONField(name = "media_id")
	private String mediaId;

	@JSONField(name = "callback")
	private Callback callback;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public Callback getCallback() {
		return callback;
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

}
