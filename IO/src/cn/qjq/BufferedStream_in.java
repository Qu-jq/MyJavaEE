package cn.qjq;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件字节读取（块读取）加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作（分段读取）
 * 4、释放资源
 * @author Administrator
 *2019年11月11日10:22:54
 */
public class BufferedStream_in {
	public static void main(String[] args) {
		//1、创建源
		File soc = new  File("test.txt");
		InputStream is = null;
		try {
			//2、选择流
			is=new BufferedInputStream(new FileInputStream(soc));
			//3、操作（分段读取）
			byte[] flash = new byte[1024];//1024个字节的读取
			int len;//返回读取字节的长度 
			List <String> listStr = new LinkedList <String>();
			String str;
			while((len = is.read(flash))!=-1) {
				//字节数组---》字符串 （解码）
				str = new String(flash,0,len,"gbk");
				listStr.add(str);
				
			}
			System.out.println(listStr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4、释放资源
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
