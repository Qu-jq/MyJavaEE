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
public class Server02 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server02 server = new Server02();
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
			
			//返回内容
			StringBuilder contents = new StringBuilder();
			contents.append("<html>");
			contents.append("<head>");
			contents.append("<title>");
			contents.append("服务器响应成功");
			contents.append("</title>");
			contents.append("</head>");
			contents.append("<body>");
			contents.append("我终于回来啦，哈哈哈哈。。。。");
			contents.append("</body>");
			contents.append("</html>");
			long size = contents.toString().getBytes().length;//一定是字节长度
			
			//1、响应行: HTTP/1.1 200 OK
			StringBuilder responseInfo = new StringBuilder();
			String blank = " ";
			String CRLF = "\r\n";//换行符
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);
			//2、响应头(最后一行存在空行):
			/*
			 Date:Mon,31Dec209904:25:57GMT
			Server:qjq Server/0.0.1;charset=GBK
			Content-type:text/html
			Content-length:39725426
			 */
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("qjq Server/0.0.1;charset=UTF-8").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length:").append(size).append(CRLF);
			responseInfo.append(CRLF);
			//3、正文
			responseInfo.append(contents.toString());
			//发送报文
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
	//关闭资源
	public void stop() {
		
	}

}
