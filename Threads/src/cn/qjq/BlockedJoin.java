package cn.qjq;
/**
 * 组合线程 插队线程 jion  成员方法
 * @author qjq
 *2019年11月20日17:07:59
 */
public class BlockedJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread T = new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda...."+i);
			}
		}
				);
		T.start();
		
		for(int i=0;i<100;i++) {
			if(i==20)
				T.join();;//插入线程，主线程被阻塞
			System.out.println("main...."+i);
		}
		
	}

}
