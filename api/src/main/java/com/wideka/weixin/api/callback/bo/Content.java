package com.wideka.weixin.api.callback.bo;

import org.dom4j.Element;
import org.dom4j.VisitorSupport;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Content extends VisitorSupport {

	/**
	 * 企业号CorpID.
	 */
	private String toUserName;

	/**
	 * 成员UserID.
	 */
	private String fromUserName;

	/**
	 * 消息创建时间（整型）.
	 */
	private String createTime;

	/**
	 * 消息类型.
	 */
	private String msgType;

	/**
	 * 消息id，64位整型.
	 */
	private String msgId;

	/**
	 * 企业应用的id，整型。可在应用的设置页面查看.
	 */
	private String agentId;

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	/**
	 * text消息.
	 */
	private String content;

	/**
	 * image消息: 图片链接.
	 */
	private String picUrl;

	/**
	 * image消息: 图片媒体文件id，可以调用获取媒体文件接口拉取数据/voice消息: 语音媒体文件id，可以调用获取媒体文件接口拉取数据/video消息:
	 * 视频媒体文件id，可以调用获取媒体文件接口拉取数据/小视频消息: 视频媒体文件id，可以调用获取媒体文件接口拉取数据.
	 */
	private String mediaId;

	/**
	 * voice消息: 语音格式，如amr，speex等.
	 */
	private String format;

	/**
	 * video消息: 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据/小视频消息: 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据.
	 */
	private String thumbMediaId;

	/**
	 * location消息: 地理位置纬度.
	 */
	private String locationX;

	/**
	 * location消息: 地理位置经度.
	 */
	private String locationY;

	/**
	 * location消息: 地图缩放大小.
	 */
	private String scale;

	/**
	 * location消息: 地理位置信息.
	 */
	private String label;

	public void visit(Element node) {
		String name = node.getName();
		String text = node.getText();

		if ("ToUserName".equals(name)) {
			toUserName = text;
		} else if ("FromUserName".equals(name)) {
			fromUserName = text;
		} else if ("CreateTime".equals(name)) {
			createTime = text;
		} else if ("MsgType".equals(name)) {
			msgType = text;
		} else if ("MsgId".equals(name)) {
			msgId = text;
		} else if ("AgentID".equals(name)) {
			agentId = text;
		} else if ("Content".equals(name)) {
			content = text;
		} else if ("PicUrl".equals(name)) {
			picUrl = text;
		} else if ("MediaId".equals(name)) {
			mediaId = text;
		} else if ("Format".equals(name)) {
			format = text;
		} else if ("ThumbMediaId".equals(name)) {
			thumbMediaId = text;
		} else if ("Location_X".equals(name)) {
			locationX = text;
		} else if ("Location_Y".equals(name)) {
			locationY = text;
		} else if ("Scale".equals(name)) {
			scale = text;
		} else if ("Label".equals(name)) {
			label = text;
		}
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
