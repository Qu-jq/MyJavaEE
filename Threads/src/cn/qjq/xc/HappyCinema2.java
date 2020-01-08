package cn.qjq.xc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ������ӰƱʾ��
 * �汾����
 * �����ĸ�λ�õ�Ʊ
 * ʣ���ĸ�λ��
 * @author qjq
 *2019��11��23��13:21:39
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
		Thread t1 = new Thread(new HappyCustumer(seat1,c),"С��");
		Thread t2 = new Thread(new HappyCustumer(seat2,c),"С��");
		t1.start();
		t2.start();
	}

}

class HappyCustumer implements Runnable{
	private List<Integer> seats;//��Ҫ����λ����
	private NJCinema cinema;

	public HappyCustumer(List<Integer> seats, NJCinema cinema) {
		this.seats = seats;
		this.cinema = cinema;
	}
	@Override
	public void run() {
		//ͬ����
		synchronized(cinema) {
			boolean flag = cinema.bookTicks(seats);
			if(flag) {
				System.out.println(Thread.currentThread().getName()+"��Ʊ�ɹ�"+"-->λ������Ϊ��"+seats);
			}else {
				System.out.println(Thread.currentThread().getName()+"��Ʊʧ��"+"-->"+"λ�ò���");
			}
		
		}
		
	}
	
}

class NJCinema{
	private List<Integer> available;//ʣ���λ��
	private String name;//ӰԺ����
	public NJCinema(List<Integer> available, String name) {
		this.available = available;
		this.name = name;
	}
	//��Ʊ
	public boolean bookTicks(List<Integer> seats) {
		System.out.println("����λ������"+available);
		List<Integer> copy = new ArrayList<Integer>();//���ݲ�������
		copy.addAll(available);
		//List<Integer> copy = available;//����  copy �� available ������ͬ��һ���仯���仯
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