package cn.qjq;

import java.io.File;
import java.io.*;
/**
 * 文件夹copy
 * 1、创建源
 * 2、选择流
 * 3、操作（递归）
 * 4、释放资源
 * @author qjq
 *2019年11月9日10:27:41
 */

/*
 * 
 * 需求：复制多级文件夹
 * 数据源：
 * 目的地：
 * 
 * 分析
 * 		A：封装数据源、
 * 		B：封装目的地
 * 		C：判断该File是文件还是文件夹
 * 			a:是文件夹
 * 					就在目的地下创建该文件夹
 * 					获取该File对象的所有文件或者文件夹对象
 * 					遍历得到每一个File对象
 * 					回到C
 * 			b:是文件
 * 				复制文件
 * 
 * */
public class DirCopy {
 
	public static void main(String[] args) throws IOException {
 
		File srcFile=new File("src/cn");
		File destFile=new File("E:/");
		copyFolder(srcFile,destFile);
 
	}
 
	private static void copyFolder(File srcFile, File destFile) throws IOException {
		
		if(srcFile.isDirectory()){
			File newFolder=new File(destFile,srcFile.getName());//从父路径名字符串和子路径名字符串创建新的File实例
			newFolder.mkdirs();//创建目录
			File[] fileArray=srcFile.listFiles();
			
			for(File file:fileArray){
				copyFolder(file, newFolder);
			}
			
		}else{
			File newFile=new File(destFile,srcFile.getName());
			copyFile(srcFile,newFile);
		}
		
	}
 
	private static void copyFile(File srcFile, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newFile));
		
		byte[] bys=new byte[1024];
		int len=0;
		while((len=bis.read(bys))!=-1){
			bos.write(bys,0,len);
		}
		bos.close();
		bis.close();
		
	}
}
