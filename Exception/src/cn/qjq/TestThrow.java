package cn.qjq;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用throws声明异常
 * @author Administrator
 *2019年11月3日16:37:54
 */
public class TestThrow {
	public static void main(String[] args) throws IOException {
		readFile();
	}
	
	static void readFile() throws IOException {
		FileReader reader = null;
			reader = new FileReader("d:/a.txt");//编译异常
			reader.read();
			if(reader!=null) {//运行时异常，需要自己处理
				reader.close();
			}
		
	}
	

}
