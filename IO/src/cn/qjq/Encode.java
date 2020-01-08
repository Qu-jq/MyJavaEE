package cn.qjq;

import java.io.UnsupportedEncodingException;

/**
 * 编码：  字符--》字节
 * @author Administrator
 *2019年11月7日14:43:52
 */
public class Encode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "性命生命使命a";
		//编码字节数组
		byte[] code = str.getBytes();
		System.out.println(code.length);//默认使用工程的字符集 GBK  一个汉字2个字节
		
		byte[] code2 = str.getBytes("utf-8");
		System.out.println(code2.length);//使用utf-8  一个汉字3个字节
		
		
	}

}
