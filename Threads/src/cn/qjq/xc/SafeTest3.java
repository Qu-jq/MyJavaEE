package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 *  �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������  <---����ʹ��
 * 2.ͬ����
 * @author qjq
 *2019��11��22��16:37:40
 */
public class SafeTest3{
	
	public static void main(String[] args) {
		Acount acount = new Acount(100,"�����Ǯ");
		SafeWithdraw w = new SafeWithdraw(acount,70,"men");
		SafeWithdraw w2 = new SafeWithdraw(acount,80,"women");
		w.start();
		w2.start();
	}	
		
}



class SafeWithdraw extends Thread{
	private Acount acount;
	private int withdrawMoney;//ȡǮ��
	private int pocketMoney;//��õ�Ǯ
	
	public SafeWithdraw(Acount acount, int withdrawMoney, String name) {
		super(name);//�߳�����
		this.acount = acount;
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public void run() {
		test2();
	}
	//Ŀ�겻�ԣ�����ʧ�ܣ����ﲻ������this������account
	public synchronized void test2() {
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
