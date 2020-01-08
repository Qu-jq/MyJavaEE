package cn.qjq.oop.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 面向对象编程封装 ： 发送
 * 1、发送消息
 * 2、从控制台获取消息
 * 3、释放资源
 * 4、重新run
 * @author qjq
 *2019年11月29日14:41:11
 */
public class Send implements Runnable{
	private BufferedReader br;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	//构造器
	public Send(Socket client) {
		this.isRunning = true;
		this.client=client;
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			release();
		}
	}
	//发送
	private void send(String msg) {
		try {
			//if(!msg.equals("")) {
			dos.writeUTF(msg);
			dos.flush();
			
		} catch (IOException e) {
			release();
		}
		
	}
	//控制台读取消息
	private String getMsg() {
		String msg="";
		try {
			msg = br.readLine();
			return msg;
		} catch (IOException e) {
			release();
		}
		return null;
	}
	//释放资源
	private void release() {
		this.isRunning = false;
		qjqUtils.close(dos,client);
	}
	@Override
	public void run() {
		while(isRunning) {
			send(getMsg());
		}
		
	}

}
