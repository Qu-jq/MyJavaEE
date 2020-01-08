package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 * 测试效率
 * 线程安全：在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author qjq
 *2019年11月22日16:37:40
 *shift+tab往左缩进  哈哈，才知道
 */
public class SynBlockTest{
	public static void main(String[] args) {
		//一份资源
		GetTickNum web = new GetTickNum();
		Thread.currentThread().getName();//主线程
		//多个代理
		new Thread(web,"小花").start();
		new Thread(web,"小明").start();
		new Thread(web,"小米").start();
	}	
}
class GetTickNum implements Runnable{
	//剩余票数
	private int tickNum = 50;
	private Boolean flag=true;
	public void run() {
		while(flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test4();
		}
		
	}
	//线程安全：尽可能的锁定合理的范围（不是指代码的范围，指数据的完整性）
	public  void test5() {
		if(tickNum<=0) {//考虑没有票的情况
			flag=false;
			return;
		}
		synchronized(this) {
			while(flag) {
				if(tickNum<=0) {//考虑只剩一张票的情况
					flag=false;
					return;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			}
		}
	}
	//锁定范围小   锁定的对象不应该变  ---但此时数据是正确的，很奇怪！！！
	public  void test4() {
		synchronized((Integer)tickNum) {
			while(flag) {
				if(tickNum<=0) {
					flag=false;
					return;
				}
					
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
				
			}
		}
	}
	//方法块   锁定的对象不应该变  ---但此时数据是正确的，很奇怪！！！
		public void test3() {
			synchronized((Integer)tickNum) {
				while(tickNum>0) {
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
	//方法块   但此时与同步方法效率相同
	public  void test2() {
		synchronized(this) {
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
	
	//同步方法
	public synchronized void test1() {
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
	public  void test() {
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
