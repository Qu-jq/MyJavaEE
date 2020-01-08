package cn.qjq;

import java.io.*;

/**
 * �ļ��ַ������ (�����ı�)   ���뻺����   
 * 1������Դ
 * 2��ѡ����
 * 3������(д������)
 * 4���ͷ���Դ
 * ����������
 * 		newLine()    ---����  ���Բ���\n��
 * @author qjq
 *2019��11��11��11:05:26
 */
public class BufferedWriterText {
	public static void main(String[] args) {
		File des = new File("WriterTest.txt");
		BufferedWriter os = null;//��ʹ�ö�̬
		try {
			os = new BufferedWriter(new FileWriter(des));
			String str = "��ð���my friends";
			//��һ�ַ�ʽ
			/*char[] data = str.toCharArray();
			os.write(data,0,data.length);*/
			//�ڶ��ַ�ʽ
			//os.append(str).append("��������");
			//�����ַ�ʽ
			os.write(str);
			os.newLine();//����
			os.write(str);
			os.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != os)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
