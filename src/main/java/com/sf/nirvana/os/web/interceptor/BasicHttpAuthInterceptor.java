package com.sf.nirvana.os.web.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.collect.Sets;
import com.sf.nirvana.os.web.utils.RemoteIPFromHttpUtil;

/**
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 */
public class BasicHttpAuthInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String AUTHORIZATION_HEADER = "Authorization";
	/**
	 * HTTP Authentication header, equal to <code>WWW-Authenticate</code>
	 */
	protected static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

	/**
	 * The name that is displayed during the challenge process of
	 * authentication, defauls to <code>application</code> and can be overridden
	 * by the {@link #setApplicationName(String) setApplicationName} method.
	 */
	private String applicationName = "OS";

	private String user = "nirvana";

	private String password = "sf123456";
	
	private String accessIpPattern = "^(\\d{1,3}(\\.\\d{1,3}){3})|(0:0:0:0:0:0:0:1)$";
	
	private Set<String> whiteList = Sets.newHashSet("10.102.25.51","10.102.25.145");
	
	//private String accessIpPattern = "^10(\\.(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)){3}$";

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccessIpPattern(String accessIpPattern) {
		this.accessIpPattern = accessIpPattern;
	}

	public void setWhiteList(Set<String> whiteList) {
		this.whiteList.addAll(whiteList);
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String clientIp = RemoteIPFromHttpUtil.getIpAddr(request);
		if (whiteList.contains(clientIp)) {
			return true;
		}
		
		boolean loggedIn = false; // false by default or we wouldn't be in this method
		if (isLoginAttempt(request, response)) {
			loggedIn = executeLogin(request, response);
		}

		if (!loggedIn) {
			sendChallenge(request, response);
		}

		return loggedIn;
	}

	private boolean executeLogin(HttpServletRequest request, HttpServletResponse response) {
		String clientIp = RemoteIPFromHttpUtil.getIpAddr(request);
		if (whiteList.contains(clientIp)) {
			if (logger.isDebugEnabled()) {
				logger.debug("allow clientIp [{}] in white list", clientIp);
			}
			return true;
		}
		
		if (!Pattern.matches(accessIpPattern, clientIp)) {
			//Match access ip pattern
			return false;
		}
		
		String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
		if (authorizationHeader == null || authorizationHeader.length() == 0) {
			// Create an empty authentication token since there is no Authorization header.
			return false;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Attempting to execute login with headers [{}]", authorizationHeader);
		}

		String[] prinCred = getPrincipalsAndCredentials(authorizationHeader, request);
		if (prinCred == null || prinCred.length < 2 || prinCred[0] == null || prinCred[1] == null) {
			// Create an authentication token with an empty password, since one hasn't been provided in the request.
			return false;
		}

		String username = prinCred[0];
		String password = prinCred[1];

		if (!username.equals(this.user) || !password.equals(this.password)) {
			return false;
		}

		return true;
	}

	private boolean isLoginAttempt(HttpServletRequest request, HttpServletResponse response) {
		String authzHeader = request.getHeader(AUTHORIZATION_HEADER);
		return authzHeader != null && isLoginAttempt(authzHeader);
	}

	private boolean isLoginAttempt(String authzHeader) {
		String authzScheme = HttpServletRequest.BASIC_AUTH.toLowerCase(Locale.ENGLISH);
		return authzHeader.toLowerCase(Locale.ENGLISH).startsWith(authzScheme);
	}

	private String[] getPrincipalsAndCredentials(String authorizationHeader, ServletRequest request) {
		if (authorizationHeader == null) {
			return null;
		}
		String[] authTokens = authorizationHeader.split(" ");
		if (authTokens == null || authTokens.length < 2) {
			return null;
		}
		return getPrincipalsAndCredentials(authTokens[0], authTokens[1]);
	}

	private String[] getPrincipalsAndCredentials(String scheme, String encoded) {
		byte[] decoded = Base64.decodeBase64(encoded);
		String decodeStr = "";
		try {
			decodeStr = new String(decoded, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("", e);

			return null;
		}

		return decodeStr.split(":", 2);
	}

	private boolean sendChallenge(HttpServletRequest request, HttpServletResponse response) {
		if (logger.isDebugEnabled()) {
			logger.debug("Authentication required: sending 401 Authentication challenge response.");
		}
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		String authcHeader = HttpServletRequest.BASIC_AUTH + " realm=\"" + applicationName + "\"";
		response.setHeader(AUTHENTICATE_HEADER, authcHeader);
		return false;
	}

}
