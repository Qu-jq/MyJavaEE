package cn.qjq;
/**
 * 线程信息：
 * setName:设置代理线程名字
 * getName：获取代理名字
 * currentThread：当前的线程
 * isAlive：线程是否活跃
 * @author qjq
 *2019年11月21日17:33:25
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
	private String name;//真实名字
	MyInfo(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
	
}
