package com.wideka.weixin.api.message.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 733672350056046345L;

	@JSONField(name = "touser")
	private String toUser;

	@JSONField(name = "toparty")
	private String toParty;

	@JSONField(name = "totag")
	private String toTag;

	@JSONField(name = "msgtype")
	private String msgType;

	@JSONField(name = "agentid")
	private int agentId;

	@JSONField(name = "text")
	private Text text;

	@JSONField(name = "image")
	private Image image;

	@JSONField(name = "voice")
	private Voice voice;

	@JSONField(name = "video")
	private Video video;

	@JSONField(name = "file")
	private File file;

	@JSONField(name = "news")
	private News news;

	@JSONField(name = "mpnews")
	private MPNews mpNews;

	@JSONField(name = "safe")
	private String safe;

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToParty() {
		return toParty;
	}

	public void setToParty(String toParty) {
		this.toParty = toParty;
	}

	public String getToTag() {
		return toTag;
	}

	public void setToTag(String toTag) {
		this.toTag = toTag;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public MPNews getMpNews() {
		return mpNews;
	}

	public void setMpNews(MPNews mpNews) {
		this.mpNews = mpNews;
	}

	public String getSafe() {
		return safe;
	}

	public void setSafe(String safe) {
		this.safe = safe;
	}

}
