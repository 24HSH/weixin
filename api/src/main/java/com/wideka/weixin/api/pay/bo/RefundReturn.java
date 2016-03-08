package com.wideka.weixin.api.pay.bo;

import org.dom4j.Element;

/**
 * 
 * @author JiakunXu
 * 
 */
public class RefundReturn extends Result {

	private Refund refund = new Refund();

	public void visit(Element node) {
		super.visit(node);

		String name = node.getName();
		String text = node.getText();

		if ("appid".equals(name)) {
			refund.setAppId(text);
		} else if ("mch_id".equals(name)) {
			refund.setMchId(text);
		} else if ("device_info".equals(name)) {
			refund.setDeviceInfo(text);
		} else if ("nonce_str".equals(name)) {
			refund.setNonceStr(text);
		} else if ("sign".equals(name)) {
			refund.setSign(text);
		} else if ("transaction_id".equals(name)) {
			refund.setTransactionId(text);
		} else if ("out_trade_no".equals(name)) {
			refund.setOutTradeNo(text);
		} else if ("out_refund_no".equals(name)) {
			refund.setOutRefundNo(text);
		} else if ("refund_id".equals(name)) {
			refund.setRefundId(text);
		} else if ("refund_channel".equals(name)) {
			refund.setRefundChannel(text);
		} else if ("refund_fee".equals(name)) {
			refund.setRefundFee(Integer.valueOf(text));
		} else if ("total_fee".equals(name)) {
			refund.setTotalFee(Integer.valueOf(text));
		} else if ("fee_type".equals(name)) {
			refund.setFeeType(text);
		} else if ("cash_fee".equals(name)) {
			refund.setCashFee(Integer.valueOf(text));
		} else if ("cash_refund_fee".equals(name)) {
			refund.setCashRefundFee(Integer.valueOf(text));
		} else if ("coupon_refund_fee".equals(name)) {
			refund.setCouponRefundFee(Integer.valueOf(text));
		} else if ("coupon_refund_count".equals(name)) {
			refund.setCouponRefundCount(Integer.valueOf(text));
		} else if ("coupon_refund_id".equals(name)) {
			refund.setCouponRefundId(text);
		}
	}

	public Refund getRefund() {
		return refund;
	}

	public void setRefund(Refund refund) {
		this.refund = refund;
	}

}
