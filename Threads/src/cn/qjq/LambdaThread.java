package cn.qjq;
/**
 * 利用lambda简化线程
 * 用于简化简单的线程 接口中只有一个未实现的方法
 * @author qjq
 *2019年11月19日15:56:24
 */
public class LambdaThread{
	//静态内部类
	static class Test implements Runnable{
		public void run() {
			for(int i=0;i<20;i++) {
				System.out.println("正在写代码！");
			}
		}
	}
	

	public static void main(String[] args) {
		//静态内部类不使用不会调用，节省资源
		new Thread(new Test()).start();
		//局部内部类
		class Test2 implements Runnable{
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("正在写代码！");
				}
			}
		}
		new Thread(new Test2()).start();
		//用于简化简单的线程 接口中只有一个未实现的方法
		new Thread(()-> {
			for(int i=0;i<20;i++) {
				System.out.println("正在写代码！");
			}
			}).start();//匿名调用 ---当引用只使用一次时，使用此方法
	}	
}
