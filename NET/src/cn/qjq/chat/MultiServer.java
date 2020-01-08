package cn.qjq.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ң�  ��������
 * �ڶ����汾�����˶���շ���Ϣ
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
			new Thread(()->{
				DataInputStream dis = null;
				DataOutputStream dos = null;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				boolean isRunning = true;
				while(isRunning) {
					String data;
					try {
						data = dis.readUTF();
						dos.writeUTF(data);//�������
						dos.flush();
					} catch (IOException e) {
						isRunning = false;
					}	
				}
				//�ͷ���Դ
				try {
					if(null != dos)
						dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null != dis)
						dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null != client)
						client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}).start();
			
		//�ͷ���Դ
		//server.close();
		}
	}

}
