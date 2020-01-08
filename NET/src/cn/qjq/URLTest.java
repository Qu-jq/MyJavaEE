package cn.qjq;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 * 四部分组成
 * 1、协议名
 * 2、主机名域名
 * 3、端口
 * 4、资源文件名
 * http://www.baidu.com:80/index.html?uname=qjq&&age=18#a
 * @author qjq
 *
 */
public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com:80/index.html?uname=qjq&&age=18#a");
		
		System.out.println("端口："+url.getPort());
		System.out.println("域名IP："+url.getHost());
		System.out.println("协议："+url.getProtocol());
		
		System.out.println("资源:"+url.getContent());
		System.out.println("资源："+url.getFile());
		
		//锚点
		System.out.println("锚点"+url.getRef());
		//参数
		System.out.println("参数:"+url.getQuery());
		
	}
}
