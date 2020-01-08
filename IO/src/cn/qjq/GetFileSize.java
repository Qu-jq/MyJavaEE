package cn.qjq;

import java.io.File;

/**
 * ��ȡ�ļ���С---�ֽ�
 * @author Administrator
 *2019��11��6��20:47:57
 */
public class GetFileSize {
	
	private  long size;//�ֽڴ�С
	private long dirSize;//Ŀ¼����   �ӵ�ǰ��Ŀ¼��ʼ�����ģ����Ի��ʵ�ʴ�һ
	private long fileSize;//�ļ�����
	
	private  File src;
	//������
	GetFileSize(File src){
		this.src = src;
		count(this.src);
	}
	
	private void count(File src) {
		if(null == src || !src.exists()) {
			return;
		}else if(src.isDirectory()) {
			for(File f:src.listFiles()) {
				count(f);
			}
			dirSize++;
		}else {
			size+=src.length();
			fileSize++;
		}	
	}
	
	public long getSize() {
		return size;
	}
	
	public long getDirSize() {
		return dirSize;
	}

	public long getFileSize() {
		return fileSize;
	}
    /*************���Դ���*************************/
	public static void main(String[] args) {
		File src = new File("E:/JAVA/javaspace/IO");
		GetFileSize g = new GetFileSize(src);
		System.out.println("size: "+g.getSize()+" dirSize: "+g.dirSize+" fileSize: "+g.fileSize);
		src = new File("E:/JAVA/javaspace/IO/src");
		g = new GetFileSize(src);
		System.out.println("size: "+g.getSize()+" dirSize: "+g.dirSize+" fileSize: "+g.fileSize);
	}

}
