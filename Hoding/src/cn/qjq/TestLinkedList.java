package cn.qjq;

import java.util.*;

/**
 * ²âÊÔLinkedList
 * @author Administrator
 *2019Äê11ÔÂ1ÈÕ15:44:18
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
