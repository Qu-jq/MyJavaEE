package cn.qjq;

import java.io.File;
import java.io.IOException;

/**
 * createNewFile 创建新文件，已创建返回false
 * delete 删除文件
 * @author Administrator
 *2019年11月6日16:54:22
 */
public class CreatNewFile {
	public static void main(String[] args) throws IOException {
		String path = "E:/JAVA/javaspace/IO/io.txt";
		File src = new File(path);
		if(src.createNewFile())
			System.out.println("创建成功");
		else {
			System.out.println("已创建，或创建失败");
		}
		//创建没有后缀的文件 注意不是文件夹
		src = new File("hex");
		if(src.createNewFile())
			System.out.println("创建成功");
		else {
			System.out.println("已创建，或创建失败");
		}
		if(src.delete())//删除
			System.out.println("删除成功");
		//创建操作系统的关键字文件  则失败
		src = new File("con");
		if(src.createNewFile())
			System.out.println("创建成功");
		else {
			System.out.println("已创建，或创建失败");
		}
		
	}
	
	
	

}
