package cn.qjq.connection.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 面向对象编程封装 ： 接收
 * 1、接收消息
 * 2、释放资源
 * 3、重新run
 * @author qjq
 *2019年11月29日14:41:11
 */
public class Recieve implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	//构造器
	public Recieve(Socket client) {
		this.isRunning = true;
		this.client=client;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			release();
		}
	}
	//接收
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
		qjqUtils.close(dis,client);
	}
	@Override
	public void run() {
		String msg="";
		while(isRunning) {
			msg = recieve();
			if(!msg.equals(""))
				System.out.println(msg);
		}
		
	}

}