package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 * 线程不安全：取钱出现负数
 * @author qjq
 *2019年11月22日16:37:40
 */
public class UnsafeTest3{
	
	public static void main(String[] args) {
		Acount acount = new Acount(100,"结婚礼钱");
		Withdraw w = new Withdraw(acount,70,"men");
		Withdraw w2 = new Withdraw(acount,80,"women");
		w.start();
		w2.start();
	}	
		
}


class Withdraw extends Thread{
	private Acount acount;
	private int withdrawMoney;//取钱数
	private int pocketMoney;//获得的钱
	
	public Withdraw(Acount acount, int withdrawMoney, String name) {
		super(name);//线程名字
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
		System.out.println(this.getName()+"账户余额-->"+acount.getMonenyTotal());
		System.out.println(this.getName()+"口袋中的钱-->"+pocketMoney);
	}
	
	
	
	
}
