package cn.qjq;

import java.io.UnsupportedEncodingException;

/**
 * ���룺  �ַ�--���ֽ�
 * @author Administrator
 *2019��11��7��14:43:52
 */
public class Encode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "��������ʹ��a";
		//�����ֽ�����
		byte[] code = str.getBytes();
		System.out.println(code.length);//Ĭ��ʹ�ù��̵��ַ��� GBK  һ������2���ֽ�
		
		byte[] code2 = str.getBytes("utf-8");
		System.out.println(code2.length);//ʹ��utf-8  һ������3���ֽ�
		
		
	}

}
