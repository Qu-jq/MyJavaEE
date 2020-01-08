package cn.qjq;

import java.util.*;

/**
 * 队列   先进先出
 * @author Administrator
 *2019年11月2日14:47:34
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
		while(!queue.isEmpty())//同上 效果一样
			queue.remove().show();//remove移除并返回队头
	}
}







