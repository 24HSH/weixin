package com.wideka.weixin.api.pay;

import com.wideka.weixin.api.pay.bo.UnifiedOrder;

/**
 * 统一下单.
 * 
 * @author JiakunXu
 * 
 */
public interface IUnifiedOrderService {

	String HTTPS_UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 
	 * @param unifiedOrder
	 * @param key
	 * @return
	 * @throws RuntimeException
	 */
	String unifiedOrder(UnifiedOrder unifiedOrder, String key) throws RuntimeException;

}
