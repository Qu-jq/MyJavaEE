package cn.qjq;

import java.io.*;

/**
 * 文件copy封装  方法2
 * 使用jdk1.7新方法 try...with...resource 自动释放资源
 * @author qjq
 *2019年11月10日19:45:56
 */
public class FileUtils2 {
	public static void main(String[] args) {
		//文件--->文件
		try {
			InputStream is = new FileInputStream("creat.txt");
			OutputStream os = new FileOutputStream("creat-copy.txt");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//文件、图片 -->字节数组
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
		//字节数组--->文件
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(data);
			OutputStream os = new FileOutputStream("ball-copy.png");
			copy(is,os);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
	}
	/**
	 * 对接输入输出流
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
	 *  try...with...resource 自动释放资源
	 * @param inputFile
	 * @param outputFile
	 */
	public static void copy2(String inputFile,String outputFile) {
		//1、创建源
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		/*//2、选择流
		InputStream  is  =  null;
		OutputStream os = null;*/
		//3、操作
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
	 * 释放输入输出流资源（此方法多余，可不用）
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
	 *通过 Closeable接口 释放资源
	 * @param ios
	 */
	public static void close(Closeable...ios) {//可变参数
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
