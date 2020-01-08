package cn.qjq;

import java.io.File;

/**
 * getName :得到文件名称
 * getAbsolutePath:返回绝对路径  不管path是绝对还是相对
 * getPath:对象是相对路径则返回相对路径，如果是绝对路径则返回绝对路径
 * getParent:如果有返回父路径，没有则返回null 
 * @author Administrator
 *2019年11月6日16:23:19
 */
public class GetPath {
	public static void main(String[] args) {
		String path = "E:\\JAVA\\javaspace\\IO\\ball.png";
		File src = new File(path);
		System.out.println("name："+src.getName());
		System.out.println("绝对路径"+src.getAbsolutePath());
		System.out.println("路径"+src.getPath());
		src = new File("ball.png");
		System.out.println("路径"+src.getPath());
		System.out.println(src.getParent());
		
		src = new File(path);
		System.out.println(src.getParent());//E:\JAVA\javaspace\IO
		
	}

}
