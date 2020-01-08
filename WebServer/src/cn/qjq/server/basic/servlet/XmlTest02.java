package cn.qjq.server.basic.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *��ϤSAX��������
 *������С����ѧϰ
 * @author qjq
 *2019��12��1��14:23:25
 */
public class XmlTest02 {
	public static void main(String[] args) throws Exception{
		//1.��ȡ��������
		SAXParserFactory factor = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parser = factor.newSAXParser();
		//3.��д������
		//4.�����ĵ�Document������
		WebHandler handler=new WebHandler();
		//5������
		parser.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("cn/qjq/server/basic/servlet/web.xml")
		,handler);
		
		List<Entity> entities = handler.getEntities();
		List<Mapping> mappings = handler.getMappings();
		WebContext webcontext = new WebContext(entities,mappings);
		
		//������������/g ��������
		String name ="/reg";
		String className = webcontext.getClz(name);
		Class clz = Class.forName(className);
		Servlet services = (Servlet)clz.getConstructor().newInstance();
		services.service();
	}

}
class WebHandler extends DefaultHandler{
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tag;//�洢��ǩ
	private boolean isMapping = false;//�жϱ�ǩ�Ƿ�Ϊservlet-mapping

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag=qName;
		if(tag.equals("servlet")) {
			entity = new Entity();
			isMapping=false;
		}else if(tag.equals("servlet-mapping")){
			mapping = new Mapping();
			isMapping=true;
		}
			
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		if(null != tag) {
			if(!isMapping) {
				if(tag.equals("servlet-name")) {
					entity.setName(contents);
				}else if(tag.equals("servlet-class")){
					entity.setClz(contents);	
				}
			}else {
				if(tag.equals("servlet-name")) {
					mapping.setName(contents);
				}else if(tag.equals("url-pattern")){
					mapping.addPatterns(contents);	
				}
			}
			
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("servlet")) {
			entities.add(entity);
		}else if(qName.equals("servlet-mapping")) {
			mappings.add(mapping);
		}
		tag=null;//������ǩ���滹�п��ַ����˴�����Ϊ�˷�ֹname����ָ�븲��
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

}