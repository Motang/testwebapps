package com.sf.nirvana.os.web.controller.exception;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.nirvana.os.common.base.SystemConstants;
import com.sf.nirvana.os.common.base.SystemErrorCode;
import com.sf.nirvana.os.common.domain.JsonResult;
import com.sf.nirvana.os.common.exceptions.BaseCheckedException;
import com.sf.nirvana.os.common.exceptions.BaseRuntimeException;
import com.sf.nirvana.os.common.utils.JsonResultUtils;

/**
 * 系统异常处理
 * 
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0 
 */
@ControllerAdvice
public class SystemExceptionHandlController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(value={Throwable.class})
	@ResponseBody
	public JsonResult<?> handleAllException(Throwable ex) {
		//find the orginal target Exception
		//Throwable targetException = extractTargetException(ex);
		
		logger.error("", ex);
		
		String errorCode = SystemErrorCode.SYSTEM_HAS_ERROR;
		String message = null;
		if (ex instanceof BaseRuntimeException) {
			errorCode = ((BaseRuntimeException) ex).getCode();
			message = messageSource.getMessage(errorCode, ((BaseRuntimeException) ex).getMessages(), null);
		} 
		
		if (ex instanceof BaseCheckedException) {
			errorCode = ((BaseCheckedException) ex).getCode();
			message = messageSource.getMessage(errorCode, ((BaseCheckedException) ex).getMessages(), null);
		}
		
		if (ex instanceof MissingServletRequestParameterException){
			errorCode = SystemErrorCode.PARAMETER_HAS_ERROR;
			message = messageSource.getMessage(SystemErrorCode.PARAMETER_HAS_ERROR, null, null);
		} 
		
		if (ex instanceof TimeoutException) {
			errorCode = SystemErrorCode.SYSTEM_CONCURRENT_TIMEOUT;
			message = messageSource.getMessage(SystemErrorCode.SYSTEM_CONCURRENT_TIMEOUT, null, null);
		}
		
		if(ex instanceof UnsupportedEncodingException){
			errorCode = SystemErrorCode.SYSTEM_HAS_ILLEGALSTATE;
			message = messageSource.getMessage(SystemErrorCode.SYSTEM_HAS_ILLEGALSTATE, null, null);
		}
		if(ex instanceof NoSuchAlgorithmException){
			errorCode = SystemErrorCode.SYSTEM_HAS_ERROR;
			message = messageSource.getMessage(SystemErrorCode.SYSTEM_HAS_ERROR,null,null);
		}
		if (message == null || message.length() == 0) {
			try {
				message = messageSource.getMessage(ex.getMessage(), null, null);
			} catch (Exception e) {
				message = messageSource.getMessage(SystemErrorCode.SYSTEM_HAS_ERROR, null, null);
			}
		}
		
		JsonResult<?> result = JsonResultUtils.getJsonResult(null, SystemConstants.RESPONSE_STATUS_FAILURE, errorCode, message);
		return result;
	}
	
	

	/*
	private Throwable extractTargetException(Throwable ex) {
		if (ex instanceof InvocationTargetException) {
			Throwable targetThrowable = ((InvocationTargetException) ex).getTargetException();
			if (targetThrowable == null) {
				return ex;
			} else {
				return extractTargetException(targetThrowable);
			}
		}
		
		if (ex instanceof UndeclaredThrowableException) {
			Throwable undecleardTx = ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
			if (undecleardTx instanceof InvocationTargetException) {
				undecleardTx = ((InvocationTargetException) undecleardTx).getTargetException();
				return extractTargetException(undecleardTx);
			} else {
				return undecleardTx;
			}
		}
			
		return ex;
	}
	*/
	
}
