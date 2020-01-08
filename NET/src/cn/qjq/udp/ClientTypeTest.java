package cn.qjq.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ������������ --�˴���Ϊ���Ͷ�
 * 1��DatagramSocket(int port) ָ���˿ں� �������Ͷ�
 * 2��׼�����ݣ�ת�����ֽ�����
 * 3��׼������  ��װ��DatagramPacket����  ָ�����͵ĵ�ַ�˿�
 * DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
 * 4���Ӵ��׽��ַ������ݱ���send(DatagramPacket p) 
 * 5���ͷ���Դ
 * @author qjq
 *2019��11��26��13:14:36
 * @author qjq
 *
 */
public class ClientTypeTest {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ������С�����");
		 // 1��DatagramSocket(int port) ָ���˿ں� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		 // 2��׼�����ݣ�ת�����ֽ�����
		//д��
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
		//������������
		dos.writeInt(4);
		dos.writeBoolean(false);
		dos.writeUTF("�ַ�����");
		dos.writeChar('c');
		dos.flush();
		byte[] data = os.toByteArray();
		 //3��׼������  ��װ��DatagramPacket����  ָ�����͵ĵ�ַ�˿�
		//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
		 //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
		///InetSocketAddress(InetAddress addr, int port) �̳���SocketAddress
		DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress("localhost",9999));
		// 4���Ӵ��׽��ַ������ݱ���send(DatagramPacket p) 
		client.send(packet);
		 //5���ͷ���Դ
		client.close();
	}

}
