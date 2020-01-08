package cn.qjq.server.basic.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为便于操作，将解析的数据变成map
 * @author qjq
 *2019年12月1日15:14:41
 */
public class WebContext {
	private List<Entity> entities=null;
	private List<Mapping> mappings=null;
	//key --> servlet-name    value --> servlet-class
	private Map<String,String> entityMap = new HashMap<String, String>();
	
	//key --> url-pattern      value --> servlet-name
	private Map<String,String> mappingMap = new HashMap<String, String>();
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		this.entities = entities;
		this.mappings = mappings;
		//将list转成map
		for(Entity entity : entities) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		for(Mapping mapping : mappings) {
			for(String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
		
	}
	
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}
	
}
