package cn.qjq.xc;
/**
 * 线程协作
 * 生产者消费者模式实现---管程法
 * 借助缓冲区
 * @author qjq
 *2019年11月23日16:21:13
 */
public class Cooperation01 {
	public static void main(String[] args) {
		SynContainers sc = new SynContainers();
		new Productor(sc).start();
		new Consumer(sc).start();
	}

}
//生产者
class Productor extends Thread{
	SynContainers sc;
	
	public Productor(SynContainers sc) {
		this.sc = sc;
	}

	public void run() {
		//停止生产
		
		for(int i=0;i<100;i++) {
			System.out.println("生产"+i+"馒头");
			sc.push(new Steamedbun(i));
		}

	}
}

//消费者
class Consumer extends Thread{
	SynContainers sc;
	public Consumer(SynContainers sc) {
		this.sc = sc;
	}
	public void run() {
		//消费
		for(int i=0;i<100;i++) {
			System.out.println("消费"+"馒头"+sc.pop().getId());
		}
	}
}
//缓冲区
class SynContainers{
	Steamedbun[] buns = new Steamedbun[10];
	int count = 0;
	
	public synchronized void push(Steamedbun s) {
		//存储  --生产
		if(count == buns.length) {
			try {
				this.wait();//线程阻塞。可以释放锁。消费者通知生产，解除阻塞
			} catch (InterruptedException e) {
			}
		}
			
	//容器存在空间时，可以生产
		buns[count] = s;
		count++;
		this.notifyAll();//存在资料啦，可以通知消费啦
	}

	//取出  --消费
	public synchronized Steamedbun pop() {
		//当缓存区空时，等待
		if(count==0) {
			try {
				this.wait();//线程阻塞。生产者通知消费，解除阻塞
			} catch (InterruptedException e) {
			}
		}
		//容器中有数据时，可以消费
		count--;
		this.notifyAll();//存在空间，可以通知生产了
		return buns[count];
		
	}
}
//面包  --资源
class Steamedbun{
	private int id;

	public Steamedbun(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}

