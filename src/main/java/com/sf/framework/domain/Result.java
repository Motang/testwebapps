package com.sf.framework.domain;

import java.io.Serializable;

/**
 * DUBBO服务结果类
 * 
 * @author 709166
 *
 * @param <T>
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String requestId;

	/**
	 * 操作是否成功
	 */
	private boolean success = false;
	/**
	 * 业务编码
	 */
	private Integer business;
	/**
	 * 错误提示码
	 */
	private String errorCode;
	/**
	 * 错误提示信息
	 */
	private String errorMessage;
	/**
	 * 服务器版本
	 */
	private String version;
	/**
	 * 异常堆栈
	 */
	private Throwable exception;

	/**
	 * 结果对象
	 */
	private T obj;
	
	public Result() {
	}

	public Result(boolean success) {
		this.success = success;
	}

	/**
	 * @param requestId
	 * @param success
	 */
	public Result(String requestId, boolean success) {
		super();
		this.requestId = requestId;
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getBusiness() {
		return business;
	}

	public void setBusiness(Integer business) {
		this.business = business;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		setSuccess(false);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	/**
	 * Get exception.
	 * 
	 * @return exception. if no exception return null.
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * Has exception.
	 * 
	 * @return has exception.
	 */
	public boolean hasException() {
		return exception != null;
	}
	
	/**
	 * 服务器版本号
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
