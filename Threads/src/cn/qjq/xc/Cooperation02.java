package cn.qjq.xc;
/**
 * 线程协作
 * 生产者消费者模式实现 方式二--信号灯法
 * 借助标志位
 * @author qjq
 *2019年11月23日18:48:32
 */
public class Cooperation02 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Actor(tv).start();
		new Watcher(tv).start();
	}

}
//演员
class Actor extends Thread{
	Tv tv;
	

	public Actor(Tv tv) {
		this.tv = tv;
	}

	public void run() {
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				tv.act("这是一条神奇的天路！");
			}else {
				tv.act("又累又辛苦！");
			}
		}

	}
	
}
//观众
class Watcher extends Thread{
	Tv tv;
	public Watcher(Tv tv) {
		this.tv = tv;
	}

	public void run() {
		for(int i=0;i<10;i++) {
			tv.listen();
		}
	}
}
//同一资源
class Tv{
	String voice;//声音
	//信号灯   T表示演员表演，观众等待    F表示观众观看，演员等待
	boolean flag = true;
	public synchronized void act(String voice){
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		//表演时刻
		this.voice=voice;
		System.out.println("演员唱："+voice);
		this.notifyAll();//通知观众听
		this.flag =!flag;//切换标志
	}
	
	public synchronized void listen(){
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("观众听见："+voice);
		this.notifyAll();//通知演员唱
		this.flag =!flag;//切换标志
	}
	
}

