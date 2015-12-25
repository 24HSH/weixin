package com.wideka.weixin.api.material.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MaterialCount extends Result {

	private static final long serialVersionUID = 5812337932613718044L;

	/**
	 * 应用素材总数目.
	 */
	@JSONField(name = "total_count")
	private int totalCount;

	/**
	 * 图片素材总数目.
	 */
	@JSONField(name = "image_count")
	private int imageCount;

	/**
	 * 音频素材总数目.
	 */
	@JSONField(name = "voice_count")
	private int voiceCount;

	/**
	 * 视频素材总数目.
	 */
	@JSONField(name = "video_count")
	private int videoCount;

	/**
	 * 文件素材总数目.
	 */
	@JSONField(name = "file_count")
	private int fileCount;

	/**
	 * 图文素材总数目.
	 */
	@JSONField(name = "mpnews_count")
	private int mpewsCount;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}

	public int getVoiceCount() {
		return voiceCount;
	}

	public void setVoiceCount(int voiceCount) {
		this.voiceCount = voiceCount;
	}

	public int getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}

	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public int getMpewsCount() {
		return mpewsCount;
	}

	public void setMpewsCount(int mpewsCount) {
		this.mpewsCount = mpewsCount;
	}

}
