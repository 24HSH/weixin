package com.wideka.weixin.api.suite;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ICallbackService {

	String HTTPS_CALLBACK_IP_URL = "https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=";

	/**
	 * 
	 * @param token
	 * @param encodingAesKey
	 * @param corpId
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 * @throws RuntimeException
	 */
	String verify(String token, String encodingAesKey, String corpId, String signature, String timestamp, String nonce,
		String echostr) throws RuntimeException;

	/**
	 * 
	 * @param token
	 * @param encodingAesKey
	 * @param corpId
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param data
	 * @return
	 * @throws RuntimeException
	 */
	String callback(String token, String encodingAesKey, String corpId, String signature, String timestamp,
		String nonce, String data) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 *            调用接口凭证.
	 * @return
	 * @throws RuntimeException
	 */
	String[] getCallbackIP(String accessToken) throws RuntimeException;

}
