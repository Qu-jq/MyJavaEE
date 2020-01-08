package cn.qjq;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机输入输出流 RandomAccessFile
 * 新方法：
 * 		seek()  -- >定义从哪个字节开始读
 * @author qjq
 *2019年11月14日14:48:19
 */
public class RadomStream {
	public static void main(String[] args) throws IOException {
		 File src = new File("src/cn/qjq/copy.java");
		 //文件总长度
		 long len = src.length();
		//每块大小
		 int blockSize = 1024;
		 //块数
		 int size = (int)Math.ceil(len*1.0/blockSize);
		 int startPos = 0;//起始位置
		 int ActulSize = (int)(blockSize>len?len:blockSize);//需读取数据量
		 for(int i=0;i<size;i++) {
			 startPos = i*blockSize;
			 if(i==size-1) {//最后一块
				 ActulSize = (int) len;//最后剩下的量
			 }else {
				 ActulSize = blockSize;
				 len -= ActulSize;//剩余量
			 }
			 System.out.println(i+"-->"+startPos+"-->"+ActulSize);
			 plit( i, startPos, ActulSize);
		 }
		 
		 
	}
	/*
	 * 起始位置和读取量 第几块
	 */
	public static void plit(int i,int startPos,int ActulSize) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("src/cn/qjq/copy.java"),"r");
		 byte[] flush = new byte[1024];
		 int len;
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 if(ActulSize>len) {
				System.out.println(new String(flush,0,len)); 
				ActulSize -= len; 
			 }else {
				 System.out.println(new String(flush,0,ActulSize)); 
				 break;
			 }
			
		 }
		 raf.close();
	}
	/*
	 * 起始位置和读取量
	 */
	public static void test02() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("src/cn/qjq/copy.java"),"r");
		 byte[] flush = new byte[1024];
		 int len;
		 int startPos = 2;//起始位置
		 int ActulSize = 1026;//需读取数据量
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 if(ActulSize>len) {
				System.out.println(new String(flush,0,len)); 
				ActulSize -= len; 
			 }else {
				 System.out.println(new String(flush,0,ActulSize));
				 break;
			 }
			
		 }
		 raf.close();
	}
	/*
	 * 从第一个字节读取
	 */
	public static void test01() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("src/cn/qjq/copy.java"),"r");
		 byte[] flush = new byte[1024];
		 int len;
		 int startPos = 2;//起始位置
		 raf.seek(startPos);
		 while((len=raf.read(flush))!=-1) {
			 System.out.println(new String(flush,0,len));
		 }
		 raf.close();
	}

}
