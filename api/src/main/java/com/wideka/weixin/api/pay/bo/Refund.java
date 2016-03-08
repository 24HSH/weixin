package com.wideka.weixin.api.pay.bo;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Refund {

	/**
	 * 公众账号ID.
	 */
	private String appId;

	/**
	 * 商户号.
	 */
	private String mchId;

	/**
	 * 设备号.
	 */
	private String deviceInfo;

	/**
	 * 随机字符串.
	 */
	private String nonceStr;

	/**
	 * 签名.
	 */
	private String sign;

	/**
	 * 微信订单号(微信生成的订单号，在支付通知中有返回).
	 */
	private String transactionId;

	/**
	 * 商户订单号(商户侧传给微信的订单号).
	 */
	private String outTradeNo;

	/**
	 * 商户退款单号(商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔).
	 */
	private String outRefundNo;

	/**
	 * 总金额(订单总金额，单位为分，只能为整数).
	 */
	private Integer totalFee;

	/**
	 * 退款金额(退款总金额，订单总金额，单位为分，只能为整数).
	 */
	private Integer refundFee;

	/**
	 * 货币种类(货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY).
	 */
	private String refundFeeType;

	/**
	 * 操作员(操作员帐号, 默认为商户号).
	 */
	private String opUserId;

	// >>>>>>>>>>以下是增强属性<<<<<<<<<<

	/**
	 * 微信退款单号.
	 */
	private String refundId;

	/**
	 * 退款渠道(ORIGINAL—原路退款/BALANCE—退回到余额).
	 */
	private String refundChannel;

	/**
	 * 订单金额货币种类(订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY).
	 */
	private String feeType;

	/**
	 * 现金支付金额(现金支付金额，单位为分，只能为整数).
	 */
	private Integer cashFee;

	/**
	 * 现金退款金额(现金退款金额，单位为分，只能为整数).
	 */
	private Integer cashRefundFee;

	/**
	 * 代金券或立减优惠退款金额(代金券或立减优惠退款金额=订单金额-现金退款金额，注意：立减优惠金额不会退回).
	 */
	private Integer couponRefundFee;

	/**
	 * 代金券或立减优惠使用数量(代金券或立减优惠使用数量).
	 */
	private Integer couponRefundCount;

	/**
	 * 代金券或立减优惠ID(代金券或立减优惠ID).
	 */
	private String couponRefundId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	public String getRefundFeeType() {
		return refundFeeType;
	}

	public void setRefundFeeType(String refundFeeType) {
		this.refundFeeType = refundFeeType;
	}

	public String getOpUserId() {
		return opUserId;
	}

	public void setOpUserId(String opUserId) {
		this.opUserId = opUserId;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getRefundChannel() {
		return refundChannel;
	}

	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public Integer getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(Integer cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}

	public Integer getCouponRefundFee() {
		return couponRefundFee;
	}

	public void setCouponRefundFee(Integer couponRefundFee) {
		this.couponRefundFee = couponRefundFee;
	}

	public Integer getCouponRefundCount() {
		return couponRefundCount;
	}

	public void setCouponRefundCount(Integer couponRefundCount) {
		this.couponRefundCount = couponRefundCount;
	}

	public String getCouponRefundId() {
		return couponRefundId;
	}

	public void setCouponRefundId(String couponRefundId) {
		this.couponRefundId = couponRefundId;
	}

}
