package cn.qjq.xc;
/**
 * 抢购电影票示例
 * 版本一：
 * 抢购几张票
 * 剩余几张票
 * @author qjq
 *2019年11月23日12:51:30
 */
public class HappyCinema {
	public static void main(String[] args) {
		Cinema c = new Cinema(20,"NanJ");
		new Thread(new Custumer(5,c),"小明").start();
		new Thread(new Custumer(3,c),"小花").start();
	}

}

class Custumer implements Runnable{
	private int seats;//需要的座位数
	private Cinema cinema;
	

	public Custumer(int seats, Cinema cinema) {
		this.seats = seats;
		this.cinema = cinema;
	}
	@Override
	public void run() {
		//同步块
		synchronized(cinema) {
			boolean flag = cinema.bookTicks(seats);
			if(flag) {
				System.out.println("订票成功"+"-->位置数量为："+seats);
			}else {
				System.out.println("出票失败"+"-->"+"位置不够");
			}
		
		}
		
	}
	
}

class Cinema{
	private int available;//剩余的位置
	private String name;//影院名字
	public Cinema(int available, String name) {
		this.available = available;
		this.name = name;
	}
	//购票
	public boolean bookTicks(int seats) {
		System.out.println("可用位置数："+available);
		if(available<seats) {
			return false;
		}else {
			available-=seats;
			return true;
		}
	}
	
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
}