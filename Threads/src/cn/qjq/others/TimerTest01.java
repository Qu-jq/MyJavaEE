package cn.qjq.others;


import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ��ʱ����
 * @author qjq
 *2019��11��24��11:37:38
 */
public class TimerTest01 {
	public static void main(String[] args) {
		Timer t= new Timer();//����һ���µļ�ʱ��
		//t.schedule(new TimeTask(), 1000);//1���ִ��
		//t.schedule(new TimeTask(), 1000,2000);//��ָ��1 ����ӳ�֮��ʼ ������ִ�� �̶��ӳ�2��ִ�е�ָ������
		GregorianCalendar cal = new GregorianCalendar(2019,10,24,12,00,00 );//ע�⣺�·ݴ�0��ʼ�ģ���0��ʾһ�·�
		t.schedule(new TimeTask(), cal.getTime());//ָ��ʱ��ִ��
	}

}
//һ��ʵ�ֽӿڣ��̳г����࣬��Ͼ����� ��
class TimeTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("Hold on!!!");	
	}
	
}
