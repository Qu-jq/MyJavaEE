package cn.qjq;

import java.io.*;
import java.net.URL;

/**
 * 转换流：（纯文本）
InputStreamReader    字节集-->字符集     解码
outputStreamWriter   字符集-->字节集     编码

-------------最好加缓冲流处理  -->效率高

1、以字符流的形式操作字节流（纯文本）
2、指定字符集
 * @author qjq
 *2019年11月12日15:12:53
 */
public class ConvertStream {
	public static void main(String[] args) {
		//操作网络流   下载百度的源代码
		
		try (BufferedReader is = 
				new BufferedReader(
						new InputStreamReader(
								new URL("http://www.baidu.com").openStream(),"GBK"));
				BufferedWriter os = 
						new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream("baidu.html"),"GBK"));){
			
			/*int temp;
			while((temp=is.read())!=-1) {//一个字节一个字节的读
				System.out.print((char)temp);//汉字产生乱码
			}*/
			String data="";
			while((data = is.readLine())!=null) {
				System.out.println(data);
				os.write(data);
				os.newLine();
			}
			os.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	/*
	 * 1、以字符流的形式操作字节流（纯文本）
	 */
	public static void test01(){
		try(BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(System.out));) {
			String data  = "";
			/*while((data=isr.readLine())!=null) {
				osw.write(data);
				osw.newLine();
			}*/
			//循环获取键盘输入（exit退出）
			while(!data.equals("exit")) {
				data = isr.readLine();
				osw.write(data);
				osw.newLine();
				osw.flush();//在此处强制刷新，不然不显示。因为数据量小，还没有达到缓冲流默认的大小
			}
			//osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 下载网络源码
	 * 由于一个字节一个字节的读取，汉字出现乱码
	 */
	public static void test02() {
		try (InputStream is = new URL("http://www.baidu.com").openStream();){
			
			int temp;
			while((temp=is.read())!=-1) {//一个字节一个字节的读
				System.out.print((char)temp);//汉字产生乱码
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * InputStreamReader将字节转换为字符
	 */
	public static void test03() {
		try (InputStreamReader is = 
				new InputStreamReader(new URL("http://www.baidu.com").openStream(),"GBK");){
			
			int temp;
			while((temp=is.read())!=-1) {//每个调用InputStreamReader的read（）方法之一可能会导致从底层字节输入流读取一个或多个字节。 为了使字节有效地转换为字符，可以从底层流读取比满足当前读取操作所需的更多字节。 
				System.out.print((char)temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


