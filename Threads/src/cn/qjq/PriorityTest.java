package cn.qjq;
/**
 * ���ȼ�
 * 1.MAX_PRIORITY  10  �߳̿���ӵ�е�������ȼ�
 * 2.MIN_PRIORITY  1   �߳̿���ӵ�е���С���ȼ���
 * 3.NORM_PRIORITY 5    ������̵߳�Ĭ�����ȼ���  
 * ���ȼ���ֻ��CPU���õĸ��ʴ�
 * @author qjq
 *2019��11��21��16:44:40
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());//Ĭ��Ϊ5
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