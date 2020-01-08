package cn.qjq.server.senior3;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
	private static WebContext webcontext;
	static {
		try {
			//1.获取解析工场
			SAXParserFactory factor = SAXParserFactory.newInstance();
			//2.从解析工场获取解析器
			SAXParser parser = factor.newSAXParser();
			//3.编写处理器
			//4.加载文档Document处理器
			WebHandler handler=new WebHandler();
			//5、解析
			parser.parse(Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("cn/qjq/server/senior3/web.xml")
			,handler);
			
			List<Entity> entities = handler.getEntities();
			List<Mapping> mappings = handler.getMappings();
			webcontext = new WebContext(entities,mappings);
		}catch(Exception e){
			System.out.println("解析错误");
		}
	}
	/**
	 * 通过url获取配置文件对应的servlet
	 * @param url
	 * @return
	 */
	public static Servlet getServletFromUrl(String url) {
		String className =webcontext.getClz("/"+url);
		Class clz;
		
		try {
			clz = Class.forName(className);
			Servlet servlet = (Servlet)clz.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
