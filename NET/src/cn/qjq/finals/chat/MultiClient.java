package cn.qjq.finals.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 聊天室：  客户端
 * 第五个版本：实现私聊
 * 
 * @author qjq
 *2019年11月29日16:25:26
 */
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名称：");
		String name = br.readLine();
		//1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
		Socket client = new Socket("localhost",9999);
		 //2.操作：输入输出流操作
		new Thread(new Send(client,name)).start();
		new Thread(new Recieve(client)).start();
	
	}

}
