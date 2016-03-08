package com.wideka.weixin.pay.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.wideka.club.framework.util.EncryptUtil;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.XmlUtil;
import com.wideka.weixin.api.pay.IRefundService;
import com.wideka.weixin.api.pay.bo.Refund;
import com.wideka.weixin.api.pay.bo.RefundReturn;

/**
 * 
 * @author JiakunXu
 * 
 */
public class RefundServiceImpl implements IRefundService {

	private static Logger logger = Logger.getLogger(RefundServiceImpl.class);

	@Override
	public Refund refund(Refund refund, String key) throws RuntimeException {
		if (refund == null) {
			throw new RuntimeException("refund 退款单 不能为空.");
		}

		StringBuilder sign = new StringBuilder();

		sign.append("appid=").append(refund.getAppId());
		if (StringUtils.isNotBlank(refund.getDeviceInfo())) {
			sign.append("&device_info=").append(refund.getDeviceInfo());
		}
		sign.append("&mch_id=").append(refund.getMchId());
		sign.append("&nonce_str=").append(refund.getNonceStr());
		sign.append("&op_user_id=").append(refund.getOpUserId());
		sign.append("&out_refund_no=").append(refund.getOutRefundNo());
		if (StringUtils.isNotBlank(refund.getOutTradeNo())) {
			sign.append("&out_trade_no=").append(refund.getOutTradeNo());
		}
		sign.append("&refund_fee=").append(refund.getRefundFee());
		if (StringUtils.isNotBlank(refund.getRefundFeeType())) {
			sign.append("&refund_fee_type=").append(refund.getRefundFeeType());
		}
		sign.append("&total_fee=").append(refund.getTotalFee());
		if (StringUtils.isNotBlank(refund.getTransactionId())) {
			sign.append("&transaction_id=").append(refund.getTransactionId());
		}

		sign.append("&key=").append(key);

		try {
			refund.setSign(EncryptUtil.encryptMD5(sign.toString()).toUpperCase());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		sb.append("	<appid>" + refund.getAppId() + "</appid>");

		if (StringUtils.isNotBlank(refund.getDeviceInfo())) {
			sb.append(" <device_info>" + refund.getDeviceInfo() + "</device_info>");
		}
		sb.append("	<mch_id>" + refund.getMchId() + "</mch_id>");
		sb.append("	<nonce_str>" + refund.getNonceStr() + "</nonce_str>");
		sb.append(" <op_user_id>" + refund.getOpUserId() + "</op_user_id>");
		sb.append(" <out_refund_no>" + refund.getOutRefundNo() + "</out_refund_no>");
		if (StringUtils.isNotBlank(refund.getOutTradeNo())) {
			sb.append(" <out_trade_no>" + refund.getOutTradeNo() + "</out_trade_no>");
		}
		sb.append(" <refund_fee>" + refund.getRefundFee() + "</refund_fee>");
		if (StringUtils.isNotBlank(refund.getRefundFeeType())) {
			sb.append(" <refund_fee_type>" + refund.getRefundFeeType() + "</refund_fee_type>");
		}
		sb.append(" <total_fee>" + refund.getTotalFee() + "</total_fee>");
		if (StringUtils.isNotBlank(refund.getTransactionId())) {
			sb.append(" <transaction_id>" + refund.getTransactionId() + "</transaction_id>");
		}
		sb.append(" <sign>" + refund.getSign() + "</sign>");
		sb.append("</xml>");

		String result = null;

		try {
			result = HttpUtil.post(IRefundService.HTTPS_REFUND_URL, sb.toString());
		} catch (Exception e) {
			logger.error(sb.toString(), e);
		}

		if (StringUtils.isEmpty(result)) {
			throw new RuntimeException("申请退款失败.");
		}

		try {
			result = new String(result.getBytes("GBK"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(result, e);

			throw new RuntimeException("申请退款失败.");
		}

		RefundReturn ret = (RefundReturn) XmlUtil.parse(result, new RefundReturn());

		if (ret == null) {
			throw new RuntimeException("申请退款失败.");
		}

		// 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
		if ("FAIL".equals(ret.getReturnCode())) {
			throw new RuntimeException(ret.getReturnMsg());
		}

		// 验证返回签名
		if (!validate(ret, key)) {
			throw new RuntimeException("接口返回签名验证失败.");
		}

		if ("FAIL".equals(ret.getResultCode())) {
			throw new RuntimeException(ret.getErrCode() + "|" + ret.getErrCodeDes());
		}

		return ret.getRefund();
	}

	private boolean validate(RefundReturn ret, String key) {
		Refund refund = ret.getRefund();

		StringBuilder sign = new StringBuilder();

		if (StringUtils.isNotBlank(refund.getAppId())) {
			sign.append("&appid=").append(refund.getAppId());
		}
		if (refund.getCashFee() != null) {
			sign.append("&cash_fee=").append(refund.getCashFee());
		}
		if (refund.getCashRefundFee() != null) {
			sign.append("&cash_refund_fee=").append(refund.getCashRefundFee());
		}
		if (refund.getCouponRefundCount() != null) {
			sign.append("&coupon_refund_count=").append(refund.getCouponRefundCount());
		}
		if (refund.getCouponRefundFee() != null) {
			sign.append("&coupon_refund_fee=").append(refund.getCouponRefundFee());
		}
		if (StringUtils.isNotBlank(refund.getCouponRefundId())) {
			sign.append("&coupon_refund_id=").append(refund.getCouponRefundId());
		}
		if (StringUtils.isNotBlank(refund.getDeviceInfo())) {
			sign.append("&device_info=").append(refund.getDeviceInfo());
		}
		if (StringUtils.isNotBlank(ret.getErrCode())) {
			sign.append("&err_code=").append(ret.getErrCode());
		}
		if (StringUtils.isNotBlank(ret.getErrCodeDes())) {
			sign.append("&err_code_des=").append(ret.getErrCodeDes());
		}
		if (StringUtils.isNotBlank(refund.getFeeType())) {
			sign.append("&fee_type=").append(refund.getFeeType());
		}
		if (StringUtils.isNotBlank(refund.getMchId())) {
			sign.append("&mch_id=").append(refund.getMchId());
		}
		if (StringUtils.isNotBlank(refund.getNonceStr())) {
			sign.append("&nonce_str=").append(refund.getNonceStr());
		}
		if (StringUtils.isNotBlank(refund.getRefundChannel())) {
			sign.append("&refund_channel=").append(refund.getRefundChannel());
		}
		if (refund.getRefundFee() != null) {
			sign.append("&refund_fee=").append(refund.getRefundFee());
		}
		if (StringUtils.isNotBlank(refund.getRefundId())) {
			sign.append("&refund_id=").append(refund.getRefundId());
		}
		if (StringUtils.isNotBlank(ret.getResultCode())) {
			sign.append("&result_code=").append(ret.getResultCode());
		}
		if (StringUtils.isNotBlank(ret.getReturnCode())) {
			sign.append("&return_code=").append(ret.getReturnCode());
		}
		if (StringUtils.isNotBlank(ret.getReturnMsg())) {
			sign.append("&return_msg=").append(ret.getReturnMsg());
		}
		if (refund.getTotalFee() != null) {
			sign.append("&total_fee=").append(refund.getTotalFee());
		}

		sign.append("&key=").append(key);

		try {
			if (refund.getSign().equals(EncryptUtil.encryptMD5(sign.substring(1).toString()).toUpperCase())) {
				return true;
			}
		} catch (IOException e) {
			logger.error(e);
		}

		return false;
	}

}
