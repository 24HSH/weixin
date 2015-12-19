package com.wideka.weixin.api.suite;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ICallbackService {

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

}
