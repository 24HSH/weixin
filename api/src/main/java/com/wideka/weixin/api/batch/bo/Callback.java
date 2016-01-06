package com.wideka.weixin.api.batch.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Callback implements Serializable {

	private static final long serialVersionUID = 4085872541372604155L;

	/**
	 * 企业应用接收企业号推送请求的访问协议和地址，支持http或https协议.
	 */
	@JSONField(name = "url")
	private String url;

	/**
	 * 用于生成签名.
	 */
	@JSONField(name = "token")
	private String token;

	/**
	 * 用于消息体的加密，是AES密钥的Base64编码.
	 */
	@JSONField(name = "encodingaeskey")
	private String encodingAesKey;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

}
