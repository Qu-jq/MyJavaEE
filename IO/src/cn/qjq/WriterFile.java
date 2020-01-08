package cn.qjq;

import java.io.*;

/**
 * 文件字符输出流
 * 1、创建源
 * 2、选择流
 * 3、操作(写出内容)
 * 4、释放资源
 * @author qjq
 *2019年11月9日12:00:33
 */
public class WriterFile {
	public static void main(String[] args) {
		File des = new File("WriterTest.txt");
		Writer os = null;
		try {
			os = new FileWriter(des);
			String str = "你好啊，my friends\n";
			//第一种方式
			/*char[] data = str.toCharArray();
			os.write(data,0,data.length);*/
			//第二种方式
			//os.append(str).append("哈哈哈哈");
			//第三种方式
			os.write(str);
			
		} catch (IOException e) {
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
