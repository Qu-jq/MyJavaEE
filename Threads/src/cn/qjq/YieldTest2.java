package cn.qjq;
/**
 * yield �����߳�  ֱ�ӻص�����״̬ ����������״̬
 * @author qjq
 *2019��11��20��16:29:45
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
				Thread.yield();//main�߳�����
			System.out.println("main..."+i);
		}
	}

}
