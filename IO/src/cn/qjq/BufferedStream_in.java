package cn.qjq;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * �ļ��ֽڶ�ȡ�����ȡ�����뻺����
 * 1������Դ
 * 2��ѡ����
 * 3���������ֶζ�ȡ��
 * 4���ͷ���Դ
 * @author Administrator
 *2019��11��11��10:22:54
 */
public class BufferedStream_in {
	public static void main(String[] args) {
		//1������Դ
		File soc = new  File("test.txt");
		InputStream is = null;
		try {
			//2��ѡ����
			is=new BufferedInputStream(new FileInputStream(soc));
			//3���������ֶζ�ȡ��
			byte[] flash = new byte[1024];//1024���ֽڵĶ�ȡ
			int len;//���ض�ȡ�ֽڵĳ��� 
			List <String> listStr = new LinkedList <String>();
			String str;
			while((len = is.read(flash))!=-1) {
				//�ֽ�����---���ַ��� �����룩
				str = new String(flash,0,len,"gbk");
				listStr.add(str);
				
			}
			System.out.println(listStr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
