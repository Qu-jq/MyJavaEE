package cn.qjq;
/**
 * �����̷߳�ʽ����
 * 1.������ʵ��Runnable+��дrun
 * 2.����������ʵ�������+Thread����+start
 * �Ƽ���
 * ���ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 * 
 * @author qjq
 *2019��11��18��10:04:45
 */
public class TestRun implements Runnable{
	/*
	 * �߳����
	 */
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("����д���룡");
		}
	}
	
	public static void main(String[] args) {
		/*//�����������
		TestRun tr = new TestRun();
		//����
		Thread t = new Thread(tr);
		t.start();//�������̣߳�ִ�н���cpu*/
		new Thread(new TestRun()).start();//�������� ---������ֻʹ��һ��ʱ��ʹ�ô˷���
		for(int i=0;i<20;i++) {
			System.out.println("�������裡");
		}
	}
}
