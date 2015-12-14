package com.wideka.weixin.api.suite;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ICallbackService {

	/**
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	String receive(String signature, String timestamp, String nonce);

}
