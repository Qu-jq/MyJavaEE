package cn.qjq;

import java.io.File;

/**
 * getName :�õ��ļ�����
 * getAbsolutePath:���ؾ���·��  ����path�Ǿ��Ի������
 * getPath:���������·���򷵻����·��������Ǿ���·���򷵻ؾ���·��
 * getParent:����з��ظ�·����û���򷵻�null 
 * @author Administrator
 *2019��11��6��16:23:19
 */
public class GetPath {
	public static void main(String[] args) {
		String path = "E:\\JAVA\\javaspace\\IO\\ball.png";
		File src = new File(path);
		System.out.println("name��"+src.getName());
		System.out.println("����·��"+src.getAbsolutePath());
		System.out.println("·��"+src.getPath());
		src = new File("ball.png");
		System.out.println("·��"+src.getPath());
		System.out.println(src.getParent());
		
		src = new File(path);
		System.out.println(src.getParent());//E:\JAVA\javaspace\IO
		
	}

}
