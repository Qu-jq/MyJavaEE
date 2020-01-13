package cn.qjq.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *��ϤSAX��������
 *
 * @author qjq
 *2019��12��1��11:05:45
 */
public class XmlTest01 {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//1.��ȡ��������
		SAXParserFactory factor = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parser = factor.newSAXParser();
		//3.��д������
		//4.�����ĵ�Document������
		PHandler handler=new PHandler();
		//5������
		parser.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("cn/qjq/server/basic/p.xml")
		,handler);
		
		
		//˳��ѧϰһ��tim() ����һ���ַ�������ֵΪ���ַ�������ɾ���κ�ǰ����β��ո�,������пո񣬷��ؿ�
		String c=" nn ".trim();//nn
		System.out.println(c);
		c="   ".trim();//��
		System.out.println(c);
	}

}
class PHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("----�����ĵ���ʼ----");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"-->������ʼ");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		if(contents.length()>0) {
			System.out.println("����Ϊ->"+contents);			
		}else {
			System.out.println("����Ϊ->"+"��");		
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->��������");
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("----�����ĵ�����----");
	}
}