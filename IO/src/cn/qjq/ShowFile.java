package cn.qjq;

import java.io.File;

/**
 * 递归显示文件名下所有文件
 * @author Administrator
 *2019年11月6日20:25:34
 */
public class ShowFile {
	public static void main(String[] args) {
		String path = "E:/JAVA/javaspace/IO";
		File src = new File(path);
		getFileName(src,0);
	}
	
	//private File src;
	public static void getFileName(File src,int deep) {
		for(int i=0;i<deep;i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());
		if(null==src || !src.exists()) {
			return;
		}else if(src.isDirectory()) {//如果是目录，接着递归
			deep++;
			for(File f :src.listFiles()) {
				getFileName(f,deep);
			}
		}
	}
	

}
