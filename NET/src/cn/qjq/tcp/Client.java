package cn.qjq.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端
 * 1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author qjq
 *2019年11月26日15:58:19
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		//1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
		Socket client = new Socket("localhost",9999);
		 //2.操作：输入输出流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("hello");
		dos.flush();
		//3.释放资源
		dos.close();
		client.close();
		
	}

}
