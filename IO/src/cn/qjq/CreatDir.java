package cn.qjq;

import java.io.File;
import java.util.Arrays;

/**
 * 创建目录
 * mkdir()上级目录不存在，则创建失败
 * mkdirs()上级目录不存在，则创建        这两个如果原先存在都返回false
 * list()返回当前路径下的子目录
 * listFiles()返回下一级目录对象
 * listRoots()列出所有盘符
 * @author Administrator
 *2019年11月6日19:22:30
 */
public class CreatDir {
	public static void main(String[] args) {
		String path = "E:/JAVA/javaspace/IO/test/dir";
		File src = new File(path);
		boolean flag = src.mkdir();
		System.out.println("创建目录："+flag);
		System.out.println("####################");
		
		flag = src.mkdirs();
		System.out.println("创建目录："+flag);
		
		src = new File( "E:/JAVA/javaspace/IO");
		String[] strDir = src.list();
		System.out.println(Arrays.toString(strDir));
		
		File[] fileDir = src.listFiles();//返回文件对象
		for(File f:fileDir) {
			System.out.println(f.getAbsolutePath());
		}
		//列出所有盘符
		File[] root = src.listRoots();
		for(File f:root) {
			System.out.println(f.getAbsolutePath());
		}
	}

}
