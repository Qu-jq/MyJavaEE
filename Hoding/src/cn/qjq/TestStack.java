package cn.qjq;
import cn.qjq.Stack;
/**
 * ʹ��LinkedListʵ��Stack  ����ȳ�
 * @author Administrator
 *2019��11��1��16:21:58
 */
public class TestStack {
	private final static  Stack<Character> T = new Stack<Character>();
	static void getValue(String str) {
		char[] data = str.toCharArray();//ת��������
		for(int i = 0;i<data.length;) {
			switch(data[i++]) {
			case '+': T.push(data[i++]);break;
			case '-': System.out.print(T.pop());break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		getValue("+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---");
		
	}

}
