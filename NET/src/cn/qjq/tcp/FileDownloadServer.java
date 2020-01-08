package cn.qjq.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件下载服务器
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author qjq
 *2019年11月26日15:58:24
 */
public class FileDownloadServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(9999);
		 //2.阻塞式等待连接accept
		Socket client = server.accept();//阻塞
		System.out.println("一个客户端建立了连接");
		 //3.操作：输入输出流操作
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("ball2.png"));
		byte[] flush = new byte[1024];
		int len=-1;
		while((len=is.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//4.释放资源
		os.close();
		is.close();
		client.close();
		server.close();//服务器一般24h工作，一般不关
	}

}
