package com.hengtiansoft.jia.utils;

public class GeneralResult<T> {
	/**
	 * @description used to define the error code
	 * ACCESS_ERROR - access error
	 * DB_ERROR     - data base error
	 * UNKNOW_ERROR - unknown error
	 * PARAM_VALIDATE_ERROR - param validate error
	 */
	public enum ERRORCODE {
		ACCESS_ERROR, DB_ERROR, UNKNOW_ERROR,PARAM_VALIDATE_ERROR
	}

	private boolean success = true;
	private ERRORCODE errorCode;
	private String msg;
	T data;

	
	public GeneralResult(String msg) {
		this(true,msg,null);
	}

	public GeneralResult(boolean success, String msg) {
		this(success,msg,null);
	}

	public GeneralResult(boolean success, String msg, T data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}
	
	public GeneralResult(boolean success, String msg, T data,Exception e) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
		setEx(e);
	}
	public GeneralResult() {
		super();
	}

	public GeneralResult(Exception ex) {
		super();
		setEx(ex);
	}

	public void setEx(Exception ex) {
		success = false;
		/*if (ex instanceof AccessException) {
			errorCode = ERRORCODE.ACCESS_ERROR;
		} else if (ex instanceof SQLException) {
			errorCode = ERRORCODE.DB_ERROR;
		} else if(ex instanceof IllegalArgumentException){
			errorCode = ERRORCODE.PARAM_VALIDATE_ERROR;
		}
		else
		{
			errorCode = ERRORCODE.UNKNOW_ERROR;
		}*/

		if (ex.getMessage() != null) {
			this.msg = ex.getMessage();
		} else if (ex.getCause() != null) {
			this.msg = ex.getCause().getMessage();
		} else {
			this.msg = "系统发生未知错误,请稍后再试";
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ERRORCODE getErrorCode() {
		return errorCode;
	}


	public String getMsg() {
		return msg;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "GeneralResult [success=" + success + ", errorCode=" + errorCode
				+ ", msg=" + msg + ", data=" + data + "]";
	}

	
}
