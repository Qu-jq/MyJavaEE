package cn.qjq;

import java.io.*;

/**
 * 文件字符输出流 (仅限文本)   加入缓冲流   
 * 1、创建源
 * 2、选择流
 * 3、操作(写出内容)
 * 4、释放资源
 * 新增方法：
 * 		newLine()    ---换行  可以不用\n啦
 * @author qjq
 *2019年11月11日11:05:26
 */
public class BufferedWriterText {
	public static void main(String[] args) {
		File des = new File("WriterTest.txt");
		BufferedWriter os = null;//不使用多态
		try {
			os = new BufferedWriter(new FileWriter(des));
			String str = "你好啊，my friends";
			//第一种方式
			/*char[] data = str.toCharArray();
			os.write(data,0,data.length);*/
			//第二种方式
			//os.append(str).append("哈哈哈哈");
			//第三种方式
			os.write(str);
			os.newLine();//换行
			os.write(str);
			os.newLine();
			
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
