package cn.qjq;
/**
 * �����̷߳�ʽһ��
 * 1.�������̳�Thread����дrun
 * 2.�����������������+start
 * @author qjq
 *2019��11��18��10:04:45
 */
public class TestStart01 extends Thread{
	/*
	 * �߳����
	 */
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("����д���룡");
		}
	}
	
	public static void main(String[] args) {
		//�����������
		TestStart01 ts = new TestStart01();
		//����
		ts.start();//�������̣߳�ִ�н���cpu
		//ts.run();//��ͨ����
		for(int i=0;i<20;i++) {
			System.out.println("�������裡");
		}
	}

}
