package cn.qjq.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author qjq
 *2019年11月26日15:58:24
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(9999);
		 //2.阻塞式等待连接accept
		Socket client = server.accept();//阻塞
		System.out.println("一个客户端建立了连接");
		 //3.操作：输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		//4.释放资源
		dis.close();
		client.close();
		server.close();//服务器一般24h工作，一般不关
	}

}
