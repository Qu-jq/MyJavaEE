package cn.qjq.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ������Ϣ   ʹ����������װ
 * @author qjq
 *2019��11��26��14:21:17
 */
public class TalkRecieve implements Runnable{

	private DatagramSocket server;
	//���ڽ��յĶ˿�
	public TalkRecieve(int recPort) {
		try {
			this.server= new DatagramSocket(recPort);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			byte[] recDatas = new byte[1024*60];//���60k
			DatagramPacket recPacket = new DatagramPacket(recDatas,0,recDatas.length);
			// 3���Ӵ��׽��ֽ������ݱ���receive(DatagramPacket p)    ����ʽ����
			try {
				server.receive(recPacket);
				byte[] data = recPacket.getData();
				int len = data.length;//4����������
				String str = new String(data,0,len,"gbk");
				System.out.println(str);
				//�յ�byteʱ���˳�         --- ʧ�ܣ�����
				if(str.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//5���ͷ���Դ
		server.close();
	}
	

}
