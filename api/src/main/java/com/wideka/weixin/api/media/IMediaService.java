package com.wideka.weixin.api.media;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMediaService {

	String HTTPS_UPLOAD_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=$ACCESS_TOKEN$&type=$TYPE$";

	String HTTPS_GET_URL =
		"https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=$ACCESS_TOKEN$&media_id=$MEDIA_ID$";

}
