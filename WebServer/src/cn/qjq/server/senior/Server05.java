package cn.qjq.server.senior;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标: 加入servlet 解耦了业务代码
 * 
 * @author qjq
 *2019年12月3日16:12:46
 */
public class Server05 {
	private ServerSocket serverSocket ;
	public static void main(String[] args) {
		Server05 server = new Server05();
		server.start();
	}
	//启动服务
	public void start() {
		try {
			serverSocket =  new ServerSocket(8888);
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败....");
		}
	}
	//接受连接处理
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接....");
			//获取请求协议
			Request request =new Request(client);
			//获取响应协议
			Response response =new Response(client);
			Servlet servlet = null;
			if(request.getUrl().equals("login")) {
				servlet = new LoginServlet();
				servlet.service(request, response);
			}else if(request.getUrl().equals("reg")) {
				servlet = new RegisterServlet();
				servlet.service(request, response);
			}else {
				//添加内容
			}
			//关注了状态码
			response.push2Browser(200);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	//停止服务
	public void stop() {
		
	}
}
