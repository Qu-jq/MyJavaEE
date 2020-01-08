package cn.qjq.udp;

import java.io.*;

/**
 * 数组字节流 文件字节流 综合实践
 * 任务：
 * 1、文件读取到字节数组
 * 2、字节数组写出到文件
 * @author qjq
 *2019年11月9日20:01:30
 */
public class IOFille {
	/*
	 * 任务1、文件读取到字节数组
	 * A 文件  -->  通过文件字节流  --> 字节(程序) ---> 数组字节流 -->  字节数组
	 */
	public static byte[] fileToArray(String filePath) {
		//1、创建源
		File src = new File(filePath);
		//2、选择流
		InputStream is = null;
		ByteArrayOutputStream bos = null;
		//3、操作
		try {
			is = new FileInputStream(src);
			bos = new ByteArrayOutputStream();
			byte[] flush = new byte[1024];
			int len;
			while((len = is.read(flush)) != -1 ) {
				bos.write(flush, 0, len);//数组字节输出 
			}
			return bos.toByteArray();//该输出流的当前内容，作为字节数组。 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4、释放资源
			try {
				if(null != is)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/*
	 * 任务2、字节数组输出到文件
	 * B 字节数组 --> 数组字节流  --> 字节(程序)-->  通过文件字节流 --->   文件  
	 */
	public static void arrayTOFile(byte[] data,String desFilePath) {
		File desFile = new File(desFilePath);
		OutputStream os = null;
		InputStream bis = null;
		try {
			os = new FileOutputStream(desFile);
			bis = new ByteArrayInputStream(data);
			byte[] flush = new byte[1024];
			int len;
			while((len = bis.read(flush)) != -1) {
				os.write(flush, 0, len);
				os.flush();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null != os)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
