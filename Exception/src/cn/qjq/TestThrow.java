package cn.qjq;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ʹ��throws�����쳣
 * @author Administrator
 *2019��11��3��16:37:54
 */
public class TestThrow {
	public static void main(String[] args) throws IOException {
		readFile();
	}
	
	static void readFile() throws IOException {
		FileReader reader = null;
			reader = new FileReader("d:/a.txt");//�����쳣
			reader.read();
			if(reader!=null) {//����ʱ�쳣����Ҫ�Լ�����
				reader.close();
			}
		
	}
	

}
