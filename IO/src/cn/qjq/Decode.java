package cn.qjq;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ֽ�--���ַ�
 * @author Administrator
 *2019��11��7��14:56:47
 */
public class Decode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "��������ʹ��a";
		//�����ֽ�����
		byte[] code = str.getBytes();
		byte[] code2 = str.getBytes("utf-8");
		
		String s = new  String(code,0,code.length,"GBK");
		System.out.println(s);
		
		String s1 = new  String(code,0,code.length-1,"GBK");
		System.out.println(s1);
		
		String s3 = new  String(code,0,code.length,"utf-8");//ʹ�������ַ������ �ͻ�����
		System.out.println(s3);
	}

}
