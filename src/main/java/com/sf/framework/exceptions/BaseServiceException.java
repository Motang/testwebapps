package com.sf.framework.exceptions;

/**
 *   runtime异常项目基础类
 *  
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0  - 2014年12月31日
 */
public class BaseServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public BaseServiceException() {
		super();
	}
	
	public BaseServiceException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}
	
	public BaseServiceException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String toString() {
		String s = getClass().getName();
		
		String errorCodeMsg = this.errorCode == null ? "" : this.errorCode;
		
        String message = getLocalizedMessage();
        message = message == null ? errorCodeMsg : (errorCodeMsg + message);
        
        return ("".equals(message)) ? s : (s + ": " + message);
	}
}
