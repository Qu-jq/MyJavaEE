package cn.qjq;

import java.util.*;

/**
 * ����LinkedList
 * @author Administrator
 *2019��11��1��15:44:18
 */
public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<String> str = new LinkedList<String>();
		str.add("a");
		str.addFirst("b");
		str.addLast("c");
		str.add("d");
		System.out.println(str);
		str.remove();
		str.removeFirst();
		System.out.println(str);
	}

}
