package cn.qjq.server.senior3;

import java.util.HashSet;
import java.util.Set;

/*
<servlet-mapping>
  <servlet-name>login</servlet-name>
  <url-pattern>/login</url-pattern> 
  <url-pattern>/g</url-pattern> 
 </servlet-mapping>  
 <servlet-mapping>
  <servlet-name>reg</servlet-name>
  <url-pattern>/reg</url-pattern> 
 </servlet-mapping>
 */
public class Mapping {
	private String name;
	private Set<String> patterns ;
	
	public Mapping() {
		patterns = new HashSet<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPatterns() {
		return patterns;
	}

	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}
	
	public void addPatterns(String pattern) {
		this.patterns.add(pattern);
	}
	

}
