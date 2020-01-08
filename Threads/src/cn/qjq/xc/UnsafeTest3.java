package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 * �̲߳���ȫ��ȡǮ���ָ���
 * @author qjq
 *2019��11��22��16:37:40
 */
public class UnsafeTest3{
	
	public static void main(String[] args) {
		Acount acount = new Acount(100,"�����Ǯ");
		Withdraw w = new Withdraw(acount,70,"men");
		Withdraw w2 = new Withdraw(acount,80,"women");
		w.start();
		w2.start();
	}	
		
}


class Withdraw extends Thread{
	private Acount acount;
	private int withdrawMoney;//ȡǮ��
	private int pocketMoney;//��õ�Ǯ
	
	public Withdraw(Acount acount, int withdrawMoney, String name) {
		super(name);//�߳�����
		this.acount = acount;
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public void run() {
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
