package cn.qjq;

import java.io.File;

/**
 * �ļ�·���ı�ʾ
 * ���Ʒָ���
 * @author Administrator
 *2019��11��6��15:33:02
 */
public class FilePath01 {
	public static void main(String[] args) {
		//Ϊ���ڶ�ƽ̨ʹ�ã�һ�㲻ʹ�������ʽ
		String path = "E:\\JAVA\\javaspace\\IO\\ball.png";
		System.out.println(File.separatorChar);//    \
		//�Ƽ����ַ�ʽ
		path = "E:/JAVA/javaspace/IOball.png";
		System.out.println(path);
		//���ʹ�ý��٣���Ҳ������  ����ƴ��
		path = "E:"+File.separatorChar+"JAVA"+File.separatorChar+"javaspace";//����ʡ����
		System.out.println(path);
		
	}
}
