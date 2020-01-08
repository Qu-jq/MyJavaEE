package cn.qjq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO�� �ļ��ֽ���  
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ�ϵͳ��Դ
 * @author qjq
 *2019��11��7��20:16:27
 */
public class Stream01 {
	public static void main(String[] args) {
		//1������Դ
		File src = new File("test.txt");
		InputStream is =null;
		try {
			//2��ѡ����
			is = new FileInputStream(src);
			//3������
			int data1 = is.read();
			int data2 = is.read();
			int data3 = is.read();
			int data4 = is.read();
			System.out.println((char)data1);//q
			System.out.println((char)data2);//j
			System.out.println((char)data3);//q
			System.out.println(data4);//û������ʱ������-1
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ�ϵͳ��Դ
			try {
				if(is!=null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
