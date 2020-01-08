package cn.qjq;
/**
 * lambda函数式编程+无参数
 * 
 * @author qjq
 *2019年11月19日16:00:46
 */
public class Lambda {
	public static void main(String[] args) {
		Work w = ()-> {
			System.out.println("写代码。。。");
		};
		w.abillities();
		
		
	}

}
//接口只能有一个未实现的方法，才能使用lambda
interface Work{
	void abillities();
}

class Programmer implements Work{
	@Override
	public void abillities() {
		System.out.println("写代码。。。");
	}
	/*只能一个
	 * public void abillities(int a,int b) {
	 *
		System.out.println("写代码。。。"+(a+b));
	}*/
	
}
