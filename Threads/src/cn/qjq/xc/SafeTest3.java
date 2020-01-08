package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 *  线程安全：在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法  <---本例使用
 * 2.同步块
 * @author qjq
 *2019年11月22日16:37:40
 */
public class SafeTest3{
	
	public static void main(String[] args) {
		Acount acount = new Acount(100,"结婚礼钱");
		SafeWithdraw w = new SafeWithdraw(acount,70,"men");
		SafeWithdraw w2 = new SafeWithdraw(acount,80,"women");
		w.start();
		w2.start();
	}	
		
}



class SafeWithdraw extends Thread{
	private Acount acount;
	private int withdrawMoney;//取钱数
	private int pocketMoney;//获得的钱
	
	public SafeWithdraw(Acount acount, int withdrawMoney, String name) {
		super(name);//线程名字
		this.acount = acount;
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public void run() {
		test2();
	}
	//目标不对，锁定失败，这里不是锁定this，而是account
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
		System.out.println(this.getName()+"账户余额-->"+acount.getMonenyTotal());
		System.out.println(this.getName()+"口袋中的钱-->"+pocketMoney);
	}
	
	
	
}
