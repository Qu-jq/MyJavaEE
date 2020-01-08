package cn.qjq.udp;
/**
 * 模拟老师
 * @author qjq
 *2019年11月26日14:36:04
 */
public class udpTeacher {
	public static void main(String[] args) {
		//程序自身的端口为6666，发送到8888
		new Thread(new TalkSend(6666,"localhost",8888)).start();
		//接收端口9999
		new Thread(new TalkRecieve(9999)).start();
	}

}
