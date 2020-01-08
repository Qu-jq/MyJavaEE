package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 * 线程不安全：抢票出现负数，或者出现重复
 * @author qjq
 *2019年11月22日16:37:40
 */
public class UnsafeTest2 implements Runnable{
	//剩余票数
		private int tickNum = 50;
		public void run() {
			test();
		}
		
		public static void main(String[] args) {
			//一份资源
			UnsafeTest2 web = new UnsafeTest2();
			Thread.currentThread().getName();//主线程
			//多个代理
			new Thread(web,"小花").start();
			new Thread(web,"小明").start();
			new Thread(web,"小米").start();
		}	
		
		public void test() {
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
