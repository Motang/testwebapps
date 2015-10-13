package com.sf.framework.domain;

import java.io.Serializable;
import java.util.UUID;

/**
 * DUBBO服务请求封装类
 * 
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0  - 2014年11月24日
 */
public class Request<R> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String requestId = UUID.randomUUID().toString();
	
	/**
	 * 调用者来源
	 */
	private String source;
	
	/** 调用者IP */
	private String ip;
	
	/** 操作者 */
	private String operator;
	
	/** 调用者的版本 */
	private String version;
	
	/**
	 * 请求真正对象存放的对方
	 */
	private R obj;

	public R getObj() {
		return obj;
	}

	public void setObj(R obj) {
		this.obj = obj;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
