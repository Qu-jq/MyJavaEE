package cn.qjq;
/**
 * �߳���Ϣ��
 * setName:���ô����߳�����
 * getName����ȡ��������
 * currentThread����ǰ���߳�
 * isAlive���߳��Ƿ��Ծ
 * @author qjq
 *2019��11��21��17:33:25
 */
public class InfoTest {
	public static void main(String[] args) throws InterruptedException {
		MyInfo mi = new MyInfo("xiaoche");
		Thread t = new Thread(mi);
		t.setName("kache");
		t.start();
		Thread.sleep(100);
		System.out.println(t.isAlive());
	}

}
class MyInfo implements Runnable{
	private String name;//��ʵ����
	MyInfo(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
	
}
