package cn.qjq;

import java.io.*;

/**
 * 文件字符输入流(仅限文本)
 * 1、创建源
 * 2、选择流
 * 3、操作(读出内容)
 * 4、释放资源
 * @author qjq
 *2019年11月9日11:46:36
 */
public class ReaderFile {
	public static void main(String[] args) {
		File src = new File("ReaderTest.txt");
		Reader io = null;
		try {
			io = new FileReader(src);
			char[] data = new char[1024];//每次读1024个字符
			int len;
			while((len=io.read(data)) != -1) {
				String str = new String(data,0,len);
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(null != io) {
						io.close();
				}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

}
