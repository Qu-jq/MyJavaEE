package cn.qjq.oop.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室：  服务器端
 * 第三个版本：多人多次收发信息  oop封装
 * 
 * @author qjq
 *2019年11月28日15:18:00
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		//1.指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(9999);
		
		 //3.操作：输入输出流操作
		//输入操作
		
		while(true) {
			 //2.阻塞式等待连接accept
			Socket client = server.accept();//阻塞
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
	}
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		//构造器
		public Channel(Socket client){
			this.isRunning = true;
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				release();//出现异常直接退出
			}
			
		}
		//发送消息
		private void send(String msg) {
			try {
				if(!msg.equals("")) {
					dos.writeUTF(msg);
					dos.flush();
				}
				
			} catch (IOException e) {
				release();
			}
		}
		//接收消息
		private String recieve() {
			String msg="";
			try {
				msg = dis.readUTF();
				return msg;
			} catch (IOException e) {
				release();
			}
			return null;
		}
		//释放资源
		private void release() {
			this.isRunning = false;
			qjqUtils.close(dos,dis,client);
		}
		@Override
		public void run() {
			while(isRunning) {
				String data;
				data = recieve();
				send(data);//输出操作	
			}
		}
	}

}
