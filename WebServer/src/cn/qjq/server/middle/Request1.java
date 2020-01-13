package cn.qjq.server.middle;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * ��װ����Э��: ��ȡ method uri�Լ��������
 * 
 * @author qjq
 *
 */
public class Request1 {
	//Э����Ϣ
	private String requestInfo;
	//����ʽ
	private String method; 
	//����url
	private String url; 
	//�������
	private String queryStr;
	private final  String CRLF = "\r\n";
	public Request1(Socket client) throws IOException {
		this(client.getInputStream());
	}
	public Request1(InputStream is) {		
		byte[] datas = new byte[1024*1024];
		int len;
		try {
			len = is.read(datas);
			this.requestInfo = new String(datas,0,len);			
		} catch (IOException e) {
			e.printStackTrace();
			return ;
		}
		//�ֽ��ַ���
		parseRequestInfo();
	}
	
	private void parseRequestInfo() {
		System.out.println("------�ֽ�-------");
		System.out.println("---1����ȡ����ʽ: ��ͷ����һ��/------");
		this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		System.out.println("---2����ȡ����url: ��һ��/ �� HTTP/------");
		System.out.println("---���ܰ����������? ǰ���Ϊurl------");
		//1)����ȡ/��λ��
		int startIdx = this.requestInfo.indexOf("/")+1;
		//2)����ȡ HTTP/��λ��
		int endIdx = this.requestInfo.indexOf("HTTP/");
		//3)���ָ��ַ���
		this.url = this.requestInfo.substring(startIdx, endIdx);		
		//4)����ȡ����λ��
		int queryIdx =this.url.indexOf("?");	
		if(queryIdx>=0) {//��ʾ�����������
			String[] urlArray = this.url.split("\\?");
			this.url =urlArray[0];
			queryStr =urlArray[1];
		}
		System.out.println(this.url);
		
		System.out.println("---3����ȡ�������:���Get�Ѿ���ȡ,�����post��������������------");
		
		if(method.equals("post")) {
			String qStr =this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			System.out.println(qStr+"-->"); 
			if(null==queryStr) {
				queryStr =qStr;
			}else { 
				queryStr +="&"+qStr;
			}
		}
		queryStr = null==queryStr?"":queryStr;
		System.out.println(method+"-->"+url+"-->"+queryStr);
	}

}