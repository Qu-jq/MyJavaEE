package cn.qjq;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 * �Ĳ������
 * 1��Э����
 * 2������������
 * 3���˿�
 * 4����Դ�ļ���
 * http://www.baidu.com:80/index.html?uname=qjq&&age=18#a
 * @author qjq
 *
 */
public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com:80/index.html?uname=qjq&&age=18#a");
		
		System.out.println("�˿ڣ�"+url.getPort());
		System.out.println("����IP��"+url.getHost());
		System.out.println("Э�飺"+url.getProtocol());
		
		System.out.println("��Դ:"+url.getContent());
		System.out.println("��Դ��"+url.getFile());
		
		//ê��
		System.out.println("ê��"+url.getRef());
		//����
		System.out.println("����:"+url.getQuery());
		
	}
}
