package cn.qjq;
/**
 * yield 礼让线程  直接回到就绪状态 而不是阻塞状态
 * @author qjq
 *2019年11月20日16:29:45
 */
public class YieldTest2 {
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda..."+i);
			}
		}).start();
		for(int i=0;i<100;i++) {
			if(i%20==0)
				Thread.yield();//main线程礼让
			System.out.println("main..."+i);
		}
	}

}
