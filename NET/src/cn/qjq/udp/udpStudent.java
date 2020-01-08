package cn.qjq.udp;
/**
 * 模拟学生
 * @author qjq
 *2019年11月26日14:36:19
 */
public class udpStudent {
	public static void main(String[] args) {
		//程序自身的端口为7777，发送到9999
		new Thread(new TalkSend(7777,"localhost",9999)).start();
		//接收端口8888
		new Thread(new TalkRecieve(8888)).start();
	}

}
