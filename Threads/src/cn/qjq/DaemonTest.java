package cn.qjq;
/**
 * �ػ��̣߳���Ϊ�û��̷߳���ġ�jvmֹͣʱ���õȴ��ػ��̵߳�ֹͣ
 * Ĭ�϶�Ϊ�û��̣߳�jvmֻ�е��û��߳�ֹͣʱ�Ż�ֹͣ
 * @author qjq
 *2019��11��21��17:18:33
 */
public class DaemonTest {
	public static void main(String[] args) {
		new Thread(new Person()).start();
		Thread t = new Thread(new God());
		t.setDaemon(true);//����Ϊ�ػ��߳�
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