package com.sf.nirvana.os.common.base;

/**
 * 对应resourcemessage资源文件的key
 * 
 * <pre>
 * 跟客户端请求有关的错误,错误代码以R开头;
 * 跟系统有关的错误,错误代码以E开头;
 * 另外，对于跟业务及逻辑有关的L开头;
 * </pre>
 * 
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 */
public interface SystemErrorCode {
	//////================跟客户端请求有关的错误===============//////////
	/** 请求参数错误 */
	String PARAMETER_HAS_ERROR = "R0001";
	/** 参数{0}值不能为空  */
	String PARAMETER_HAS_EMPTY = "R0002";
	/** 请求参数不适合,如格式错误，值不在范围内 */
	String PARAMETER_HAS_ILLEGALSTATE = "R0003";
	/** 请求参数数组及集合类越界 */
	String PARAMETER_HAS_INDEXOUTOFBOUNDS = "R0004";
	/** 请求参数存在空指针或空值  */
	String PARAMETER_HAS_NULLPOINTER = "R0005";
	/** 下单时手机号码格式错误  */
	String PARAMETER_MOBILE_ERROR = "R0006";
	//////================跟系统有关的错误或业务逻辑有关===============//////////
	/** 系统错误  */
	String SYSTEM_HAS_ERROR = "E0001";
	/** 系统异常，参数为空  */
	String SYSTEM_HAS_EMPTY = "E0002";
	/** 系统异常，参数不适合,如格式错误或值不在规定范围内 */
	String SYSTEM_HAS_ILLEGALSTATE = "E0003";
	/** 系统异常，出现数组及集合类越界  */
	String SYSTEM_HAS_INDEXOUTOFBOUNDS = "E0004";
	/** 系统错误,空指针异常  */
	String SYSTEM_HAS_NULLPOINTER = "E0005";
	/** 操作失败  */
	String SYSTEM_OPERATION_FAITURE = "E0006";
	/** 未知错误 */
	String SYSTEM_UNKNOWN_ERROR = "E0007";
	/** 系统不支持的业务 */
	String SYSTEM_UNSUPPORT_ERROR = "E0008";
	/** 并行操作的超时错误 */
	String SYSTEM_CONCURRENT_TIMEOUT = "E0009";
	
}
