package cn.qjq.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室：  服务器端
 * 第二个版本：多人多次收发信息
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
			new Thread(()->{
				DataInputStream dis = null;
				DataOutputStream dos = null;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				boolean isRunning = true;
				while(isRunning) {
					String data;
					try {
						data = dis.readUTF();
						dos.writeUTF(data);//输出操作
						dos.flush();
					} catch (IOException e) {
						isRunning = false;
					}	
				}
				//释放资源
				try {
					if(null != dos)
						dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null != dis)
						dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null != client)
						client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}).start();
			
		//释放资源
		//server.close();
		}
	}

}
