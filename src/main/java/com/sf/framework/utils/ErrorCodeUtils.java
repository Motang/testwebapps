package com.sf.framework.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.LogSource;
import org.apache.commons.logging.impl.Log4JLogger;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 错误码读取，错误码以xml文件的形式存储在src/main/resources/ErrorCode目录下
 * 
 * @author 862911
 * @version version1.0 2015年11月3日
 */
public class ErrorCodeUtils {
	
	private String errCode="";
	/**
	 * 在xml文件中，错误码格式如
	 * <system code="00">
	 * 	<Service code="11">
	 * 		<Interface code="22">
	 * 			<Error code="33"/>
	 * 		</Interface>
	 * 	</Service>
	 * </system>
	 * 所以错误码为00112233
	 * 
	 * @param system 表示系统
	 * @param Service 表示模块
	 * @param Interface 表示接口
	 * @param Error 表示具体错误
	 * @return 错误码
	 * @throws DocumentException
	 */
	public static String getErrorCode(String system,String Service,String Interface,String Error) throws DocumentException
	{
		SAXReader reader = new SAXReader();                
	    Document document = reader.read(new File(ClassLoader.getSystemResource("").getPath()+"/ErrorCode/sf-nirvana-errorCode.xml"));
	    Element root = document.getRootElement();
	    return new ErrorCodeUtils().getErrorCode(system,Service,Interface,Error,root);
	}
	
	
	public String getErrorCode(String system,String Service,String Interface,String Error,Element node)
	{
		Iterator<Element> it = node.elementIterator();
		while (it.hasNext()) {  
            node = it.next();  
            if(node.getName().equals(system))
            {
            	errCode+=node.attributeValue("code");
            	it = node.elementIterator();
            	while (it.hasNext())
            	{
            		node = it.next();
            		if(node.getName().equals(Service))
            		{
            			errCode+=node.attributeValue("code");
                    	it = node.elementIterator();
                    	while (it.hasNext())
                    	{
                    		node = it.next();
                    		if(node.getName().equals(Interface))
                    		{
                    			errCode+=node.attributeValue("code");
                            	it = node.elementIterator();
                            	while (it.hasNext())
                            	{
                            		node = it.next();
                            		if(node.getName().equals(Error))
                            		{
                            			errCode+=node.attributeValue("code");
                            			return errCode;
                            		}
                            	}
                    			continue;
                    		}
                    	}
            			continue;
            		}
            	}
            	continue; 
            }
        }  
		//System.out.println("Error is not contained in the xml! Please Check and modify!");
		return null;
	}
}
