package cn.qjq;

import java.util.*;

/**
 * ����   �Ƚ��ȳ�
 * @author Administrator
 *2019��11��2��14:47:34
 */
public class TestQueue {
	public static void main(String[] args) {
		Queue<Command> queue = new LinkedList<Command>();
		new CreatQueue().creat(queue);
		new Consumer().consume(queue);
	}

}
class Command{
	private String s;
	Command(String s){
		this.s = s;
	}
	public void show() {
		System.out.println(this.s);
	}
}
class CreatQueue{
	//private Queue<Command> queue = new LinkedList<Command>();
	public void creat(Queue<Command> queue){
		queue.offer(new Command("gg"));
		queue.add(new Command("hh"));
		queue.offer(new Command("ff"));
	}
}
class Consumer{
	//CreatQueue q = new CreatQueue();
	//private Queue<Command> queue = new LinkedList<Command>();
	public void consume(Queue<Command> queue) {
		//while(queue.peek()!=null)
			//queue.remove().show();
		while(!queue.isEmpty())//ͬ�� Ч��һ��
			queue.remove().show();//remove�Ƴ������ض�ͷ
	}
}







