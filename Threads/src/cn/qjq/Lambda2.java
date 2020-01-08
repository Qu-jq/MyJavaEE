package cn.qjq;
/**
 * lambda函数式编程+输入无参数
 * 
 * @author qjq
 *2019年11月19日16:00:46
 */
public class Lambda2 {
	public static void main(String[] args) {
		Work2 w = (int a1,int a2) -> {
			System.out.println("写代码。。。"+a1+"-->"+a2);
		};
		w.abillities(12,14);
		w= (a1,a2) -> {
			System.out.println("写代码。。。"+a1+"-->"+a2);
		};
		w.abillities(1, 2);
		//最简形式
		w= (a1,a2) -> System.out.println("写代码。。。"+a1+"-->"+a2);
		w.abillities(3, 4);
	}

}
//接口只能有一个未实现的方法，才能使用lambda
interface Work2{
	void abillities(int a,int b);
}

class Programmer2 implements Work2{
	@Override
	public void abillities(int a1,int a2) {
		System.out.println("写代码。。。"+a1+"-->"+a2);
	}
	/*只能一个
	 * public void abillities(int a,int b) {
	 *
		System.out.println("写代码。。。"+(a+b));
	}*/
	
}
