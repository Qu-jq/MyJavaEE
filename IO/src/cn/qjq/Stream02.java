package cn.qjq;

import java.io.*;

/**
 * 第二遍练习基本的IO流操作
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放系统资源
 * @author qjq
 *2019年11月7日20:39:24
 */
public class Stream02 {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("test.txt");
		InputStream is=null;
		try {
			//2、选择流
			is = new FileInputStream(src);
			//3、操作
			int data;
			while((data = is.read())!=-1) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4、释放系统资源
			if(is!=null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		}
	}

}
