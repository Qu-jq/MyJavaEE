package cn.qjq.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *熟悉SAX解析流程
 *存储数据
 * @author qjq
 *2019年12月1日11:05:45
 */
public class XmlTest02 {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//1.获取解析工场
		SAXParserFactory factor = SAXParserFactory.newInstance();
		//2.从解析工场获取解析器
		SAXParser parser = factor.newSAXParser();
		//3.编写处理器
		//4.加载文档Document处理器
		PersonHandler handler=new PersonHandler();
		//5、解析
		parser.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("cn/qjq/server/basic/p.xml")
		,handler);
		
		List<Person> persons = handler.getC();
		for(Person person:persons) {
			System.out.println(person.getName()+"--->"+person.getAge());
		}
	}

}
class PersonHandler extends DefaultHandler{
	private List<Person> c = new ArrayList<Person>();
	private Person person;
	private String tag;//存储标签
	@Override
	public void startDocument() throws SAXException {
		System.out.println("----解析文档开始----");
	
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag=qName;
		if(tag.equals("person")) {
			person = new Person();
		}
			
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		if(null != tag) {
			if(tag.equals("name")) {
				person.setName(contents);
			}else if(tag.equals("age")){
				person.setAge(Integer.valueOf(contents));	
			}
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("person")) {
			c.add(person);
		}
		tag=null;//结束标签后面还有空字符，此处设置为了防止name，age被空指针覆盖
			
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("----解析文档结束----");
	}

	public List<Person> getC() {
		return c;
	}
	
}