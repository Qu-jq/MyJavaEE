package cn.qjq;
/**
 * ����߳� ����߳� jion  ��Ա����
 * @author qjq
 *2019��11��20��17:07:59
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
				T.join();;//�����̣߳����̱߳�����
			System.out.println("main...."+i);
		}
		
	}

}
