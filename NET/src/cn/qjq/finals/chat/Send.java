package cn.qjq.finals.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ��������̷�װ �� ����
 * 1��������Ϣ
 * 2���ӿ���̨��ȡ��Ϣ
 * 3���ͷ���Դ
 * 4������run
 * @author qjq
 *2019��11��29��14:41:11
 */
public class Send implements Runnable{
	private BufferedReader br;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	//������
	public Send(Socket client,String name) {
		this.isRunning = true;
		this.client=client;
		this.name = name;
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());
			send(name);//�����ַ��ͷ����
		} catch (IOException e) {
			release();
		}
	}
	//����
	private void send(String msg) {
		try {
			if(!msg.equals("")) {
				dos.writeUTF(msg);
				dos.flush();
			}
			
		} catch (IOException e) {
			release();
		}
		
	}
	//����̨��ȡ��Ϣ
	private String getMsg() {
		String msg="";
		try {
			msg = br.readLine();
			return msg;
		} catch (IOException e) {
			release();
		}
		return null;
	}
	//�ͷ���Դ
	private void release() {
		this.isRunning = false;
		qjqUtils.close(dos,client);
	}
	@Override
	public void run() {
		while(isRunning) {
			send(getMsg());
		}
		
	}

}
