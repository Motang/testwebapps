package com.sf.nirvana.os.web.plugin.view;

import java.util.Map;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.sf.nirvana.os.common.base.SystemConstants;
import com.sf.nirvana.os.common.domain.JsonResult;
import com.sf.nirvana.os.common.utils.JsonResultUtils;

/**
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 * @since version1.0 
 */
public class CustomizeFastJsonView extends FastJsonJsonView {
	@Override
	protected Object filterModel(Map<String, Object> model) {
		Object value = super.filterModel(model);
		if (value != null && !(value instanceof JsonResult)) {
			value = JsonResultUtils.getJsonResult(value, SystemConstants.RESPONSE_STATUS_SUCCESS, null, null);
		}
		
		return value;
	}
}
