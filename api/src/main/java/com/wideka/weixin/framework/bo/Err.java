package com.wideka.weixin.framework.bo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Err implements Serializable {

	private static final long serialVersionUID = 5298150005183000384L;

	@JSONField(name = "errcode")
	private String errCode;

	@JSONField(name = "errmsg")
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
