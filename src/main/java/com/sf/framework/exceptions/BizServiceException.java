package com.sf.framework.exceptions;

/**
 *  在业务层中异常封装，主要是业务逻辑处理时出现问题的封装
 *  
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0  - 2014年12月31日
 */
public class BizServiceException extends BaseServiceException {

	private static final long serialVersionUID = 1L;

	public BizServiceException() {
		super();
	}

	public BizServiceException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	public BizServiceException(String errorCode) {
		super(errorCode);
	}
	
}
