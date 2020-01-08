package cn.qjq;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:
*多个静态方法
*1、getLocalHost:本机
*2、getByName:根据域名DNS   IP地址  -->IP
*两个成员方法：
*1、getHostAddress:返回地址
*2、getHostName:返回计算机名
 * @author qjq
 *2019年11月24日15:12:10
 */
public class IPtest01 {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
		//根据域名得到InetAddress对象
		addr=InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
		addr=InetAddress.getByName("180.101.49.11");
		System.out.println(addr.getHostName());//返回的是IP地址，当这个域名不存在或者DNS不允许进行IP到域名的映射
		System.out.println(addr.getHostAddress());
		
	}

}
