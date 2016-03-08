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
	 * 
	 * @param refund
	 * @param key
	 * @return
	 * @throws RuntimeException
	 */
	Refund refund(Refund refund, String key) throws RuntimeException;

}
