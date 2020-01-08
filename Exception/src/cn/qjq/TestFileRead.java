package cn.qjq;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件读取  ---典型的异常处理
 * @author Administrator
 *2019年11月3日16:21:41
 */
public class TestFileRead {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("d:/a.txt");//编译异常
			System.out.println("step1");
			reader.read();
		} catch (FileNotFoundException e) {
			System.out.println("step2");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("step3");
			if(reader!=null) {//运行时异常，需要自己处理
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
