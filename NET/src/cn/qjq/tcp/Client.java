package cn.qjq.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ���
 * 1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author qjq
 *2019��11��26��15:58:19
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		//1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
		Socket client = new Socket("localhost",9999);
		 //2.�������������������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("hello");
		dos.flush();
		//3.�ͷ���Դ
		dos.close();
		client.close();
		
	}

}
