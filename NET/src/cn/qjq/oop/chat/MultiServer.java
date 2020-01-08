package cn.qjq.oop.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ң�  ��������
 * �������汾�����˶���շ���Ϣ  oop��װ
 * 
 * @author qjq
 *2019��11��28��15:18:00
 */
public class MultiServer {
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
			new Thread(new Channel(client)).start();
		}
	}
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		//������
		public Channel(Socket client){
			this.isRunning = true;
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
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
		}
		@Override
		public void run() {
			while(isRunning) {
				String data;
				data = recieve();
				send(data);//�������	
			}
		}
	}

}
