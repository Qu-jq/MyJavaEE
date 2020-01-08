package cn.qjq;

import java.net.InetSocketAddress;

/**
 * �˿�
 * 1���������
 * 2��2���ֽ� 0-65535  UDP TCP
 * 3��ͬһЭ��˿ڲ��ܳ�ͻ
 * 4������˿�Խ��Խ��  ��ֹ��ͻ
 * InetSocketAddress
 * 1��������
 *  new InetSocketAddress(��ַ|����,�˿�);
 *  2������
 *  getAddress
 *  getHostName
 *  getPort
 * @author qjq
 *2019��11��24��15:58:58
 */
public class PortTest {
	public static void main(String[] args) {
		//�����˿�
		InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
		//LocalHost��127.0.0.1Ч����ͬ�����Բ�ϵͳ�����ļ�
		InetSocketAddress socketAddress2 = new InetSocketAddress("LocalHost",9000);
		System.out.println(socketAddress.getHostName());
		System.out.println(socketAddress.getAddress());
		System.out.println(socketAddress2.getHostName());
		System.out.println(socketAddress2.getAddress());
		System.out.println(socketAddress.getPort());
	}

}
