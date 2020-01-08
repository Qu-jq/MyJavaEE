package cn.qjq.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 多用户登录 双向  客户端
 * 1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author qjq
 *2019年11月27日15:31:32
 */
public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		
		//1.指定端口，使用Socket创建客户端  面向连接 指定服务器地址 端口
		Socket client = new Socket("localhost",9999);
		 //2.操作：输入输出流操作
		//输出
		new Send(client).send();
		//输入
		new Receive(client).receive();
		//3.释放资源
		client.close();
		
	}
	static class Send{
		private DataOutputStream dos;
		private BufferedReader br;
		private String msg;
		public Send(Socket client) {
			try {
				dos = new DataOutputStream(client.getOutputStream());
				br = new BufferedReader(new InputStreamReader(System.in));
				Init();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void Init() {
			try {	
				System.out.println("请输入用户名：");
				String uname = br.readLine();
				System.out.println("请输入密码：");
				String psd = br.readLine();
				msg="uname="+uname+"&"+"psd="+psd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void send() {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	static class Receive{
		DataInputStream dis;
		public Receive(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void receive() {
			
			String data;
			try {
				data = dis.readUTF();
				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}

}
