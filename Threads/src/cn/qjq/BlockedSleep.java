package cn.qjq;
/**
 * sleepģ��������ʱ�����ӳ���ĸ���
 * @author qjq
 *2019��11��20��15:33:40
 */
public class BlockedSleep {
	public static void main(String[] args) {
		//һ����Դ
		Ticket web = new Ticket();
		Thread.currentThread().getName();//���߳�
		//�������
		new Thread(web,"С��").start();
		new Thread(web,"С��").start();
		new Thread(web,"С��").start();
	}
}

class Ticket implements Runnable{
	//ʣ��Ʊ��
	private int tickNum = 90;
	public void run() {
		while(true) {
			if(tickNum<0)
				break;
			try {//run�������������׳��쳣
				Thread.sleep(100);//�ӳ�100���룬ģ�������ӳ�  ���ݳ��ִ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			
		}
	}
	
}
