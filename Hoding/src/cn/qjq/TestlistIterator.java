package cn.qjq;

import java.util.*;

/**
 * 使用Iteration的子类listiterator处理list类
 * @author Administrator
 *2019年11月1日13:52:01
 */
public class TestlistIterator {
	public static void main(String[] args) {
		List<Integer> m = new ArrayList<Integer>();
		List<Integer> n = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			m.add(i);
		}
		ListIterator<Integer> k = m.listIterator();
		while(k.hasNext()) {
			System.out.print(k.next()+","+k.nextIndex()+";");
			
		}
		System.out.println();
		k.add(222);//改变k就相当于改变m
		System.out.println(m);
		System.out.println();
		while(k.hasPrevious()) {
			n.add(k.previous());
		}
		System.out.print(n);
	}

}