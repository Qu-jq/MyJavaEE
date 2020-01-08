package cn.qjq.oop.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ң�  �ͻ���
 * �������汾�������Լ�����շ���Ϣ oop
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
		new Thread(new Send(client)).start();
		new Thread(new Recieve(client)).start();
	
	}

}
