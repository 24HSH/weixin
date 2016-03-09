package com.wideka.weixin.api.pay;

import com.wideka.weixin.api.pay.bo.Refund;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IRefundService {

	String HTTPS_REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	/**
	 * 申请退款.
	 * 
	 * @param refund
	 * @param key
	 * @param sslPath
	 * @return
	 * @throws RuntimeException
	 */
	Refund refund(Refund refund, String key, String sslPath) throws RuntimeException;

}
