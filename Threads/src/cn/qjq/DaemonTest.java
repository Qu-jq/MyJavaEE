package cn.qjq;
/**
 * 守护线程：是为用户线程服务的。jvm停止时不用等待守护线程的停止
 * 默认都为用户线程，jvm只有当用户线程停止时才会停止
 * @author qjq
 *2019年11月21日17:18:33
 */
public class DaemonTest {
	public static void main(String[] args) {
		new Thread(new Person()).start();
		Thread t = new Thread(new God());
		t.setDaemon(true);//设置为守护线程
		t.start();
	}

}

class Person implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<365*100;i++) {
			System.out.println("live.....");
		}
	}
	
}

class God implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("God.....");
		}
	}
	
}