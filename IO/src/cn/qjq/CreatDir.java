package cn.qjq;

import java.io.File;
import java.util.Arrays;

/**
 * ����Ŀ¼
 * mkdir()�ϼ�Ŀ¼�����ڣ��򴴽�ʧ��
 * mkdirs()�ϼ�Ŀ¼�����ڣ��򴴽�        ���������ԭ�ȴ��ڶ�����false
 * list()���ص�ǰ·���µ���Ŀ¼
 * listFiles()������һ��Ŀ¼����
 * listRoots()�г������̷�
 * @author Administrator
 *2019��11��6��19:22:30
 */
public class CreatDir {
	public static void main(String[] args) {
		String path = "E:/JAVA/javaspace/IO/test/dir";
		File src = new File(path);
		boolean flag = src.mkdir();
		System.out.println("����Ŀ¼��"+flag);
		System.out.println("####################");
		
		flag = src.mkdirs();
		System.out.println("����Ŀ¼��"+flag);
		
		src = new File( "E:/JAVA/javaspace/IO");
		String[] strDir = src.list();
		System.out.println(Arrays.toString(strDir));
		
		File[] fileDir = src.listFiles();//�����ļ�����
		for(File f:fileDir) {
			System.out.println(f.getAbsolutePath());
		}
		//�г������̷�
		File[] root = src.listRoots();
		for(File f:root) {
			System.out.println(f.getAbsolutePath());
		}
	}

}
