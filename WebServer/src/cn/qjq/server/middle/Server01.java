package cn.qjq.server.middle;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ŀ�꣺ʹ��serversocket����������������ӣ���ȡ����Э��
 * @author qjq
 *2019��12��2��10:02:54
 */
public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
	//��ʼ ����������
	public void start() {
		//����һ��������
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��");
		}
	}
	//��������
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("һ���ͻ��˽���������");
			//��ȡ����Э��
			InputStream is = client.getInputStream();
			byte[] flush = new byte[1024*1024];
			int len = is.read(flush);
			String datas = new String(flush, 0, len);
			System.out.println(datas);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}
	//�ر���Դ
	public void stop() {
		
	}

}
