package cn.qjq;

import java.util.LinkedList;

/**
 * �Խ�Stack
 * @author Administrator
 *2019��11��1��16:22:50
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T v) {
		storage.addFirst(v);
	}
	public T peek() {
		return storage.getFirst();//���ص�һ��Ԫ��
	}
	public T pop() {
		return storage.removeFirst();//�Ƴ��������б��ͷ��Ϊ��ʱ�׳��쳣
	}
	public boolean empty() {
		return storage.isEmpty();
	}
	public String toString() {
		return storage.toString();
	}

}
