package cn.qjq;

import java.io.File;

/**
 * �ݹ���ʾ�ļ����������ļ�
 * @author Administrator
 *2019��11��6��20:25:34
 */
public class ShowFile {
	public static void main(String[] args) {
		String path = "E:/JAVA/javaspace/IO";
		File src = new File(path);
		getFileName(src,0);
	}
	
	//private File src;
	public static void getFileName(File src,int deep) {
		for(int i=0;i<deep;i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());
		if(null==src || !src.exists()) {
			return;
		}else if(src.isDirectory()) {//�����Ŀ¼�����ŵݹ�
			deep++;
			for(File f :src.listFiles()) {
				getFileName(f,deep);
			}
		}
	}
	

}
