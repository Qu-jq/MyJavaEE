package cn.qjq.server.finals;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 分发器：加入404 505 和 首页的处理
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

		
		try {
			if(null == request.getUrl()||request.getUrl().equals("")) {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[] datas = is.readAllBytes();//数据量较小，可以一次全部读取
				response.print(new String(datas));
				response.push2Browser(200);
				is.close();
				this.release();//短连接，提高效率
				return;//后面的不执行
			}
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			if(null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.push2Browser(200);
			}else {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[] datas = is.readAllBytes();//数据量较小，可以一次全部读取
				response.print(new String(datas));
				is.close();
				response.push2Browser(404);
			}
		}catch(Exception e) {
			try {
				response.print("服务器出错啦，请等候修复");
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
