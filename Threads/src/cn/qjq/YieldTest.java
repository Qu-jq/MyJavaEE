package cn.qjq;
/**
 * yield 礼让线程  直接回到就绪状态 而不是阻塞状态
 * @author qjq
 *2019年11月20日16:29:45
 */
public class YieldTest {
	public static void main(String[] args) {
		MyYield my = new MyYield();
		new Thread(my,"A").start();
		new Thread(my,"B").start();
		
	}

}
class MyYield implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"beginning...");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"endding...");
	}
}