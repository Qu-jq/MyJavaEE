package cn.qjq;
/**
 * �׳��쳣
 * @author Administrator
 *2019��11��3��11:53:44
 */
class MyException extends Exception{
	MyException(String str){
		super(str);//���๹����
	}
}
class MyException2 extends Exception{
	private String str;
	MyException2(String str){
		this.str = str;
	}
	public void printms() {
		System.out.println("msg = "+str);
	}
}

public class TestTry {
	public static void f() throws MyException{
		System.out.println("Throwing MyException from f()!");
		throw new MyException("Originated in f()");
		//throw new MyException2("Originated in f()");
	}
	public static void main(String[] args) {
		try {
			f();
		}catch(MyException e) {
			System.out.println(e.getMessage());//��ȡ���յ�����Ϣ
		}finally {
			System.out.println("in finally cause");
		}
		try {
			throw new MyException2("MyException2");
		}catch(MyException2 e) {
			e.printms();
		}
	}
	

}
