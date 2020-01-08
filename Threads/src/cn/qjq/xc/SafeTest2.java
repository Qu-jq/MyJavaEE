package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������  <---����ʹ��
 * 2.ͬ����
 * @author qjq
 *2019��11��22��16:37:40
 */
public class SafeTest2 implements Runnable{
	//ʣ��Ʊ��
		private int tickNum = 50;
		public void run() {
			test();
		}
		
		public static void main(String[] args) {
			//һ����Դ
			SafeTest2 web = new SafeTest2();
			Thread.currentThread().getName();//���߳�
			//�������
			new Thread(web,"С��").start();
			new Thread(web,"С��").start();
			new Thread(web,"С��").start();
		}	
		
		public synchronized void test() {
			while(true) {
				if(tickNum<=0)
					break;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
				
			}
		}
}
