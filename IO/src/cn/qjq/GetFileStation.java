package cn.qjq;

import java.io.File;

/**
 * �ļ��Ƿ���� exists
 * ����  ��
 *     isFile �ļ�
 *     isDirectory  Ŀ¼
 * @author Administrator
 *2019��11��6��16:38:23
 */
public class GetFileStation {
	public static void main(String[] args) {
		String path = "E:\\JAVA\\javaspace\\IO\\ball.png";
		File src = new File(path);
		System.out.println("���ڣ�"+src.exists());
		System.out.println("�ļ���"+src.isFile());
		System.out.println("Ŀ¼:"+src.isDirectory());
		
		if(null == src || !src.exists()) {//�������ڻ��߿�ָ���ʱ��
			System.out.println("������");
		}else {
			if(src.isFile()) {
				System.out.println("�ļ�");
			}
			if(src.isDirectory()) {
				System.out.println("Ŀ¼");
			}
		}
	}

}
