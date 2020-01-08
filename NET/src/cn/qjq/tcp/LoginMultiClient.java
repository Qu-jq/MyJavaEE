package cn.qjq.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���û���¼ ˫��  �ͻ���
 * 1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author qjq
 *2019��11��27��15:31:32
 */
public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		
		//1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
		Socket client = new Socket("localhost",9999);
		 //2.�������������������
		//���
		new Send(client).send();
		//����
		new Receive(client).receive();
		//3.�ͷ���Դ
		client.close();
		
	}
	static class Send{
		private DataOutputStream dos;
		private BufferedReader br;
		private String msg;
		public Send(Socket client) {
			try {
				dos = new DataOutputStream(client.getOutputStream());
				br = new BufferedReader(new InputStreamReader(System.in));
				Init();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void Init() {
			try {	
				System.out.println("�������û�����");
				String uname = br.readLine();
				System.out.println("���������룺");
				String psd = br.readLine();
				msg="uname="+uname+"&"+"psd="+psd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void send() {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	static class Receive{
		DataInputStream dis;
		public Receive(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void receive() {
			
			String data;
			try {
				data = dis.readUTF();
				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}

}
