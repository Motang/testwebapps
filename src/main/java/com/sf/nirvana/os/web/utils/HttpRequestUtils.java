package com.sf.nirvana.os.web.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0 
 */
public abstract class HttpRequestUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getAttributValue(HttpServletRequest request, String key) {
		return (T) request.getAttribute(key);
	}
	
}
