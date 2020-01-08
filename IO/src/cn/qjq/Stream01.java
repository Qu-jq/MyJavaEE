package cn.qjq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO流 文件字节流  
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放系统资源
 * @author qjq
 *2019锟斤拷11锟斤拷7锟斤拷20:16:27
 */
public class Stream01 {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("test.txt");
		InputStream is =null;
		try {
			//2、选择流
			is = new FileInputStream(src);
			//3、操作
			int data1 = is.read();
			int data2 = is.read();
			int data3 = is.read();
			int data4 = is.read();
			System.out.println((char)data1);//q
			System.out.println((char)data2);//j
			System.out.println((char)data3);//q
			System.out.println(data4);//没锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷-1
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4、释放系统资源
			try {
				if(is!=null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
