package com.sf.framework.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.LogSource;
import org.apache.commons.logging.impl.Log4JLogger;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
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
	private String parameter[]=new String [4];
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
	public ErrorCodeUtils()
	{}
	public ErrorCodeUtils(String system,String Service,String Interface,String Error)
	{
		parameter[0]=system;
		parameter[1]=Service;
		parameter[2]=Interface;
		parameter[3]=Error;
	}
	
	public boolean getErrorCode(int para,Element node)
	{
		if(para==4)
			return true;
		node=node.element(parameter[para]);
		if(node!=null)
		{
			errCode+=node.attributeValue("code");
			return getErrorCode(para+1,node);
		}
		return false;
	}
	
	public void writer(Document document) throws Exception {  
	        // 紧凑的格式  
	        // OutputFormat format = OutputFormat.createCompactFormat();  
	        // 排版缩进的格式  
	        OutputFormat format = OutputFormat.createPrettyPrint();  
	        // 设置编码  
	        format.setEncoding("UTF-8");  
	        // 创建XMLWriter对象,指定了写出文件及编码格式  
	        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
	        		//new FileOutputStream(new File("D:/a.xml")), "UTF-8"), format);
	                new FileOutputStream(new File(ClassLoader.getSystemResource("").getPath()+"/ErrorCode/sf-nirvana-errorCode.xml")), "UTF-8"), format);  
	        // 写入  
	        writer.write(document);  
	        // 立即写入  
	        writer.flush();  
	        // 关闭操作  
	        writer.close();  
	}
	public static String getErrorCode(String system,String Service,String Interface,String Error) throws DocumentException
	{
		SAXReader reader = new SAXReader();                
	    Document document = reader.read(new File(ClassLoader.getSystemResource("").getPath()+"/ErrorCode/sf-nirvana-errorCode.xml"));
	    Element root = document.getRootElement();
	    ErrorCodeUtils ecu=new ErrorCodeUtils(system,Service,Interface,Error);
	    if(ecu.getErrorCode(0,root))
	    {
	    	System.out.println("Success");
	    	return ecu.errCode;
	    }
	    else
	    {
	    	System.out.println("Error is not contained in the xml! Please Check and modify!");
	    	return null;
	    }
	}
	
	public static boolean newSystem(String system) throws Exception
	{
		SAXReader reader = new SAXReader();                
	    Document document = reader.read(new File(ClassLoader.getSystemResource("").getPath()+"/ErrorCode/sf-nirvana-errorCode.xml"));
	    Element root = document.getRootElement(),node=null;
	    node=root.element(system);
	    if(node!=null)
	    {
	    	System.out.println("System exists!");
	    	return false;
	    }
	    Iterator<Element> it = root.elementIterator();
	    while (it.hasNext())
            node = it.next();
	    int newCode=Integer.parseInt(node.attributeValue("code"), 16)+1;
	    root.addElement(system);
	    root.element(system).addAttribute("code", String.format("%02X",newCode));
	    // 写入到一个新的文件中  
        new ErrorCodeUtils().writer(document);
	    return true;
	}
}
