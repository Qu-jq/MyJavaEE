package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：操作容器
 *   synchronized
 * 1.同步方法 
 * 2.同步块  <---本例使用
 * @author qjq
 *2019年11月22日21:13:20
 */
public class SafeTest1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		for (int i=0;i<1000;i++) {
			new Thread(()->{
				//锁定list
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
		System.out.println(list.size());//结果总是小于1000，不安全
	}
}
