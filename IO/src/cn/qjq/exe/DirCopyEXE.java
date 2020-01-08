package cn.qjq.exe;

import java.io.*;

/**
 * 文件夹copy练习
 * 任务：
 * 		将某个文件夹下的所有文件 复制到另一个文件夹
 * @author qjq
 *2019年11月9日15:31:21
 */
public class DirCopyEXE {
	public static void main(String[] args) {
		File srcFile = new File("src/cn");
	//	System.out.println(srcFile.getName());//返回当前文件名字
		File desFile = new File("E:/");
	//	System.out.println(desFile.getName());
		DirCopy(srcFile, desFile);
	}
	
	public static void DirCopy(File srcFile , File desFile) {
		if(srcFile.isDirectory()) {
			File newFile =new File(desFile,srcFile.getName());//从父抽象路径名和子路径名字符串创建新的File实例
			System.out.println(newFile.getName());
			newFile.mkdirs();//复制文件夹
			for(File f : srcFile.listFiles()) {
				DirCopy(f,newFile);
			}
		}else if(srcFile.isFile()) {
			File newFile =new File(desFile,srcFile.getName());//复制创建了空文件
			System.out.println(newFile);
			FileCopy(srcFile , newFile);//填充空文件的内容
		}
	}
	
	public static void FileCopy(File srcFile , File desFile) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(srcFile);
			os = new FileOutputStream(desFile);
			byte[] data = new byte[1024];//每次读1024个字节
			int len;
			while((len=is.read(data))!=-1) {
				os.write(data, 0, len);
				os.flush();//写入后刷新一下
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != is)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(null != os)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
