package cn.qjq;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �ļ���ȡ  ---���͵��쳣����
 * @author Administrator
 *2019��11��3��16:21:41
 */
public class TestFileRead {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("d:/a.txt");//�����쳣
			System.out.println("step1");
			reader.read();
		} catch (FileNotFoundException e) {
			System.out.println("step2");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("step3");
			if(reader!=null) {//����ʱ�쳣����Ҫ�Լ�����
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
