package cn.qjq.udp;
/**
 * 接收文件   -- 此处作为接收端
 * 1、DatagramSocket(int port) 指定端口号 创建接收端
 * 2、准备容器  封装成DatagramPacket包裹  
 * DatagramPacket(byte[] buf, int offset, int length)
 * 3、从此套接字接收数据报包receive(DatagramPacket p)    阻塞式接收
 * 4、分析数据  将文件接收
 * byte[] getData() 返回数据缓冲区。 
 * getLength() 接收到的数据的长度
 * 5、释放资源
 * @author qjq
 *2019年11月26日13:12:28
 */

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.sound.midi.Receiver;

public class ServerFileTest {
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
		IOFille.arrayTOFile(data, "recpicture.png");
		//5、释放资源
		server.close();
	}
}
