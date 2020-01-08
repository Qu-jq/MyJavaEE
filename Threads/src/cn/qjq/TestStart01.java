package cn.qjq;
/**
 * 创建线程方式一：
 * 1.创建：继承Thread，重写run
 * 2.启动：创建子类对象+start
 * @author qjq
 *2019年11月18日10:04:45
 */
public class TestStart01 extends Thread{
	/*
	 * 线程入口
	 */
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("正在写代码！");
		}
	}
	
	public static void main(String[] args) {
		//创建子类对象
		TestStart01 ts = new TestStart01();
		//启动
		ts.start();//启动多线程，执行交给cpu
		//ts.run();//普通调用
		for(int i=0;i<20;i++) {
			System.out.println("正在听歌！");
		}
	}

}
