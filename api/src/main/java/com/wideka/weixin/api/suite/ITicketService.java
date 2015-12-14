package com.wideka.weixin.api.suite;

public interface ITicketService {

	String receive(String signature, String timestamp, String nonce);

}
