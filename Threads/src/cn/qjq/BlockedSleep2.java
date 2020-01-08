package cn.qjq;
/**
 * sleep模拟时间延迟
 * @author qjq
 *2019年11月20日15:33:40
 */
public class BlockedSleep2 {
	public static void main(String[] args) {
		//一份资源
		Dash d = new Dash();
		//多个代理
		new Thread(d,"rabbit").start();
		new Thread(d,"tortoise").start();
	}
}

class Dash implements Runnable{
	private String winner;//胜利者
	public void run() {
		for(int steps =1;steps<=100;steps++) {
			//兔子每走10步休息10ms
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
		if(winner != null) {//没有胜利者时
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
