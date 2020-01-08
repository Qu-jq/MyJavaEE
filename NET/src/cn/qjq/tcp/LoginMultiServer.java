package cn.qjq.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *���ն��û���¼  ˫�� ������    ---֪ͨ�ͻ��˵�¼�ɹ�����ʧ��
 * 1.ָ���˿ڣ�ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author qjq
 *2019��11��27��15:32:10
 */
public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.ָ���˿ڣ�ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(9999);
		 //2.����ʽ�ȴ�����accept
		boolean isRunning = true;
		while(isRunning) {
			Socket client = server.accept();//����
			System.out.println("һ���ͻ��˽���������");
			new Thread(new Channel(client)).start();
		}
		server.close();//������һ��24h������һ�㲻��
	}
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		public Channel(Socket client) {
			this.client = client;
			try {
				//����
				dis = new DataInputStream(client.getInputStream());
				//���
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
			
		}
		
		public String receive() {
			String data="";
			try {
				data = dis.readUTF();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
		public void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void release() {
			//4.�ͷ���Դ
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run() {
			//3.�������������������
			//�������
			String[] dataArr = receive().split("&");
			String uname = "";
			String psd = "";
			for(String str:dataArr) {
				String[] userInfo = str.split("=");
				if(userInfo[0].equals("uname")) {
					System.out.println("�����û���Ϊ��"+userInfo[1]);
					uname = userInfo[1];
				}else if(userInfo[0].equals("psd")) {
					System.out.println("��������Ϊ��"+userInfo[1]);
					psd = userInfo[1];
				}
			}
			//�������
			
			if(uname.equals("qjq")&&psd.equals("123")) {//ʵ���ϴ�����Ӧ�ô����ݿ��������
				send("��¼�ɹ�");
			}else {
				send("�˻������������");
			}
		
			release();
		}
		
	}

}
