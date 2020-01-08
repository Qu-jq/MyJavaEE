package cn.qjq;
/**
 * 创建线程方式二：
 * 1.创建：实现Runnable+重写run
 * 2.启动：创建实现类对象+Thread对象+start
 * 推荐：
 * 避免单继承的局限性，优先使用接口
 * 方便共享资源
 * 
 * @author qjq
 *2019年11月18日10:04:45
 */
public class TestRun implements Runnable{
	/*
	 * 线程入口
	 */
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("正在写代码！");
		}
	}
	
	public static void main(String[] args) {
		/*//创建子类对象
		TestRun tr = new TestRun();
		//启动
		Thread t = new Thread(tr);
		t.start();//启动多线程，执行交给cpu*/
		new Thread(new TestRun()).start();//匿名调用 ---当引用只使用一次时，使用此方法
		for(int i=0;i<20;i++) {
			System.out.println("正在听歌！");
		}
	}
}
