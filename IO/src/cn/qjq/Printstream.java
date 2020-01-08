package cn.qjq;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流
 * PrintStream
 * @author qjq
 *2019年11月12日20:02:11
 */
public class Printstream {
	public static void main(String[] args) throws FileNotFoundException {
		//打印流  System.out
		PrintStream ps = System.out;
		ps.println("hhaha");
		ps.println(false);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		ps.println("你好");
		ps.println("haha");
		//ps.flush();//强制刷新
		//ps.close();//在此关闭的话，后面程序看不到效果了
		
		//重定向
		System.setOut(ps);
		System.out.println("输出在哪");//不在控制台输出
		//重定向回来
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))));
		System.out.println("I am BACK");
		ps.close();
	}

}
