package cn.qjq;

import java.io.*;

/**
 * 文件copy封装
 * @author qjq
 *2019年11月10日19:20:31
 */
public class FileUtils {
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
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			close( is, os);
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
