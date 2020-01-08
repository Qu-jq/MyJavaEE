package cn.qjq;

import java.util.LinkedList;

/**
 * 自建Stack
 * @author Administrator
 *2019年11月1日16:22:50
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T v) {
		storage.addFirst(v);
	}
	public T peek() {
		return storage.getFirst();//返回第一个元素
	}
	public T pop() {
		return storage.removeFirst();//移除并返回列表的头，为空时抛出异常
	}
	public boolean empty() {
		return storage.isEmpty();
	}
	public String toString() {
		return storage.toString();
	}

}
