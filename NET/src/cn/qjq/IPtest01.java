package cn.qjq;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:
*�����̬����
*1��getLocalHost:����
*2��getByName:��������DNS   IP��ַ  -->IP
*������Ա������
*1��getHostAddress:���ص�ַ
*2��getHostName:���ؼ������
 * @author qjq
 *2019��11��24��15:12:10
 */
public class IPtest01 {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
		//���������õ�InetAddress����
		addr=InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
		addr=InetAddress.getByName("180.101.49.11");
		System.out.println(addr.getHostName());//���ص���IP��ַ����������������ڻ���DNS���������IP��������ӳ��
		System.out.println(addr.getHostAddress());
		
	}

}
