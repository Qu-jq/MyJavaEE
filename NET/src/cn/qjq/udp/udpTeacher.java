package cn.qjq.udp;
/**
 * ģ����ʦ
 * @author qjq
 *2019��11��26��14:36:04
 */
public class udpTeacher {
	public static void main(String[] args) {
		//��������Ķ˿�Ϊ6666�����͵�8888
		new Thread(new TalkSend(6666,"localhost",8888)).start();
		//���ն˿�9999
		new Thread(new TalkRecieve(9999)).start();
	}

}
