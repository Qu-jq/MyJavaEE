package cn.qjq.server.middle;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：使用serversocket建立与服务器的连接，获取请求协议
 * @author qjq
 *2019年12月2日10:02:54
 */
public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
	//开始 建立服务器
	public void start() {
		//建立一个服务器
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器建立失败");
		}
	}
	//接收内容
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			//获取请求协议
			InputStream is = client.getInputStream();
			byte[] flush = new byte[1024*1024];
			int len = is.read(flush);
			String datas = new String(flush, 0, len);
			System.out.println(datas);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
	//关闭资源
	public void stop() {
		
	}

}
