package cn.qjq.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ������Ϣ ʹ����������װ
 * @author qjq
 *2019��11��26��14:21:17
 */
public class TalkSend implements Runnable{
	private DatagramSocket client;
	private String toIP;
	private int toPort;
	public TalkSend(int port,String toIP,int toPort){
		try {
			client = new DatagramSocket(port);
			this.toIP=toIP;
			this.toPort=toPort;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		// 2��׼�����ݣ�ת�����ֽ�����
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str;
			try {
				str = read.readLine();
				byte[] data = str.getBytes();
				 //3��׼������  ��װ��DatagramPacket����  ָ�����͵ĵ�ַ�˿�
				//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
				 //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
				///InetSocketAddress(InetAddress addr, int port) �̳���SocketAddress
				DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress(toIP,toPort));
				// 4���Ӵ��׽��ַ������ݱ���send(DatagramPacket p) 
				client.send(packet);
				//�յ�byteʱ���˳�       
				if(str.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		 //5���ͷ���Դ
		client.close();

	}

}
