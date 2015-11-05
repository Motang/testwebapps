package com.sf.framework.utils.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.sf.framework.utils.ErrorCodeUtils;

public class TestErrorCodeUtils {

//	@Test
//	public void testGetErrorCode() throws DocumentException {
//		Assert.assertEquals(ErrorCodeUtils.getErrorCode("common-service","message-notifications","interface3","error3"), "01000202");
//		Assert.assertEquals(ErrorCodeUtils.getErrorCode("mockerrorssystem","mockerrorservice","mockerrorinterface","mockerrorerror"), null);
//		
//	}
//	@Test
//	public void testNewErrorCode() throws Exception {
//		ErrorCodeUtils.newSystem("newsystem1");
//	}
	
	@Test
	public void testErrorCodeUtils() {
		Assert.assertEquals(ErrorCodeUtils.HextoString(4294901760L),"FFFF0000");
		Assert.assertEquals(ErrorCodeUtils.HextoString(255L),"000000FF");
		Assert.assertEquals(ErrorCodeUtils.HextoString(1736L),"000006C8");
		Assert.assertEquals(ErrorCodeUtils.StringtoHex("FFFF0000"),4294901760L);
		Assert.assertEquals(ErrorCodeUtils.StringtoHex("000000FF"),255L);
		Assert.assertEquals(ErrorCodeUtils.StringtoHex("000006C8"),1736L);
	}
}
