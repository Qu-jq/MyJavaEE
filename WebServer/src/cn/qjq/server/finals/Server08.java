 package cn.qjq.server.finals;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标: 加入多线程，实现分发器
 * 
 * @author qjq
 *2019年12月4日14:11:42
 */
public class Server08 {
	private ServerSocket serverSocket ;
	private boolean isRunning = true;
	public static void main(String[] args) {
		Server08 server = new Server08();
		server.start();
	}
	//启动服务
	public void start() {
		
		try {
			serverSocket =  new ServerSocket(9999);
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败....");
			this.stop();
		}
		
	}
	//接受连接处理
	public void receive() {
		while(isRunning) {
			try {
				Socket client = serverSocket.accept();
				System.out.println("一个客户端建立了连接....");
				new Thread(new Dispatcher(client)).start();
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
	}
	//停止服务
	public void stop() {
		isRunning = false;
	}
}
