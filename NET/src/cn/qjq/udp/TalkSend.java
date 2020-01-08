package cn.qjq.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送消息 使用面向对象封装
 * @author qjq
 *2019年11月26日14:21:17
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
		// 2、准备数据，转换成字节数组
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str;
			try {
				str = read.readLine();
				byte[] data = str.getBytes();
				 //3、准备容器  封装成DatagramPacket包裹  指定发送的地址端口
				//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
				 //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
				///InetSocketAddress(InetAddress addr, int port) 继承自SocketAddress
				DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress(toIP,toPort));
				// 4、从此套接字发送数据报包send(DatagramPacket p) 
				client.send(packet);
				//收到byte时，退出       
				if(str.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		 //5、释放资源
		client.close();

	}

}
