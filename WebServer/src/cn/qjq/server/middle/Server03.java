package cn.qjq.server.middle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：添加服务器响应
 * @author qjq
 *2019年12月2日10:45:36
 */
public class Server03 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server03 server = new Server03();
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
			
			//返回响应
			Response response = new Response(client);
			
			//只关注内容
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("服务器响应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("我终于回来啦，哈哈哈哈。。。。");
			response.print("</body>");
			response.print("</html>");
			//关注了状态码
			response.push2Browser(200);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
	//关闭资源
	public void stop() {
		
	}

}
