package cn.qjq;

import java.io.*;

/**
 * 文件字符输入流(仅限文本)  加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作(读出内容)
 * 4、释放资源
 * 新增方法：
 * 	readLine()  ---读一行
 * @author qjq
 *2019年11月11日11:00:35
 */
public class BufferedReaderText {
	public static void main(String[] args) {
		File src = new File("ReaderTest.txt");
		BufferedReader io = null;
		try {
			io = new BufferedReader(new FileReader(src));
			String data = null;//每次读一行
			while((data=io.readLine()) != null) {
				System.out.println(data);
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
