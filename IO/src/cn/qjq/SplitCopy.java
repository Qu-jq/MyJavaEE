package cn.qjq;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * �ֿ鸴��
 * �������˼���д����
 * �ϲ�����
 * @author qjq
 *2019��11��15��14:43:48
 */
public class SplitCopy {
	private int blockSize;//ÿ���С
	private String srcFilePath;
	private String desFilePath;
	private List<String> desPath;
	private int size;
	SplitCopy(String srcFilePath,String desFilePath){
		this(1024,srcFilePath,desFilePath);//����������
	}
	SplitCopy(int blockSize,String srcFilePath,String desFilePath){
		this.blockSize = blockSize;
		this.srcFilePath = srcFilePath;
		this.desFilePath = desFilePath;
		this.desPath = new ArrayList<String>();
		init();//��ʼ��
	}
	private void init() {
		File src = new File(this.srcFilePath);
		 //�ļ��ܳ���
		 long len = src.length();
		 //����
		 this.size = (int)Math.ceil(len*1.0/this.blockSize);
		 for(int i=0;i<size;i++) {
			 this.desPath.add(this.desFilePath+"/"+i+src.getName()); 
		 }
	}
	
	public void splitCopy() throws IOException {
		 File src = new File(this.srcFilePath);
		 long len = src.length();
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
			 //System.out.println(i+"-->"+startPos+"-->"+ActulSize);
			 split( i, startPos, ActulSize);
		 }
	}
	public void merge(String des) throws IOException {
		//�����
		OutputStream fos = new BufferedOutputStream(new FileOutputStream(des,true));
		//������
		for(int i=0;i<this.desPath.size();i++) {
			InputStream is = new BufferedInputStream(new FileInputStream(this.desPath.get(i)));
			byte[] flush = new byte[1024];
			int len;
			while((len=is.read(flush))!=-1) {
				fos.write(flush, 0, len);
			}
			fos.flush();
			is.close();
		}
		fos.close();
		
	}
	/*
	 * ��ʼλ�úͶ�ȡ�� �ڼ���
	 */
	private void split(int i,int startPos,int ActulSize) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File(this.srcFilePath),"r");
		FileOutputStream os = new FileOutputStream(this.desPath.get(i));
		byte[] flush = new byte[1024];
		 int len;
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 if(ActulSize>len) {
				 os.write(flush, 0, len);
				 os.flush();
				//System.out.println(new String(flush,0,len)); 
				ActulSize -= len; 
			 }else {
				 os.write(flush, 0, ActulSize);
				 os.flush();
				 //System.out.println(new String(flush,0,ActulSize)); 
				 break;
			 }
			
		 }
		 raf.close();
		 os.close();
	}

	public static void main(String[] args) throws IOException {
		SplitCopy sc = new SplitCopy(1024,"src/cn/qjq/Copy.java","dest");
		sc.splitCopy();
		sc.merge("merger.java");
	}
}
