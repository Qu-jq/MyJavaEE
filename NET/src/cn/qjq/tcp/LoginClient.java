package cn.qjq.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 登录 单向  客户端
 * 1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author qjq
 *2019年11月26日15:58:19
 */
public class LoginClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String uname = br.readLine();
		System.out.println("请输入密码：");
		String psd = br.readLine();
		//1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
		Socket client = new Socket("localhost",9999);
		 //2.操作：输入输出流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"psd="+psd);
		dos.flush();
		//3.释放资源
		dos.close();
		br.close();
		client.close();
		
	}

}
