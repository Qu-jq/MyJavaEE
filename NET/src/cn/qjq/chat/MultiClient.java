package cn.qjq.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ң�  �ͻ���
 * �ڶ����汾�������Լ�����շ���Ϣ
 * 
 * @author qjq
 *2019��11��28��15:17:47
 */
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		//1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
		Socket client = new Socket("localhost",9999);
		 //2.�������������������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		boolean isRunning = true;
		while(isRunning) {
			String msg = br.readLine();
			//���
			dos.writeUTF(msg);
			dos.flush();
			//�������
			String data = dis.readUTF();
			System.out.println(data);
		}
		//�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
		
	}

}
