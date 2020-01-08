package cn.qjq;

import java.io.File;

/**
 * 文件路径的表示
 * 名称分隔符
 * @author Administrator
 *2019年11月6日15:33:02
 */
public class FilePath01 {
	public static void main(String[] args) {
		//为了在多平台使用，一般不使用这个方式
		String path = "E:\\JAVA\\javaspace\\IO\\ball.png";
		System.out.println(File.separatorChar);//    \
		//推荐这种方式
		path = "E:/JAVA/javaspace/IOball.png";
		System.out.println(path);
		//这个使用较少，但也会遇到  常量拼接
		path = "E:"+File.separatorChar+"JAVA"+File.separatorChar+"javaspace";//后面省略了
		System.out.println(path);
		
	}
}
