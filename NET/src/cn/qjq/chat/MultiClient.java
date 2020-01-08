package cn.qjq.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 聊天室：  客户端
 * 第二个版本：多人自己多次收发信息
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		boolean isRunning = true;
		while(isRunning) {
			String msg = br.readLine();
			//输出
			dos.writeUTF(msg);
			dos.flush();
			//输入操作
			String data = dis.readUTF();
			System.out.println(data);
		}
		//释放资源
		dos.close();
		dis.close();
		client.close();
		
	}

}
