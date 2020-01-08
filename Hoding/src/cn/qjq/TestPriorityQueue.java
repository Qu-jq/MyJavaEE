package cn.qjq;

import java.util.*;

/**
 * 优先级队列，最小的值拥有最高的优先级
 * @author Administrator
 *2019年11月2日15:53:15
 */
public class TestPriorityQueue {
	
	public static void main(String[] args) {
		Random random = new Random(47);
		PriorityQueue<Double> p = new PriorityQueue<Double>();
		for(int i=0;i<10;i++)
			p.offer(random.nextDouble());
		while(!p.isEmpty())
			System.out.println(p.poll());
		
	}
}
