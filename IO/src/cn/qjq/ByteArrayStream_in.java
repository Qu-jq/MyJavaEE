package cn.qjq;

import java.io.*;

/**
 * 字节数组输入流
 * 1、创建源（字节,不要太大，防止内存占满）
 * 2、选择流
 * 3、操作
 * 4、释放系统资源（可有可无，为了和前面文件字节流保持编程统一，可以有）
 * @author qjq
 *2019年11月9日17:05:38
 */
public class ByteArrayStream_in {
	public static void main(String[] args) {
		//1、创建源（字节）
		byte[] src = "show me the code".getBytes();//字符转字节
		//2、选择流
		InputStream bio = null;
		try {
			bio = new ByteArrayInputStream(src);
			//3、操作
			byte[] flush = new byte[1024];//每次读1024字节
			int len;
			while((len = bio.read(flush)) != -1) {
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
				e.printStackTrace();
		}finally {
			//4、释放系统资源（可有可无，为了和前面文件字节流保持编程统一，可以有）
			try {
				if(null != bio)
					bio.close();
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		
	}

}
