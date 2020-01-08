package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ��������
 * @author qjq
 *2019��11��23��14:41:51
 */
public class SynContainer {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for (int i=0;i<1000;i++) {
			new Thread(()->{
			list.add(Thread.currentThread().getName());	
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
