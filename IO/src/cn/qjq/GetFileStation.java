package cn.qjq;

import java.io.File;

/**
 * 文件是否存在 exists
 * 存在  ：
 *     isFile 文件
 *     isDirectory  目录
 * @author Administrator
 *2019年11月6日16:38:23
 */
public class GetFileStation {
	public static void main(String[] args) {
		String path = "E:\\JAVA\\javaspace\\IO\\ball.png";
		File src = new File(path);
		System.out.println("存在："+src.exists());
		System.out.println("文件："+src.isFile());
		System.out.println("目录:"+src.isDirectory());
		
		if(null == src || !src.exists()) {//当不存在或者空指针的时候
			System.out.println("不存在");
		}else {
			if(src.isFile()) {
				System.out.println("文件");
			}
			if(src.isDirectory()) {
				System.out.println("目录");
			}
		}
	}

}
