package cn.qjq.udp;
/**
 * 基本数据类型   -- 此处作为接收端
 * 1、DatagramSocket(int port) 指定端口号 创建接收端
 * 2、准备容器  封装成DatagramPacket包裹  
 * DatagramPacket(byte[] buf, int offset, int length)
 * 3、从此套接字接收数据报包receive(DatagramPacket p)    阻塞式接收
 * 4、分析数据
 * byte[] getData() 返回数据缓冲区。 
 * getLength() 接收到的数据的长度
 * 5、释放资源
 * @author qjq
 *2019年11月26日13:05:47
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
		System.out.println("接收方启动中。。。");
		// 1、DatagramSocket(int port) 指定端口号 创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		// 2、准备容器  封装成DatagramPacket包裹  
		//DatagramPacket(byte[] buf, int offset, int length)
		byte[] recDatas = new byte[1024*60];//最多60k
		DatagramPacket recPacket = new DatagramPacket(recDatas,0,recDatas.length);
		// 3、从此套接字接收数据报包receive(DatagramPacket p)    阻塞式接收
		server.receive(recPacket);
		//4、分析数据
		// byte[] getData() 返回数据缓冲区。 
		// getLength() 接收到的数据的长度
		byte[] data = recPacket.getData();
		//int len = data.length;
		ByteArrayInputStream is = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
		//顺序与写出一致
		int i = dis.readInt();
		boolean flag=dis.readBoolean();
		String s = dis.readUTF();
		char c = dis.readChar();
		System.out.println(s);
		System.out.println(flag);
		//5、释放资源
		server.close();
	}
}
