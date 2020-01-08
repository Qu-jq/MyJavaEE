package cn.qjq;
/**
 * ����lambda���߳�
 * ���ڼ򻯼򵥵��߳� �ӿ���ֻ��һ��δʵ�ֵķ���
 * @author qjq
 *2019��11��19��15:56:24
 */
public class LambdaThread{
	//��̬�ڲ���
	static class Test implements Runnable{
		public void run() {
			for(int i=0;i<20;i++) {
				System.out.println("����д���룡");
			}
		}
	}
	

	public static void main(String[] args) {
		//��̬�ڲ��಻ʹ�ò�����ã���ʡ��Դ
		new Thread(new Test()).start();
		//�ֲ��ڲ���
		class Test2 implements Runnable{
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("����д���룡");
				}
			}
		}
		new Thread(new Test2()).start();
		//���ڼ򻯼򵥵��߳� �ӿ���ֻ��һ��δʵ�ֵķ���
		new Thread(()-> {
			for(int i=0;i<20;i++) {
				System.out.println("����д���룡");
			}
			}).start();//�������� ---������ֻʹ��һ��ʱ��ʹ�ô˷���
	}	
}
