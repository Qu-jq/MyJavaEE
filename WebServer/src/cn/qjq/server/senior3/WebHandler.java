package cn.qjq.server.senior3;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 处理器
 * @author qjq
 *
 */
public class WebHandler extends DefaultHandler{
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tag;//存储标签
	private boolean isMapping = false;//判断标签是否为servlet-mapping

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
		tag=null;//结束标签后面还有空字符，此处设置为了防止name被空指针覆盖
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

}