package com.sf.framework.utils.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.sf.framework.utils.ErrorCodeUtils;

public class TestErrorCodeUtils {

	@Test
	public void test() throws DocumentException {
		Assert.assertEquals(ErrorCodeUtils.getErrorCode("common-service","message-notifications","interface3","error3"), "01000202");
	}

}
