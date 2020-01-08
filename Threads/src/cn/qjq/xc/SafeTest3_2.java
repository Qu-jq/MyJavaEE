package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

import cn.qjq.Web12306;

/**
 *  线程安全：在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法  
 * 2.同步块  <---本例使用
 * 锁定account目标
 * @author qjq
 *2019年11月22日16:37:40
 */
public class SafeTest3_2{
	
	public static void main(String[] args) {
		Acount acount = new Acount(100,"结婚礼钱");
		SynWithdraw w = new SynWithdraw(acount,70,"men");
		SynWithdraw w2 = new SynWithdraw(acount,80,"women");
		w.start();
		w2.start();
	}	
		
}



class SynWithdraw extends Thread{
	private Acount acount;
	private int withdrawMoney;//取钱数
	private int pocketMoney;//获得的钱
	
	public SynWithdraw(Acount acount, int withdrawMoney, String name) {
		super(name);//线程名字
		this.acount = acount;
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public void run() {
		test2();
	}
	//锁定account
	public synchronized void test2() {
		//提高效率
		if(acount.getMonenyTotal()<0) {
			return;
		}
		//同步块
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
			System.out.println(this.getName()+"账户余额-->"+acount.getMonenyTotal());
			System.out.println(this.getName()+"口袋中的钱-->"+pocketMoney);
		}
	}
}
