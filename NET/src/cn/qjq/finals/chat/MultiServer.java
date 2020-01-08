package cn.qjq.finals.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �����ң�  ��������
 * ������汾��ʵ��˽��
 * 
 * @author qjq
 *2019��11��29��16:25:34
 */
public class MultiServer {
	static List<Channel> all = new CopyOnWriteArrayList<Channel>();//���̻߳������Ƽ�ʹ��CopyOnWriteArrayList
	public static void main(String[] args) throws IOException {
		
		System.out.println("------Server------");
		//1.ָ���˿ڣ�ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(9999);
		
		 //3.�������������������
		//�������
		
		while(true) {
			 //2.����ʽ�ȴ�����accept
			Socket client = server.accept();//����
			System.out.println("һ���ͻ��˽���������");
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
		//������
		public Channel(Socket client){
			this.isRunning = true;
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.name = recieve();
				this.send("��ӭ��ĵ�����");
				sendOthers(this.name+"����������",true);
			} catch (IOException e) {
				release();//�����쳣ֱ���˳�
			}
			
		}
		//������Ϣ
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
		 * ���͸���������Ϣ  ��Ϊϵͳ���� �� �û�����
		 * ʵ��˽��--��Լ��˽�����ݸ�ʽ��  @xxx:msg
		 */
		private void sendOthers(String msg,boolean isServer) {
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate) {
				int indx = msg.indexOf(":");
				String toName = msg.substring(1, indx);//����ҿ�
				String info = msg.substring(indx+1);
				for(Channel c : all) {
					if(c.name.equals(toName)) {
						c.send(this.name+"���Ķ���˵��"+info);
						break;
					}
				}
			}else {
				for(Channel c : all) {
					if(c == this) {
						continue;
					}else {
						if(!isServer) {
							c.send(this.name+"��������˵��"+msg);
						}else {
							c.send(msg);//ϵͳ��Ϣ
						}
							
						
					}
			}
			}
		}
		//������Ϣ
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
		//�ͷ���Դ
		private void release() {
			this.isRunning = false;
			qjqUtils.close(dos,dis,client);
			all.remove(this);
			sendOthers(this.name+"�˳�������", true);
		}
		@Override
		public void run() {
			String data;
			while(isRunning) {
				data = recieve();
				if(!data.equals("")) {
					sendOthers(data,false);//�������
				}
					
			}
		}
	}

}
