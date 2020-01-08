package cn.qjq.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��¼ ˫�� ������    ---֪ͨ�ͻ��˵�¼�ɹ�����ʧ��
 * 1.ָ���˿ڣ�ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author qjq
 *2019��11��26��15:58:24
 */
public class LoginDoubleServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.ָ���˿ڣ�ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(9999);
		 //2.����ʽ�ȴ�����accept
		Socket client = server.accept();//����
		System.out.println("һ���ͻ��˽���������");
		 //3.�������������������
		//�������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		String[] dataArr = data.split("&");
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
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("qjq")&&psd.equals("123")) {//ʵ���ϴ�����Ӧ�ô����ݿ��������
			dos.writeUTF("��¼�ɹ�");
		}else {
			dos.writeUTF("�˻������������");
		}
		dos.flush();
		//4.�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
		server.close();//������һ��24h������һ�㲻��
	}

}
