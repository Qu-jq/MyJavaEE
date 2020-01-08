package cn.qjq;

import java.io.*;

/**
 * 仅文本的拷贝  加入缓冲流
 * 1、创建源
 * 2、选择流（输入输出流）
 * 3、操作（逐行读取）
 * 4、释放资源（先读取的后释放）
 * @author qjq
 *2019年11月11日11:11:11
 */
public class CopyOnlyText {
	public static void main(String[] args) {
		copyText("creat.txt","creatcopy.txt");
	}
	public static void copyText(String inputFile,String outputFile) {
		//1、创建源
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		//2、选择流
		//3、操作---逐行读取
		try(BufferedReader is = new BufferedReader(new FileReader(inFile));
				BufferedWriter os = new BufferedWriter(new FileWriter(outFile))){
			
			String data = null;
			while((data = is.readLine())!=null) {
				os.write(data);
				os.newLine();
				os.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
