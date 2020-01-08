package cn.qjq.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��¼ ˫��  �ͻ���
 * 1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author qjq
 *2019��11��26��15:58:19
 */
public class LoginDoubleClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String uname = br.readLine();
		System.out.println("���������룺");
		String psd = br.readLine();
		//1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
		Socket client = new Socket("localhost",9999);
		 //2.�������������������
		//���
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"psd="+psd);
		dos.flush();
		//����
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		//3.�ͷ���Դ
		dis.close();
		dos.close();
		br.close();
		client.close();
		
	}

}
