package cn.qjq;
/**
 *ģ����Ʊ��վ 
 *������Դ
 *������ʱʱ���������ݴ���--��������----����Ҫ��֤�̰߳�ȫ
 * @author qjq
 *2019��11��18��11:47:13
 */
public class Web12306 implements Runnable{
	//ʣ��Ʊ��
	private int tickNum = 50;
	public void run() {
		while(true) {
			if(tickNum<0)
				break;
			/*try {//run�������������׳��쳣
				Thread.sleep(100);//�ӳ�100���룬ģ�������ӳ�  ���ݳ��ִ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			
		}
	}
	
	public static void main(String[] args) {
		//һ����Դ
		Web12306 web = new Web12306();
		Thread.currentThread().getName();//���߳�
		//�������
		new Thread(web,"С��").start();
		new Thread(web,"С��").start();
		new Thread(web,"С��").start();
	}
}
