package com.sf.framework.utils;


/**
 * 错误码帮助类
 * 
 * @author 862911
 * @version version2.0 2015年11月6日
 * 
 */
public final class ErrorCodeUtils {
	public static final long ERR_CODE_SYSTEM = 0xFF000000;
	public static final long ERR_CODE_SERVICE = 0xFF0000;
	public static final long ERR_CODE_INTERFACE_ = 0xFF00;
	public static final long ERR_CODE_ERROR = 0xFF;
	/**
	 * @param long input
	 * the error code in Hex of type long,for example: 0x000000FF or 255L
	 * @return String
	 * the errocode in String, for example: 0x000000FF or 255L -> "000000FF"
	 */
	public static String HextoString(long input) {
		return String.format("%08X", input);
	}
	/**
	 * @param String input
	 * the errocode in String, for example: "000000FF"
	 * @return long
	 * the error code in Hex long of type long, for example: "000000FF" -> 255L
	 */
	public static long StringtoHex(String input) {
		return Long.parseLong(input, 16);
	}
	/**
	 * @param long system, long service, long interfaces, long error
	 * the corresponding error code of each part in Hex of type long, for example: system:0x02,service:0x04,interfaces:0x0a,error:0x05
	 * @return long
	 * the comprehensive error code with each part, for example: 0x02040a05
	 */
	public static long gen(long system, long service, long interfaces, long error) {
		return (system<<24) + (service<<16) + (interfaces<<8) + error;
	}
	/**
	 * @param long system, long service, long interfaces, long error
	 * the corresponding error code of each part in String, for example: system:"02",service:"04",interfaces:"0a",error:"05"
	 * @return long
	 * the comprehensive error code with each part, for example: 0x02040a05
	 */
	public static long gen(String system, String service, String interfaces, String error) {
		return gen(StringtoHex(system), StringtoHex(service), StringtoHex(interfaces), StringtoHex(error));
	}
}
