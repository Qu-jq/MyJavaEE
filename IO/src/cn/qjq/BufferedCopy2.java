package cn.qjq;

import java.io.*;

/**
 * 文件的拷贝   加入缓冲流（改进） ---->加入缓冲流提高效率
 * 1、创建源
 * 2、选择流（输入输出流）
 * 3、操作（分块读取）
 * 4、释放资源（先读取的后释放）
 * @author qjq
 *2019年11月9日09:57:18
 */
public class BufferedCopy2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		copy("creat.txt","creatcopy.txt");
		long last = System.currentTimeMillis();
		System.out.println("总共耗时："+(last-start));
	}
	public static void copy(String inputFile,String outputFile) {
		//1、创建源
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		//3、操作
		try(BufferedInputStream is= new BufferedInputStream(new FileInputStream(inFile));
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(outFile))) {
			
			byte[] data = new byte[1024]; 
			int len;
			while((len = is.read(data))!=-1) {
				os.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
