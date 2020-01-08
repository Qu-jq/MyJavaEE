package cn.qjq;

import java.io.*;

/**
 * 文件字节输出流   加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作(写出内容)
 * 4、释放资源
 * 默认GBK
 * @author Administrator
 *2019年11月11日10:22:32
 */
public class BufferdeStream_out {
	public static void main(String[] args) {
		//1、创建源
		File file = new File("creat.txt");
		//2、选择流
		OutputStream is =null;
		try {
			//3、操作(写出内容)
			is = new BufferedOutputStream(new FileOutputStream(file));//默认为false,如果为true 则从文件最后，继续添加内容；false则重头开始
			String str = "I have learnt Java For long time!\n";
			String str2 = "hold on!\n";
			byte[] data = str.getBytes("utf-8");//编码
			byte[] data2 = str2.getBytes("utf-8");//编码
			is.write(data,0,data.length);
			is.flush();//刷新流。数据量大时，最好加上
			is.write(data2,0,data2.length);
			is.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
