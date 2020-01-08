package cn.qjq.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室：  服务器端
 * 第一个版本：自己多次收发信息
 * 
 * @author qjq
 *2019年11月28日14:57:55
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		//1.指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(9999);
		 //2.阻塞式等待连接accept
		Socket client = server.accept();//阻塞
		System.out.println("一个客户端建立了连接");
		 //3.操作：输入输出流操作
		//输入操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		boolean isRunning = true;
		while(isRunning) {
			String data = dis.readUTF();
			//输出操作
			dos.writeUTF(data);
			dos.flush();
		}
		//释放资源
		dos.close();
		dis.close();
		client.close();
		server.close();
	}

}
