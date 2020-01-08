package cn.qjq.xc;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：操作容器
 * @author qjq
 *2019年11月22日15:42:01
 */
public class UnsafeTest01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		for (int i=0;i<1000;i++) {
			new Thread(()->{
			list.add(Thread.currentThread().getName());
			}).start();
		}
		
		System.out.println(list.size());//结果总是小于1000，不安全
	}
}
