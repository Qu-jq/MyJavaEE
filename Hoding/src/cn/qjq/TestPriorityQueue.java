package cn.qjq;

import java.util.*;

/**
 * ���ȼ����У���С��ֵӵ����ߵ����ȼ�
 * @author Administrator
 *2019��11��2��15:53:15
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
