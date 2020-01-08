package cn.qjq.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 基本数据类型 --此处作为发送端
 * 1、DatagramSocket(int port) 指定端口号 创建发送端
 * 2、准备数据，转换成字节数组
 * 3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
 * DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
 * 4、从此套接字发送数据报包send(DatagramPacket p) 
 * 5、释放资源
 * @author qjq
 *2019年11月26日13:14:36
 * @author qjq
 *
 */
public class ClientTypeTest {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中。。。");
		 // 1、DatagramSocket(int port) 指定端口号 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		 // 2、准备数据，转换成字节数组
		//写出
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
		//操作数据类型
		dos.writeInt(4);
		dos.writeBoolean(false);
		dos.writeUTF("字符类型");
		dos.writeChar('c');
		dos.flush();
		byte[] data = os.toByteArray();
		 //3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
		//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
		 //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
		///InetSocketAddress(InetAddress addr, int port) 继承自SocketAddress
		DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress("localhost",9999));
		// 4、从此套接字发送数据报包send(DatagramPacket p) 
		client.send(packet);
		 //5、释放资源
		client.close();
	}

}
