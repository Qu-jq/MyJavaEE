package cn.qjq.udp;
/**
 * ģ��ѧ��
 * @author qjq
 *2019��11��26��14:36:19
 */
public class udpStudent {
	public static void main(String[] args) {
		//��������Ķ˿�Ϊ7777�����͵�9999
		new Thread(new TalkSend(7777,"localhost",9999)).start();
		//���ն˿�8888
		new Thread(new TalkRecieve(8888)).start();
	}

}
