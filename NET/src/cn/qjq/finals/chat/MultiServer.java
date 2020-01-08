package cn.qjq.finals.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 聊天室：  服务器端
 * 第五个版本：实现私聊
 * 
 * @author qjq
 *2019年11月29日16:25:34
 */
public class MultiServer {
	static List<Channel> all = new CopyOnWriteArrayList<Channel>();//多线程环境下推荐使用CopyOnWriteArrayList
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
			Channel channel = new Channel(client);
			all.add(channel);
			new Thread(channel).start();
		}
	}
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		//构造器
		public Channel(Socket client){
			this.isRunning = true;
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.name = recieve();
				this.send("欢迎你的到来！");
				sendOthers(this.name+"来到聊天室",true);
			} catch (IOException e) {
				release();//出现异常直接退出
			}
			
		}
		//发送消息
		private void send(String msg) {
			try {
				if(!msg.equals("")) {
					dos.writeUTF(msg);
					dos.flush();
				}
				
			} catch (IOException e) {
				release();
			}
		}
		/*
		 * 发送给其他人消息  分为系统发送 和 用户发送
		 * 实现私聊--》约定私聊数据格式：  @xxx:msg
		 */
		private void sendOthers(String msg,boolean isServer) {
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate) {
				int indx = msg.indexOf(":");
				String toName = msg.substring(1, indx);//左闭右开
				String info = msg.substring(indx+1);
				for(Channel c : all) {
					if(c.name.equals(toName)) {
						c.send(this.name+"悄悄对你说："+info);
						break;
					}
				}
			}else {
				for(Channel c : all) {
					if(c == this) {
						continue;
					}else {
						if(!isServer) {
							c.send(this.name+"对所有人说："+msg);
						}else {
							c.send(msg);//系统消息
						}
							
						
					}
			}
			}
		}
		//接收消息
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
			qjqUtils.close(dos,dis,client);
			all.remove(this);
			sendOthers(this.name+"退出聊天室", true);
		}
		@Override
		public void run() {
			String data;
			while(isRunning) {
				data = recieve();
				if(!data.equals("")) {
					sendOthers(data,false);//输出操作
				}
					
			}
		}
	}

}
