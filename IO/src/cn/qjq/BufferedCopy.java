package cn.qjq;

import java.io.*;

/**
 * 文件的拷贝   加入缓冲流
 * 1、创建源
 * 2、选择流（输入输出流）
 * 3、操作（分块读取）
 * 4、释放资源（先读取的后释放）
 * @author qjq
 *2019年11月9日09:57:18
 */
public class BufferedCopy {
	public static void main(String[] args) {
		copy("creat.txt","creatcopy.txt");
	}
	public static void copy(String inputFile,String outputFile) {
		//1、创建源
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		//2、选择流
		InputStream  is  =  null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		//3、操作
		try {
			is = new FileInputStream(inFile);
			os=new FileOutputStream(outFile);
			bis = new BufferedInputStream(is);
			bos=new BufferedOutputStream(os);
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
		}finally {
			//关闭缓冲流即可，会自动关闭内部字节流
			try {
				if(null != bos)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
