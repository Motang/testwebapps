package com.sf.nirvana.os.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteIPFromHttpUtil {
	private static Logger logger = LoggerFactory.getLogger(RemoteIPFromHttpUtil.class);

	/**
	 *
	 * 得到穿过各种代理后的IP地址
	 * @author liushengqi
	 * @created 2014年4月26日 上午10:47:11
	 *
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		Object[] ipLists = new Object[4];
		
		String ip = request.getHeader("x-forwarded-for");
		ipLists[0] = ip;
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			ipLists[1] = ip;
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			ipLists[2] = ip;
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			ipLists[3] = ip;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("x-forwarded-for ip {}, Proxy-Client-IP {}, WL-Proxy-Client-IP {}, RemoteAddr ip {}", ipLists);
		}
		
		//穿过多个代理时，取第一个IP为用户的IP
		if (ip != null && ip.length() > 0) {
			return ip.split(",")[0];
		}
		return ip;
	}

}
