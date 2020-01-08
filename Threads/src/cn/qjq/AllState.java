package cn.qjq;

import java.lang.Thread.State;

/**
 * 全部线程状态
 * @author qjq
 *2019年11月20日17:37:03
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
			//延时一下
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s = t.getState();
			System.out.println(s);
		}*/
		
		while(true) {
			int count = Thread.activeCount();//活动线程数
			if(count == 1)
				break;
			//延时一下
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
