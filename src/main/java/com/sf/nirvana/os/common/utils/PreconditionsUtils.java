package com.sf.nirvana.os.common.utils;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.sf.nirvana.os.common.base.SystemErrorCode;
import com.sf.nirvana.os.common.exceptions.ArgumentException;

/**
 * 
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0 
 */
public final class PreconditionsUtils {

	public final static void assertBlank(String name, String value) {
		if (StringUtils.isBlank(value)) {
			throw new ArgumentException(SystemErrorCode.PARAMETER_HAS_EMPTY, new Object[]{name});
		}
	}
	
	public final static void assertEmpty(String name, String value) {
		if (StringUtils.isEmpty(value)) {
			throw new ArgumentException(SystemErrorCode.PARAMETER_HAS_EMPTY, new Object[]{name});
		}
	}
	
	public final static void checkEmpty(CharSequence... charSequence) {
		for (CharSequence sc : charSequence) {
			Preconditions.checkArgument(StringUtils.isNotEmpty(sc), SystemErrorCode.PARAMETER_HAS_NULLPOINTER);
		}
	}
	
	public final static void checkBlank(CharSequence... charSequence) {
		for (CharSequence sc : charSequence) {
			Preconditions.checkArgument(StringUtils.isNotBlank(sc), SystemErrorCode.PARAMETER_HAS_NULLPOINTER);
		}
	}
	
	public final static void checkBlank(Number... numbers) {
		for (Number number : numbers) {
			Preconditions.checkArgument(number != null, SystemErrorCode.PARAMETER_HAS_NULLPOINTER);
		}
	}
}
