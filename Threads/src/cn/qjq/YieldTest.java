package cn.qjq;
/**
 * yield �����߳�  ֱ�ӻص�����״̬ ����������״̬
 * @author qjq
 *2019��11��20��16:29:45
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