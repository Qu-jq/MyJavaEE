package cn.qjq;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ������������ RandomAccessFile
 * �·�����
 * 		seek()  -- >������ĸ��ֽڿ�ʼ��
 * @author qjq
 *2019��11��14��14:48:19
 */
public class RadomStream {
	public static void main(String[] args) throws IOException {
		 File src = new File("src/cn/qjq/copy.java");
		 //�ļ��ܳ���
		 long len = src.length();
		//ÿ���С
		 int blockSize = 1024;
		 //����
		 int size = (int)Math.ceil(len*1.0/blockSize);
		 int startPos = 0;//��ʼλ��
		 int ActulSize = (int)(blockSize>len?len:blockSize);//���ȡ������
		 for(int i=0;i<size;i++) {
			 startPos = i*blockSize;
			 if(i==size-1) {//���һ��
				 ActulSize = (int) len;//���ʣ�µ���
			 }else {
				 ActulSize = blockSize;
				 len -= ActulSize;//ʣ����
			 }
			 System.out.println(i+"-->"+startPos+"-->"+ActulSize);
			 plit( i, startPos, ActulSize);
		 }
		 
		 
	}
	/*
	 * ��ʼλ�úͶ�ȡ�� �ڼ���
	 */
	public static void plit(int i,int startPos,int ActulSize) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("src/cn/qjq/copy.java"),"r");
		 byte[] flush = new byte[1024];
		 int len;
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 if(ActulSize>len) {
				System.out.println(new String(flush,0,len)); 
				ActulSize -= len; 
			 }else {
				 System.out.println(new String(flush,0,ActulSize)); 
				 break;
			 }
			
		 }
		 raf.close();
	}
	/*
	 * ��ʼλ�úͶ�ȡ��
	 */
	public static void test02() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("src/cn/qjq/copy.java"),"r");
		 byte[] flush = new byte[1024];
		 int len;
		 int startPos = 2;//��ʼλ��
		 int ActulSize = 1026;//���ȡ������
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 if(ActulSize>len) {
				System.out.println(new String(flush,0,len)); 
				ActulSize -= len; 
			 }else {
				 System.out.println(new String(flush,0,ActulSize));
				 break;
			 }
			
		 }
		 raf.close();
	}
	/*
	 * �ӵ�һ���ֽڶ�ȡ
	 */
	public static void test01() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("src/cn/qjq/copy.java"),"r");
		 byte[] flush = new byte[1024];
		 int len;
		 int startPos = 2;//��ʼλ��
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 System.out.println(new String(flush,0,len));
		 }
		 raf.close();
	}

}
