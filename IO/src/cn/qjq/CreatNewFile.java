package cn.qjq;

import java.io.File;
import java.io.IOException;

/**
 * createNewFile �������ļ����Ѵ�������false
 * delete ɾ���ļ�
 * @author Administrator
 *2019��11��6��16:54:22
 */
public class CreatNewFile {
	public static void main(String[] args) throws IOException {
		String path = "E:/JAVA/javaspace/IO/io.txt";
		File src = new File(path);
		if(src.createNewFile())
			System.out.println("�����ɹ�");
		else {
			System.out.println("�Ѵ������򴴽�ʧ��");
		}
		//����û�к�׺���ļ� ע�ⲻ���ļ���
		src = new File("hex");
		if(src.createNewFile())
			System.out.println("�����ɹ�");
		else {
			System.out.println("�Ѵ������򴴽�ʧ��");
		}
		if(src.delete())//ɾ��
			System.out.println("ɾ���ɹ�");
		//��������ϵͳ�Ĺؼ����ļ�  ��ʧ��
		src = new File("con");
		if(src.createNewFile())
			System.out.println("�����ɹ�");
		else {
			System.out.println("�Ѵ������򴴽�ʧ��");
		}
		
	}
	
	
	

}
