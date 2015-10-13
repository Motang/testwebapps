package com.sf.framework.base;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

/**
 * 
 * @author 709166
 * @since version1.0  - 2014年11月19日
 */
public class SystemPreconditions {

	public final static void checkNullOrEmpty(String obj, String parameterName) {
		Preconditions.checkArgument(StringUtils.isNotBlank(obj), "Parameter[%s] is empty or null", parameterName);
	}
	
	public final static void checkArgument(boolean expression, String... parameterName) {
		Preconditions.checkArgument(expression, "Parameter[%s] was(were) invalid", Joiner.on(",").join(parameterName));
	}
	
	public final static <T> T checkNotNull(T t, String parameterName) {
		return Preconditions.checkNotNull(t, "Parameter[%s] is null", parameterName);
	}
	
}
