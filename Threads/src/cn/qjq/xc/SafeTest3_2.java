package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 *  �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������  
 * 2.ͬ����  <---����ʹ��
 * ����accountĿ��
 * @author qjq
 *2019��11��22��16:37:40
 */
public class SafeTest3_2{
	
	public static void main(String[] args) {
		Acount acount = new Acount(100,"�����Ǯ");
		SynWithdraw w = new SynWithdraw(acount,70,"men");
		SynWithdraw w2 = new SynWithdraw(acount,80,"women");
		w.start();
		w2.start();
	}	
		
}



class SynWithdraw extends Thread{
	private Acount acount;
	private int withdrawMoney;//ȡǮ��
	private int pocketMoney;//��õ�Ǯ
	
	public SynWithdraw(Acount acount, int withdrawMoney, String name) {
		super(name);//�߳�����
		this.acount = acount;
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public void run() {
		test2();
	}
	//����account
	public synchronized void test2() {
		//���Ч��
		if(acount.getMonenyTotal()<0) {
			return;
		}
		//ͬ����
		synchronized(acount) {
			if(acount.getMonenyTotal()-withdrawMoney<0) {
				return;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acount.setMonenyTotal(acount.getMonenyTotal()-withdrawMoney);
			pocketMoney += withdrawMoney;
			System.out.println(this.getName()+"�˻����-->"+acount.getMonenyTotal());
			System.out.println(this.getName()+"�ڴ��е�Ǯ-->"+pocketMoney);
		}
	}
}
