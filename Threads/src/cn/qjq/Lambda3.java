package cn.qjq;
/**
 * lambda函数式编程+返回值
 * 
 * @author qjq
 *2019年11月19日16:00:46
 */
public class Lambda3 {
	public static void main(String[] args) {
		Work3 w = (int a1,int a2) -> {
			System.out.println("写代码");
			return a1+a2;
		};
		System.out.println(w.abillities(12,14));
		
		w= (a1,a2) -> a1+a2;
		System.out.println(w.abillities(2,4));
		
	}

}
//接口只能有一个未实现的方法，才能使用lambda
interface Work3{
	int abillities(int a,int b);
}

/*class Programmer3 implements Work3{
	@Override
	public int abillities(int a1,int a2) {
		System.out.println("写代码");
		return a1+a2;
	}
	
}*/
