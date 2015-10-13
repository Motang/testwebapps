package com.sf.framework.exceptions;

/**
 *  在数据层中数据库异常封装，主要是数据或值在操作数据库时出现问题的封装
 *  
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0  - 2014年12月31日
 */
public class DataServiceException extends BaseServiceException {
	
	private static final long serialVersionUID = 1L;

	public DataServiceException() {
		super();
	}

	public DataServiceException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	public DataServiceException(String errorCode) {
		super(errorCode);
	}

}
