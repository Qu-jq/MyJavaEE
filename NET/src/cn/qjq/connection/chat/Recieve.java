package cn.qjq.connection.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ��������̷�װ �� ����
 * 1��������Ϣ
 * 2���ͷ���Դ
 * 3������run
 * @author qjq
 *2019��11��29��14:41:11
 */
public class Recieve implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	//������
	public Recieve(Socket client) {
		this.isRunning = true;
		this.client=client;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			release();
		}
	}
	//����
	private String recieve() {
		String msg="";
		try {
			msg = dis.readUTF();
			return msg;
		} catch (IOException e) {
			release();
		}
		return null;
	}
	//�ͷ���Դ
	private void release() {
		this.isRunning = false;
		qjqUtils.close(dis,client);
	}
	@Override
	public void run() {
		String msg="";
		while(isRunning) {
			msg = recieve();
			if(!msg.equals(""))
				System.out.println(msg);
		}
		
	}

}