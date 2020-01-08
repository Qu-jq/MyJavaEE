package cn.qjq;
/**
 * sleepģ��ʱ���ӳ�
 * @author qjq
 *2019��11��20��15:33:40
 */
public class BlockedSleep2 {
	public static void main(String[] args) {
		//һ����Դ
		Dash d = new Dash();
		//�������
		new Thread(d,"rabbit").start();
		new Thread(d,"tortoise").start();
	}
}

class Dash implements Runnable{
	private String winner;//ʤ����
	public void run() {
		for(int steps =1;steps<=100;steps++) {
			//����ÿ��10����Ϣ10ms
			if(Thread.currentThread().getName().equals("rabbit")&&(steps%10==0))
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
	
}
