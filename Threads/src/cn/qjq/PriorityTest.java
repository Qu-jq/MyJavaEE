package cn.qjq;
/**
 * 优先级
 * 1.MAX_PRIORITY  10  线程可以拥有的最大优先级
 * 2.MIN_PRIORITY  1   线程可以拥有的最小优先级。
 * 3.NORM_PRIORITY 5    分配给线程的默认优先级。  
 * 优先级高只是CPU调用的概率大
 * @author qjq
 *2019年11月21日16:44:40
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());//默认为5
		MyPriority my = new MyPriority();
		Thread t1 = new Thread(my,"A");
		Thread t2 = new Thread(my,"B");
		Thread t3 = new Thread(my,"C");
		Thread t4 = new Thread(my,"D");
		Thread t5 = new Thread(my,"E");
		Thread t6 = new Thread(my,"F");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

}
class MyPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		Thread.yield();
	}
	
}