package cn.qjq.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *熟悉SAX解析流程
 *
 * @author qjq
 *2019年12月1日11:05:45
 */
public class XmlTest01 {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//1.获取解析工场
		SAXParserFactory factor = SAXParserFactory.newInstance();
		//2.从解析工场获取解析器
		SAXParser parser = factor.newSAXParser();
		//3.编写处理器
		//4.加载文档Document处理器
		PHandler handler=new PHandler();
		//5、解析
		parser.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("cn/qjq/server/basic/p.xml")
		,handler);
		
		
		//顺带学习一下tim() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格,如果仅有空格，返回空
		String c=" nn ".trim();//nn
		System.out.println(c);
		c="   ".trim();//空
		System.out.println(c);
	}

}
class PHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("----解析文档开始----");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"-->解析开始");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		if(contents.length()>0) {
			System.out.println("内容为->"+contents);			
		}else {
			System.out.println("内容为->"+"空");		
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->解析结束");
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("----解析文档结束----");
	}
}