package cn.qjq;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 * @author qjq
 *2019年11月20日15:50:37
 */
public class BlockedSleep3 {
	public static void main(String[] args) throws InterruptedException {
		//倒计时
		Date endTime = new Date(System.currentTimeMillis()+1000*10);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime = new Date(endTime.getTime()-1000);
			if(end-10000>endTime.getTime()) {
				break;
			}
		}
	}
	
	public static void test() throws InterruptedException {
		//倒数10个数 1秒一个
		int i=10;
		while(true) {
			Thread.sleep(1000);//1秒
			System.out.println(i--);
			if(i==-1)
				break;
		}
	}
}

