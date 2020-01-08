package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

/**
 * �̰߳�ȫ����������
 *   synchronized
 * 1.ͬ������ 
 * 2.ͬ����  <---����ʹ��
 * @author qjq
 *2019��11��22��21:13:20
 */
public class SafeTest1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		for (int i=0;i<1000;i++) {
			new Thread(()->{
				//����list
			synchronized(list) {
				list.add(Thread.currentThread().getName());	
			}
			}).start();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());//�������С��1000������ȫ
	}
}
