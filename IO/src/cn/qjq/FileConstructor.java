package cn.qjq;

import java.io.File;

/**
 * file构造器
 * @author Administrator
 *2019年11月6日15:44:28
 */
public class FileConstructor {

	public static void main(String[] args) {
		//1.
		String path = "E:/JAVA/javaspace/IO/ball.png";
		File src = new File(path);
		System.out.println(src.length());
		//2.
		src = new File("E:/JAVA/javaspace/IO","ball.png");
		System.out.println(src.length());
		//3.
		src = new File("E:/JAVA/javaspace","IO/ball.png");
		System.out.println(src.length());
		//4.
		src = new File(new File("E:/JAVA/javaspace/IO"),"ball.png");
		System.out.println(src.length());
		//绝对路径
		String path1 = "E:/JAVA/javaspace/IO/ball.png";
		File src1 = new File(path1);
		System.out.println(src1.getAbsolutePath());
		
		//相对路径
		src1 = new File("ball.png");
		System.out.println(src1.getAbsolutePath());
		//
		src1 = new File("aaaball.png");//一个不存在的文件
		System.out.println(src1.getAbsolutePath());//不报异常，仍然可以打印绝对地址
	}
}
