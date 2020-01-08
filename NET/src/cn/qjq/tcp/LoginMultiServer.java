package cn.qjq.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *接收多用户登录  双向 服务器    ---通知客户端登录成功或者失败
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author qjq
 *2019年11月27日15:32:10
 */
public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(9999);
		 //2.阻塞式等待连接accept
		boolean isRunning = true;
		while(isRunning) {
			Socket client = server.accept();//阻塞
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
		server.close();//服务器一般24h工作，一般不关
	}
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		public Channel(Socket client) {
			this.client = client;
			try {
				//输入
				dis = new DataInputStream(client.getInputStream());
				//输出
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
			
		}
		
		public String receive() {
			String data="";
			try {
				data = dis.readUTF();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
		public void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void release() {
			//4.释放资源
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run() {
			//3.操作：输入输出流操作
			//输入操作
			String[] dataArr = receive().split("&");
			String uname = "";
			String psd = "";
			for(String str:dataArr) {
				String[] userInfo = str.split("=");
				if(userInfo[0].equals("uname")) {
					System.out.println("您的用户名为："+userInfo[1]);
					uname = userInfo[1];
				}else if(userInfo[0].equals("psd")) {
					System.out.println("您的密码为："+userInfo[1]);
					psd = userInfo[1];
				}
			}
			//输出操作
			
			if(uname.equals("qjq")&&psd.equals("123")) {//实际上次数据应该从数据库里面调用
				send("登录成功");
			}else {
				send("账户或者密码错误");
			}
		
			release();
		}
		
	}

}
