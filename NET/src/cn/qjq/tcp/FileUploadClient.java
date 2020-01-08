package cn.qjq.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 文件上传客户端  --TCP无传输大小限制
 * 1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author qjq
 *2019年11月26日15:58:19
 */
public class FileUploadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		//1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
		Socket client = new Socket("localhost",9999);
		 //2.操作：输入输出流操作
		InputStream is = new BufferedInputStream(new FileInputStream("ball.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len=-1;
		while((len=is.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//3.释放资源
		os.close();
		is.close();
		client.close();
	}

}
