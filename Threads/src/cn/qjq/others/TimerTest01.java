package cn.qjq.others;


import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时调度
 * @author qjq
 *2019年11月24日11:37:38
 */
public class TimerTest01 {
	public static void main(String[] args) {
		Timer t= new Timer();//创建一个新的计时器
		//t.schedule(new TimeTask(), 1000);//1秒后执行
		//t.schedule(new TimeTask(), 1000,2000);//在指定1 秒的延迟之后开始 ，重新执行 固定延迟2秒执行的指定任务
		GregorianCalendar cal = new GregorianCalendar(2019,10,24,12,00,00 );//注意：月份从0开始的，即0表示一月份
		t.schedule(new TimeTask(), cal.getTime());//指定时间执行
	}

}
//一般实现接口，继承抽象类，组合具体类 。
class TimeTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("Hold on!!!");	
	}
	
}
