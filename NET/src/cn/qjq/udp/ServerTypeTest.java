package cn.qjq.udp;
/**
 * ������������   -- �˴���Ϊ���ն�
 * 1��DatagramSocket(int port) ָ���˿ں� �������ն�
 * 2��׼������  ��װ��DatagramPacket����  
 * DatagramPacket(byte[] buf, int offset, int length)
 * 3���Ӵ��׽��ֽ������ݱ���receive(DatagramPacket p)    ����ʽ����
 * 4����������
 * byte[] getData() �������ݻ������� 
 * getLength() ���յ������ݵĳ���
 * 5���ͷ���Դ
 * @author qjq
 *2019��11��26��13:05:47
 */

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.sound.midi.Receiver;

public class ServerTypeTest {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ������С�����");
		// 1��DatagramSocket(int port) ָ���˿ں� �������ն�
		DatagramSocket server = new DatagramSocket(9999);
		// 2��׼������  ��װ��DatagramPacket����  
		//DatagramPacket(byte[] buf, int offset, int length)
		byte[] recDatas = new byte[1024*60];//���60k
		DatagramPacket recPacket = new DatagramPacket(recDatas,0,recDatas.length);
		// 3���Ӵ��׽��ֽ������ݱ���receive(DatagramPacket p)    ����ʽ����
		server.receive(recPacket);
		//4����������
		// byte[] getData() �������ݻ������� 
		// getLength() ���յ������ݵĳ���
		byte[] data = recPacket.getData();
		//int len = data.length;
		ByteArrayInputStream is = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
		//˳����д��һ��
		int i = dis.readInt();
		boolean flag=dis.readBoolean();
		String s = dis.readUTF();
		char c = dis.readChar();
		System.out.println(s);
		System.out.println(flag);
		//5���ͷ���Դ
		server.close();
	}
}
