package cn.qjq;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节--》字符
 * @author Administrator
 *2019年11月7日14:56:47
 */
public class Decode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "性命生命使命a";
		//编码字节数组
		byte[] code = str.getBytes();
		byte[] code2 = str.getBytes("utf-8");
		
		String s = new  String(code,0,code.length,"GBK");
		System.out.println(s);
		
		String s1 = new  String(code,0,code.length-1,"GBK");
		System.out.println(s1);
		
		String s3 = new  String(code,0,code.length,"utf-8");//使用其他字符库解码 就会乱码
		System.out.println(s3);
	}

}
