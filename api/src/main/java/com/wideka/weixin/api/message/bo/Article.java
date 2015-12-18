package com.wideka.weixin.api.message.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Article implements Serializable {

	private static final long serialVersionUID = -4200095293164497228L;

	/**
	 * 标题.
	 */
	@JSONField(name = "title")
	private String title;

	// >>>>>>>>>>以下是 news 属性<<<<<<<<<<

	/**
	 * 描述.
	 */
	@JSONField(name = "description")
	private String description;

	/**
	 * 点击后跳转的链接.
	 */
	@JSONField(name = "url")
	private String url;

	/**
	 * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。如不填，在客户端不显示图片.
	 */
	@JSONField(name = "picurl")
	private String picUrl;

	// >>>>>>>>>>以下是 mpnews 属性<<<<<<<<<<

	/**
	 * 图文消息缩略图的media_id, 可以在上传多媒体文件接口中获得。此处thumb_media_id即上传接口返回的media_id.
	 */
	@JSONField(name = "thumb_media_id")
	private String thumbMediaId;

	/**
	 * 图文消息的作者.
	 */
	@JSONField(name = "author")
	private String author;

	/**
	 * 图文消息点击“阅读原文”之后的页面链接.
	 */
	@JSONField(name = "content_source_url")
	private String contentSourceUrl;

	/**
	 * 图文消息的内容，支持html标签.
	 */
	@JSONField(name = "content")
	private String content;

	/**
	 * 图文消息的描述.
	 */
	@JSONField(name = "digest")
	private String digest;

	/**
	 * 是否显示封面，1为显示，0为不显示.
	 */
	@JSONField(name = "show_cover_pic")
	private String show_cover_pic;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getShow_cover_pic() {
		return show_cover_pic;
	}

	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

}
