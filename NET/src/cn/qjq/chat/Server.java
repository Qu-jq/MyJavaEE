package cn.qjq.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ң�  ��������
 * ��һ���汾���Լ�����շ���Ϣ
 * 
 * @author qjq
 *2019��11��28��14:57:55
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		//1.ָ���˿ڣ�ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(9999);
		 //2.����ʽ�ȴ�����accept
		Socket client = server.accept();//����
		System.out.println("һ���ͻ��˽���������");
		 //3.�������������������
		//�������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		boolean isRunning = true;
		while(isRunning) {
			String data = dis.readUTF();
			//�������
			dos.writeUTF(data);
			dos.flush();
		}
		//�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
		server.close();
	}

}
