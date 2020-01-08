package cn.qjq;

import java.io.*;

/**
 * �ڶ�����ϰ������IO������
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ�ϵͳ��Դ
 * @author qjq
 *2019��11��7��20:39:24
 */
public class Stream02 {
	public static void main(String[] args) {
		//1������Դ
		File src = new File("test.txt");
		InputStream is=null;
		try {
			//2��ѡ����
			is = new FileInputStream(src);
			//3������
			int data;
			while((data = is.read())!=-1) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4���ͷ�ϵͳ��Դ
			if(is!=null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		}
	}

}
