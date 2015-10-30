package com.sf.nirvana.os.web.plugin.messageconverter;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.sf.nirvana.os.common.base.SystemConstants;
import com.sf.nirvana.os.common.domain.JsonResult;
import com.sf.nirvana.os.common.utils.JsonResultUtils;

public class CustomizeJacksonHttpMessageConverter extends MappingJacksonHttpMessageConverter{

	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		Object value = object;
		if (object != null && !(object instanceof JsonResult)) {
			value = JsonResultUtils.getJsonResult(object, SystemConstants.RESPONSE_STATUS_SUCCESS, null, null);
		}
		
		//属性为NULL 不序列化 
		//ObjectMapper objectMapper = getObjectMapper();
		//objectMapper.setSerializationInclusion(Inclusion.NON_NULL);

		super.writeInternal(value, outputMessage);
	}
}
