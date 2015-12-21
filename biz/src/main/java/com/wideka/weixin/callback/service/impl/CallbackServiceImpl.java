package com.wideka.weixin.callback.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.XmlUtil;
import com.wideka.weixin.api.callback.ICallbackService;
import com.wideka.weixin.api.callback.bo.Content;
import com.wideka.weixin.api.suite.bo.IP;

/**
 * 
 * @author JiakunXu
 * 
 */
public class CallbackServiceImpl implements ICallbackService {

	private static Logger logger = Logger.getLogger(CallbackServiceImpl.class);

	private void validate(String token, String encodingAesKey, String corpId, String signature, String timestamp,
		String nonce) throws RuntimeException {
		if (StringUtils.isBlank(token)) {
			throw new RuntimeException("token cannot be null.");
		}

		if (StringUtils.isBlank(encodingAesKey)) {
			throw new RuntimeException("encodingAesKey cannot be null.");
		}

		if (StringUtils.isBlank(corpId)) {
			throw new RuntimeException("corpId cannot be null.");
		}

		if (StringUtils.isBlank(signature)) {
			throw new RuntimeException("signature cannot be null.");
		}

		if (StringUtils.isBlank(timestamp)) {
			throw new RuntimeException("timestamp cannot be null.");
		}

		if (StringUtils.isBlank(nonce)) {
			throw new RuntimeException("nonce cannot be null.");
		}
	}

	@Override
	public String verify(String token, String encodingAesKey, String corpId, String signature, String timestamp,
		String nonce, String echostr) throws RuntimeException {

		validate(token, encodingAesKey, corpId, signature, timestamp, nonce);

		if (StringUtils.isBlank(echostr)) {
			throw new RuntimeException("echostr cannot be null.");
		}

		WXBizMsgCrypt wxcpt = null;

		try {
			wxcpt = new WXBizMsgCrypt(token.trim(), encodingAesKey.trim(), corpId.trim());
		} catch (AesException e) {
			logger.error(e);

			throw new RuntimeException(e.getMessage());
		}

		try {
			return wxcpt.VerifyURL(signature.trim(), timestamp.trim(), nonce.trim(), echostr.trim());
		} catch (AesException e) {
			logger.error(e);

			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Content callback(String token, String encodingAesKey, String corpId, String signature, String timestamp,
		String nonce, String data) throws RuntimeException {

		validate(token, encodingAesKey, corpId, signature, timestamp, nonce);

		if (StringUtils.isBlank(data)) {
			throw new RuntimeException("data cannot be null.");
		}

		WXBizMsgCrypt wxcpt = null;

		try {
			wxcpt = new WXBizMsgCrypt(token.trim(), encodingAesKey.trim(), corpId.trim());
		} catch (AesException e) {
			logger.error(e);

			throw new RuntimeException(e.getMessage());
		}

		try {
			return (Content) XmlUtil.parse(
				wxcpt.DecryptMsg(signature.trim(), timestamp.trim(), nonce.trim(), data.trim()), new Content());
		} catch (AesException e) {
			logger.error(e);

			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error(e);

			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String[] getCallbackIP(String accessToken) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		try {
			IP ip = JSON.parseObject(HttpUtil.get(ICallbackService.HTTPS_CALLBACK_IP_URL + accessToken), IP.class);
			return ip.getIpList();
		} catch (Exception e) {
			logger.error(e);

			throw new RuntimeException("HttpUtil error.", e);
		}
	}

}
