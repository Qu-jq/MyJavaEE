package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

/**
 * �̲߳���ȫ����������
 * @author qjq
 *2019��11��22��15:42:01
 */
public class UnsafeTest01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		for (int i=0;i<1000;i++) {
			new Thread(()->{
			list.add(Thread.currentThread().getName());
			}).start();
		}
		
		System.out.println(list.size());//�������С��1000������ȫ
	}
}
