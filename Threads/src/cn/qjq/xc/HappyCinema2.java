package cn.qjq.xc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 抢购电影票示例
 * 版本二：
 * 抢购哪个位置的票
 * 剩余哪个位置
 * @author qjq
 *2019年11月23日13:21:39
 */
public class HappyCinema2 {
	public static void main(String[] args) {
		List<Integer> available = new ArrayList<Integer>(Arrays.<Integer>asList(1,2,3,4,5,6));
		//availbale.addAll();
		available.add(7);
		List<Integer> seat1 = new ArrayList<Integer>();
		seat1.add(1);
		seat1.add(2);
		List<Integer> seat2 = new ArrayList<Integer>();
		seat2.add(3);
		seat2.add(4);
		NJCinema c = new NJCinema(available,"NanJ");
		Thread t1 = new Thread(new HappyCustumer(seat1,c),"小明");
		Thread t2 = new Thread(new HappyCustumer(seat2,c),"小花");
		t1.start();
		t2.start();
	}

}

class HappyCustumer implements Runnable{
	private List<Integer> seats;//需要的座位号数
	private NJCinema cinema;

	public HappyCustumer(List<Integer> seats, NJCinema cinema) {
		this.seats = seats;
		this.cinema = cinema;
	}
	@Override
	public void run() {
		//同步块
		synchronized(cinema) {
			boolean flag = cinema.bookTicks(seats);
			if(flag) {
				System.out.println(Thread.currentThread().getName()+"订票成功"+"-->位置数量为："+seats);
			}else {
				System.out.println(Thread.currentThread().getName()+"出票失败"+"-->"+"位置不够");
			}
		
		}
		
	}
	
}

class NJCinema{
	private List<Integer> available;//剩余的位置
	private String name;//影院名字
	public NJCinema(List<Integer> available, String name) {
		this.available = available;
		this.name = name;
	}
	//购票
	public boolean bookTicks(List<Integer> seats) {
		System.out.println("可用位置数："+available);
		List<Integer> copy = new ArrayList<Integer>();//备份操作数据
		copy.addAll(available);
		//List<Integer> copy = available;//错误  copy 和 available 引用相同。一个变化都变化
		copy.removeAll(seats);
		//System.out.println(copy);
		if(available.size()-copy.size()!=seats.size()) {
		//	System.out.println(available);
			return false;
		}else {
			available = copy;
			return true;
		}
	}
	
}