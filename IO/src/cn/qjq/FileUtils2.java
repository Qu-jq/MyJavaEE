package cn.qjq;

import java.io.*;

/**
 * �ļ�copy��װ  ����2
 * ʹ��jdk1.7�·��� try...with...resource �Զ��ͷ���Դ
 * @author qjq
 *2019��11��10��19:45:56
 */
public class FileUtils2 {
	public static void main(String[] args) {
		//�ļ�--->�ļ�
		try {
			InputStream is = new FileInputStream("creat.txt");
			OutputStream os = new FileOutputStream("creat-copy.txt");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ļ���ͼƬ -->�ֽ�����
		byte[] data = null;
		try {
			InputStream is = new FileInputStream("ball.png");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is,os);
			data = os.toByteArray();
			System.out.println(os.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ֽ�����--->�ļ�
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(data);
			OutputStream os = new FileOutputStream("ball-copy.png");
			copy(is,os);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
	}
	/**
	 * �Խ����������
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is,OutputStream os) {
		try {
			byte[] flush = new byte[1024];
			int len;
			while((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			close( is, os);
		}
	}
	/**
	 *  try...with...resource �Զ��ͷ���Դ
	 * @param inputFile
	 * @param outputFile
	 */
	public static void copy2(String inputFile,String outputFile) {
		//1������Դ
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		/*//2��ѡ����
		InputStream  is  =  null;
		OutputStream os = null;*/
		//3������
		try(InputStream  is=new FileInputStream(inFile);
				OutputStream os= new FileOutputStream(outFile);) {
		/*	is = new FileInputStream(inFile);
			os=new FileOutputStream(outFile);*/
			byte[] data = new byte[1024]; 
			int len;
			while((len = is.read(data))!=-1) {
				os.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �ͷ������������Դ���˷������࣬�ɲ��ã�
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is,OutputStream os) {
		try {
			if(null != is)
				is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if(null != os)
				os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 *ͨ�� Closeable�ӿ� �ͷ���Դ
	 * @param ios
	 */
	public static void close(Closeable...ios) {//�ɱ����
		for(Closeable io:ios) {
			try {
			if(null != ios)
				io.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		}
		
	}

}
