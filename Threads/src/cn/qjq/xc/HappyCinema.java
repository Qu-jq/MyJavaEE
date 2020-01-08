package cn.qjq.xc;
/**
 * ������ӰƱʾ��
 * �汾һ��
 * ��������Ʊ
 * ʣ�༸��Ʊ
 * @author qjq
 *2019��11��23��12:51:30
 */
public class HappyCinema {
	public static void main(String[] args) {
		Cinema c = new Cinema(20,"NanJ");
		new Thread(new Custumer(5,c),"С��").start();
		new Thread(new Custumer(3,c),"С��").start();
	}

}

class Custumer implements Runnable{
	private int seats;//��Ҫ����λ��
	private Cinema cinema;
	

	public Custumer(int seats, Cinema cinema) {
		this.seats = seats;
		this.cinema = cinema;
	}
	@Override
	public void run() {
		//ͬ����
		synchronized(cinema) {
			boolean flag = cinema.bookTicks(seats);
			if(flag) {
				System.out.println("��Ʊ�ɹ�"+"-->λ������Ϊ��"+seats);
			}else {
				System.out.println("��Ʊʧ��"+"-->"+"λ�ò���");
			}
		
		}
		
	}
	
}

class Cinema{
	private int available;//ʣ���λ��
	private String name;//ӰԺ����
	public Cinema(int available, String name) {
		this.available = available;
		this.name = name;
	}
	//��Ʊ
	public boolean bookTicks(int seats) {
		System.out.println("����λ������"+available);
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