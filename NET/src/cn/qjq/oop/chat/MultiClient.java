package cn.qjq.oop.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 聊天室：  客户端
 * 第三个版本：多人自己多次收发信息 oop
 * 
 * @author qjq
 *2019年11月28日15:17:47
 */
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		//1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
		Socket client = new Socket("localhost",9999);
		 //2.操作：输入输出流操作
		new Thread(new Send(client)).start();
		new Thread(new Recieve(client)).start();
	
	}

}
