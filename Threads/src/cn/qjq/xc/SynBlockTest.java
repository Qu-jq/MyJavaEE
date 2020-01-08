package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 * ����Ч��
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����
 * @author qjq
 *2019��11��22��16:37:40
 *shift+tab��������  ��������֪��
 */
public class SynBlockTest{
	public static void main(String[] args) {
		//һ����Դ
		GetTickNum web = new GetTickNum();
		Thread.currentThread().getName();//���߳�
		//�������
		new Thread(web,"С��").start();
		new Thread(web,"С��").start();
		new Thread(web,"С��").start();
	}	
}
class GetTickNum implements Runnable{
	//ʣ��Ʊ��
	private int tickNum = 50;
	private Boolean flag=true;
	public void run() {
		while(flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test4();
		}
		
	}
	//�̰߳�ȫ�������ܵ���������ķ�Χ������ָ����ķ�Χ��ָ���ݵ������ԣ�
	public  void test5() {
		if(tickNum<=0) {//����û��Ʊ�����
			flag=false;
			return;
		}
		synchronized(this) {
			while(flag) {
				if(tickNum<=0) {//����ֻʣһ��Ʊ�����
					flag=false;
					return;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			}
		}
	}
	//������ΧС   �����Ķ���Ӧ�ñ�  ---����ʱ��������ȷ�ģ�����֣�����
	public  void test4() {
		synchronized((Integer)tickNum) {
			while(flag) {
				if(tickNum<=0) {
					flag=false;
					return;
				}
					
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
				
			}
		}
	}
	//������   �����Ķ���Ӧ�ñ�  ---����ʱ��������ȷ�ģ�����֣�����
		public void test3() {
			synchronized((Integer)tickNum) {
				while(tickNum>0) {
					if(tickNum<=0)
						break;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
					
				}
			}
		}
	//������   ����ʱ��ͬ������Ч����ͬ
	public  void test2() {
		synchronized(this) {
			while(true) {
				if(tickNum<=0)
					break;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
				
			}
		}
	}
	
	//ͬ������
	public synchronized void test1() {
		while(true) {
			if(tickNum<=0)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			
		}
	}
	public  void test() {
		while(true) {
			if(tickNum<=0)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+tickNum--);
			
		}
	}
		
}
