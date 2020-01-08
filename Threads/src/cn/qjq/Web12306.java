package cn.qjq;
/**
 *模拟抢票网站 
 *共享资源
 *出现延时时，出现数据错误--并发问题----》需要保证线程安全
 * @author qjq
 *2019年11月18日11:47:13
 */
public class Web12306 implements Runnable{
	//剩余票数
	private int tickNum = 50;
	public void run() {
		while(true) {
			if(tickNum<0)
				break;
			/*try {//run方法不能向外抛出异常
				Thread.sleep(100);//延迟100毫秒，模拟网络延迟  数据出现错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			
		}
	}
	
	public static void main(String[] args) {
		//一份资源
		Web12306 web = new Web12306();
		Thread.currentThread().getName();//主线程
		//多个代理
		new Thread(web,"小花").start();
		new Thread(web,"小明").start();
		new Thread(web,"小米").start();
	}
}
