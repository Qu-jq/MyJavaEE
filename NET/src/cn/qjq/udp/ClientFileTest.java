package cn.qjq.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 上传文件 --此处作为发送端（注意一次发送不能超过60k）
 * 1、DatagramSocket(int port) 指定端口号 创建发送端
 * 2、将文件转换成字节数组
 * 3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
 * DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
 * 4、从此套接字发送数据报包send(DatagramPacket p) 
 * 5、释放资源
 * @author qjq
 *2019年11月26日13:12:15
 */
public class ClientFileTest {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中。。。");
		 // 1、DatagramSocket(int port) 指定端口号 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		 // 2、准备数据，转换成字节数组
		byte[] data = IOFille.fileToArray("ball.png");
		 //3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
		//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
		 //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
		//InetSocketAddress(InetAddress addr, int port) 继承自SocketAddress
		DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress("localhost",9999));
		// 4、从此套接字发送数据报包send(DatagramPacket p) 
		client.send(packet);
		 //5、释放资源
		client.close();
	}

}
