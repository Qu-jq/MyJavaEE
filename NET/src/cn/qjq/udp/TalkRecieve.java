package cn.qjq.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收消息   使用面向对象封装
 * @author qjq
 *2019年11月26日14:21:17
 */
public class TalkRecieve implements Runnable{

	private DatagramSocket server;
	//用于接收的端口
	public TalkRecieve(int recPort) {
		try {
			this.server= new DatagramSocket(recPort);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			byte[] recDatas = new byte[1024*60];//最多60k
			DatagramPacket recPacket = new DatagramPacket(recDatas,0,recDatas.length);
			// 3、从此套接字接收数据报包receive(DatagramPacket p)    阻塞式接收
			try {
				server.receive(recPacket);
				byte[] data = recPacket.getData();
				int len = data.length;//4、分析数据
				String str = new String(data,0,len,"gbk");
				System.out.println(str);
				//收到byte时，退出         --- 失败！！！
				if(str.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//5、释放资源
		server.close();
	}
	

}
