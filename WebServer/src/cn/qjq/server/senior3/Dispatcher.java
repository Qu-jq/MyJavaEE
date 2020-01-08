package cn.qjq.server.senior3;

import java.io.IOException;
import java.net.Socket;

/**
 * 分发器
 * @author qjq
 *2019年12月4日14:12:34
 */
public class Dispatcher implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			//获取请求协议
			request =new Request(client);
			//获取响应协议
			response =new Response(client);
		} catch (IOException e) {
			this.release();	
		}
		
	}

	@Override
	public void run() {

		Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
		try {
			if(null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.push2Browser(200);
			}else {
				response.push2Browser(404);
			}
		}catch(Exception e) {
			try {
				response.push2Browser(500);//服务器出现问题
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		this.release();//短连接，提高效率
	}
	
	private void release() {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
