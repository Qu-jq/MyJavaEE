package cn.qjq;
/**
 * sleep模拟网络延时，增加出错的概率
 * @author qjq
 *2019年11月20日15:33:40
 */
public class BlockedSleep {
	public static void main(String[] args) {
		//一份资源
		Ticket web = new Ticket();
		Thread.currentThread().getName();//主线程
		//多个代理
		new Thread(web,"小花").start();
		new Thread(web,"小明").start();
		new Thread(web,"小米").start();
	}
}

class Ticket implements Runnable{
	//剩余票数
	private int tickNum = 90;
	public void run() {
		while(true) {
			if(tickNum<0)
				break;
			try {//run方法不能向外抛出异常
				Thread.sleep(100);//延迟100毫秒，模拟网络延迟  数据出现错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			
		}
	}
	
}
