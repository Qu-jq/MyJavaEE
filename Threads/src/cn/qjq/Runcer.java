package cn.qjq;
/**
 * ģ������
 * @author qjq
 *2019��11��18��12:04:03
 */
public class Runcer implements Runnable{
	private String winner;//ʤ����
	public void run() {
		for(int steps =1;steps<=100;steps++) {
			System.out.println(Thread.currentThread().getName()+"--->"+steps);
			if(gameOver(steps))
				break;
		}
	}
	public boolean gameOver(int steps) {
		if(winner != null) {//û��ʤ����ʱ
			return true;
		}else {
			if(steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner-->"+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		//һ����Դ
		Runcer r = new Runcer();
		//�������
		new Thread(r,"rabbit").start();
		new Thread(r,"dog").start();
	}

}
