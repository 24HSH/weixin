package com.wideka.weixin.api.suite;

public interface ICallbackService {

	String receive(String signature, String timestamp, String nonce);

}
