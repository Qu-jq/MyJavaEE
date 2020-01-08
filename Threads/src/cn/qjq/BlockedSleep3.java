package cn.qjq;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleepģ�⵹��ʱ
 * @author qjq
 *2019��11��20��15:50:37
 */
public class BlockedSleep3 {
	public static void main(String[] args) throws InterruptedException {
		//����ʱ
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
		//����10���� 1��һ��
		int i=10;
		while(true) {
			Thread.sleep(1000);//1��
			System.out.println(i--);
			if(i==-1)
				break;
		}
	}
}

