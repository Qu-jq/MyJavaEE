package cn.qjq.udp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 通过键盘输入持续发送数据  --此处作为发送端
 * 1、DatagramSocket(int port) 指定端口号 创建发送端
 * 2、准备数据，转换成字节数组
 * 3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
 * DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
 * 4、从此套接字发送数据报包send(DatagramPacket p) 
 * 5、释放资源
 * @author qjq
 *2019年11月26日14:50:59
 */
public class udpTalkClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中。。。");
		 // 1、DatagramSocket(int port) 指定端口号 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		 // 2、准备数据，转换成字节数组
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = read.readLine();
			byte[] data = str.getBytes();
			 //3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
			//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
			 //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
			///InetSocketAddress(InetAddress addr, int port) 继承自SocketAddress
			DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress("localhost",9999));
			// 4、从此套接字发送数据报包send(DatagramPacket p) 
			client.send(packet);
			//收到byte时，退出          
			if(str.equals("bye")) {
				break;
			}
		}
		 //5、释放资源
		client.close();
	}

}
