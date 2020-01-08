package cn.qjq;

import java.lang.Thread.State;

/**
 * ȫ���߳�״̬
 * @author qjq
 *2019��11��20��17:37:03
 */
public class AllState {
	
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(int i=0;i<5;i++)
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("lambda....");
		});
		State s = t.getState();
		System.out.println(s);
		t.start();
		s = t.getState();
		System.out.println(s);
		/*while(t.getState()!=Thread.State.TERMINATED) {
			//��ʱһ��
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s = t.getState();
			System.out.println(s);
		}*/
		
		while(true) {
			int count = Thread.activeCount();//��߳���
			if(count == 1)
				break;
			//��ʱһ��
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s = t.getState();
			System.out.println(s);
		}
		
	}

}
