package com.wideka.weixin.api.callback.bo;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.VisitorSupport;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Content extends VisitorSupport {

	private Long id;

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
	private int createTime;

	/**
	 * 消息类型.
	 */
	private String msgType;

	/**
	 * 消息id，64位整型.
	 */
	private long msgId;

	/**
	 * 企业应用的id，整型。可在应用的设置页面查看.
	 */
	private int agentId;

	// >>>>>>>>>>以下是 接收普通消息 属性<<<<<<<<<<

	/**
	 * text消息.
	 */
	private String content;

	/**
	 * image消息: 图片链接.
	 */
	private String picUrl;

	/**
	 * 1. image消息: 图片媒体文件id，可以调用获取媒体文件接口拉取数据
	 * 2. voice消息: 语音媒体文件id，可以调用获取媒体文件接口拉取数据
	 * 3. video消息: 视频媒体文件id，可以调用获取媒体文件接口拉取数据
	 * 4. 小视频消息: 视频媒体文件id，可以调用获取媒体文件接口拉取数据.
	 */
	private String mediaId;

	/**
	 * voice消息: 语音格式，如amr，speex等.
	 */
	private String format;

	/**
	 * 1. video消息: 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据
	 * 2. 小视频消息: 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据.
	 */
	private String thumbMediaId;

	/**
	 * 1. location消息: 地理位置纬度
	 * 2. 弹出地理位置选择器的事件推送: X坐标信息.
	 */
	private String locationX;

	/**
	 * 1. location消息: 地理位置经度
	 * 2. 弹出地理位置选择器的事件推送: Y坐标信息.
	 */
	private String locationY;

	/**
	 * 1. location消息: 地图缩放大小
	 * 2. 弹出地理位置选择器的事件推送: 精度，可理解为精度或者比例尺、越精细的话 scale越高.
	 */
	private String scale;

	/**
	 * 1. location消息: 地理位置信息
	 * 2. 弹出地理位置选择器的事件推送: 地理位置的字符串信息.
	 */
	private String label;

	// >>>>>>>>>>以下是 接收事件 属性<<<<<<<<<<

	/**
	 * 1. 成员关注/取消关注事件: 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	 * 2. 上报地理位置事件: 事件类型，此时固定为：LOCATION
	 * 3. 上报菜单事件: 事件类型，CLICK
	 * 4. 点击菜单跳转链接的事件推送: 事件类型，VIEW
	 * 5. 扫码推事件的事件推送: 事件类型，scancode_push
	 * 6. 扫码推事件且弹出“消息接收中”提示框的事件推送: 事件类型，scancode_waitmsg
	 * 7. 弹出系统拍照发图的事件推送: 事件类型，pic_sysphoto
	 * 8. 弹出拍照或者相册发图的事件推送: 事件类型，pic_photo_or_album
	 * 9. 弹出微信相册发图器的事件推送: 事件类型，pic_weixin
	 * 10.弹出地理位置选择器的事件推送: 事件类型，location_select
	 * 11.成员进入应用的事件推送: 事件类型，enter_agent
	 * 12.异步任务完成事件推送: 事件的类型，此时固定为batch_job_result.
	 */
	private String event;

	/**
	 * 上报地理位置事件: 地理位置纬度.
	 */
	private String latitude;

	/**
	 * 上报地理位置事件: 地理位置经度.
	 */
	private String longitude;

	/**
	 * 上报地理位置事件: 地理位置精度.
	 */
	private String precision;

	/**
	 * 1. 上报菜单事件: 事件KEY值，与自定义菜单接口中KEY值对应
	 * 2. 点击菜单跳转链接的事件推送: 事件KEY值，设置的跳转URL
	 * 3. 扫码推事件的事件推送: 事件KEY值，由开发者在创建菜单时设定
	 * 4. 扫码推事件且弹出“消息接收中”提示框的事件推送: 事件KEY值，由开发者在创建菜单时设定
	 * 5. 弹出系统拍照发图的事件推送: 事件KEY值，由开发者在创建菜单时设定
	 * 6. 弹出拍照或者相册发图的事件推送: 事件KEY值，由开发者在创建菜单时设定
	 * 7. 弹出微信相册发图器的事件推送: 事件KEY值，由开发者在创建菜单时设定
	 * 8. 弹出地理位置选择器的事件推送: 事件KEY值，由开发者在创建菜单时设定
	 * 9. 成员进入应用的事件推送: 事件KEY值，此事件该值为空.
	 */
	private String eventKey;

	/**
	 * 1. 扫码推事件的事件推送: 扫描类型，一般是qrcode
	 * 2. 扫码推事件且弹出“消息接收中”提示框的事件推送: 扫描类型，一般是qrcode.
	 */
	private String scanType;

	/**
	 * 1. 扫码推事件的事件推送: 扫描结果，即二维码对应的字符串信息
	 * 2. 扫码推事件且弹出“消息接收中”提示框的事件推送: 扫描结果，即二维码对应的字符串信息.
	 */
	private String scanResult;

	/**
	 * 1. 弹出系统拍照发图的事件推送: 发送的图片数量
	 * 2. 弹出拍照或者相册发图的事件推送: 发送的图片数量
	 * 3. 弹出微信相册发图器的事件推送: 发送的图片数量.
	 */
	private String count;

	/**
	 * 1. 弹出系统拍照发图的事件推送: 图片的MD5值，开发者若需要，可用于验证接收到图片
	 * 2. 弹出拍照或者相册发图的事件推送: 图片的MD5值，开发者若需要，可用于验证接收到图片
	 * 3. 弹出微信相册发图器的事件推送: 图片的MD5值，开发者若需要，可用于验证接收到图片.
	 */
	private List<String> picMd5Sum = new ArrayList<String>();

	/**
	 * 弹出地理位置选择器的事件推送: 朋友圈POI的名字，可能为空.
	 */
	private String poiName;

	/**
	 * 异步任务完成事件推送: 异步任务id，最大长度为64字符.
	 */
	private String jobId;

	/**
	 * 异步任务完成事件推送: 操作类型，字符串，目前分别有：
	 * 1. sync_user(增量更新成员)
	 * 2. replace_user(全量覆盖成员)
	 * 3. invite_user(邀请成员关注)
	 * 4. replace_party(全量覆盖部门).
	 */
	private String jobType;

	/**
	 * 异步任务完成事件推送: 返回码.
	 */
	private String errCode;

	/**
	 * 异步任务完成事件推送: 对返回码的文本描述内容.
	 */
	private String errMsg;

	public void visit(Element node) {
		String name = node.getName();
		String text = node.getText();

		if ("ToUserName".equals(name)) {
			toUserName = text;
		} else if ("FromUserName".equals(name)) {
			fromUserName = text;
		} else if ("CreateTime".equals(name)) {
			createTime = Integer.parseInt(text);
		} else if ("MsgType".equals(name)) {
			msgType = text;
		} else if ("MsgId".equals(name)) {
			msgId = Long.parseLong(text);
		} else if ("AgentID".equals(name)) {
			agentId = Integer.parseInt(text);
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
		} else if ("Event".equals(name)) {
			event = text;
		} else if ("Latitude".equals(name)) {
			latitude = text;
		} else if ("Longitude".equals(name)) {
			longitude = text;
		} else if ("Precision".equals(name)) {
			precision = text;
		} else if ("EventKey".equals(name)) {
			eventKey = text;
		} else if ("ScanType".equals(name)) {
			scanType = text;
		} else if ("ScanResult".equals(name)) {
			scanResult = text;
		} else if ("Count".equals(name)) {
			count = text;
		} else if ("PicMd5Sum".equals(name)) {
			picMd5Sum.add(text);
		} else if ("Poiname".equals(name)) {
			poiName = text;
		} else if ("JobId".equals(name)) {
			jobId = text;
		} else if ("JobType".equals(name)) {
			jobType = text;
		} else if ("ErrCode".equals(name)) {
			errCode = text;
		} else if ("ErrMsg".equals(name)) {
			errMsg = text;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getScanResult() {
		return scanResult;
	}

	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<String> getPicMd5Sum() {
		return picMd5Sum;
	}

	public void setPicMd5Sum(List<String> picMd5Sum) {
		this.picMd5Sum = picMd5Sum;
	}

	public String getPoiName() {
		return poiName;
	}

	public void setPoiName(String poiName) {
		this.poiName = poiName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
