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
 *��ϤSAX��������
 *�洢����
 * @author qjq
 *2019��12��1��11:05:45
 */
public class XmlTest02 {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//1.��ȡ��������
		SAXParserFactory factor = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parser = factor.newSAXParser();
		//3.��д������
		//4.�����ĵ�Document������
		PersonHandler handler=new PersonHandler();
		//5������
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
	private String tag;//�洢��ǩ
	@Override
	public void startDocument() throws SAXException {
		System.out.println("----�����ĵ���ʼ----");
	
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
		tag=null;//������ǩ���滹�п��ַ����˴�����Ϊ�˷�ֹname��age����ָ�븲��
			
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("----�����ĵ�����----");
	}

	public List<Person> getC() {
		return c;
	}
	
}