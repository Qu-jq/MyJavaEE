package cn.qjq.server.senior3;
/*
 * 实体类
  <servlet>
  <servlet-name>login</servlet-name>
  <servlet-class>com.sxt.server.basic.servlet.LoginServlet</servlet-class>
  </servlet>
 */
public class Entity {
	private String name;
	private String clz;
	
	public Entity() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClz() {
		return clz;
	}

	public void setClz(String clz) {
		this.clz = clz;
	}
	

}
