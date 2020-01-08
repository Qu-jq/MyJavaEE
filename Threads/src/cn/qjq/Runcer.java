package cn.qjq;
/**
 * 模拟赛跑
 * @author qjq
 *2019年11月18日12:04:03
 */
public class Runcer implements Runnable{
	private String winner;//胜利者
	public void run() {
		for(int steps =1;steps<=100;steps++) {
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
	
	public static void main(String[] args) {
		//一份资源
		Runcer r = new Runcer();
		//多个代理
		new Thread(r,"rabbit").start();
		new Thread(r,"dog").start();
	}

}
