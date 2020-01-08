package cn.qjq.finals.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ң�  �ͻ���
 * ������汾��ʵ��˽��
 * 
 * @author qjq
 *2019��11��29��16:25:26
 */
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û����ƣ�");
		String name = br.readLine();
		//1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
		Socket client = new Socket("localhost",9999);
		 //2.�������������������
		new Thread(new Send(client,name)).start();
		new Thread(new Recieve(client)).start();
	
	}

}
