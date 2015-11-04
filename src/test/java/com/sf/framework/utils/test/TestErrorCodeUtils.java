package com.sf.framework.utils.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.sf.framework.utils.ErrorCodeUtils;

public class TestErrorCodeUtils {

	@Test
	public void testGetErrorCode() throws DocumentException {
		Assert.assertEquals(ErrorCodeUtils.getErrorCode("common-service","message-notifications","interface3","error3"), "01000202");
		Assert.assertEquals(ErrorCodeUtils.getErrorCode("mockerrorssystem","mockerrorservice","mockerrorinterface","mockerrorerror"), null);
		
	}
	@Test
	public void testNewErrorCode() throws Exception {
		ErrorCodeUtils.newSystem("newsystem1");
	}
}
