package cn.qjq.udp;
/**
 * ����������Ϣ  -- �˴���Ϊ���ն�
 * 1��DatagramSocket(int port) ָ���˿ں� �������ն�
 * 2��׼������  ��װ��DatagramPacket����  
 * DatagramPacket(byte[] buf, int offset, int length)
 * 3���Ӵ��׽��ֽ������ݱ���receive(DatagramPacket p)    ����ʽ����
 * 4����������
 * byte[] getData() �������ݻ������� 
 * getLength() ���յ������ݵĳ���
 * 5���ͷ���Դ
 * @author qjq
 *2019��11��25��11:17:36
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.sound.midi.Receiver;

public class udpTalkServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ������С�����");
		// 1��DatagramSocket(int port) ָ���˿ں� �������ն�
		DatagramSocket server = new DatagramSocket(9999);
		// 2��׼������  ��װ��DatagramPacket����  
		//DatagramPacket(byte[] buf, int offset, int length)
		while(true) {
			byte[] recDatas = new byte[1024*60];//���60k
			DatagramPacket recPacket = new DatagramPacket(recDatas,0,recDatas.length);
			// 3���Ӵ��׽��ֽ������ݱ���receive(DatagramPacket p)    ����ʽ����
			server.receive(recPacket);
			//4����������
			// byte[] getData() �������ݻ������� 
			// getLength() ���յ������ݵĳ���
			byte[] data = recPacket.getData();
			int len = data.length;
			String str2 = new String(data,0,len);
			System.out.println(str2);
			//�յ�byteʱ���˳�         --- ʧ�ܣ�����
			if(str2.equals("bye")) {
				break;
			}
		}
		//5���ͷ���Դ
		server.close();
	}
	

}