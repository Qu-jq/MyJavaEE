package cn.qjq;
/**
 * lambda����ʽ���+�����޲���
 * 
 * @author qjq
 *2019��11��19��16:00:46
 */
public class Lambda2 {
	public static void main(String[] args) {
		Work2 w = (int a1,int a2) -> {
			System.out.println("д���롣����"+a1+"-->"+a2);
		};
		w.abillities(12,14);
		w= (a1,a2) -> {
			System.out.println("д���롣����"+a1+"-->"+a2);
		};
		w.abillities(1, 2);
		//�����ʽ
		w= (a1,a2) -> System.out.println("д���롣����"+a1+"-->"+a2);
		w.abillities(3, 4);
	}

}
//�ӿ�ֻ����һ��δʵ�ֵķ���������ʹ��lambda
interface Work2{
	void abillities(int a,int b);
}

class Programmer2 implements Work2{
	@Override
	public void abillities(int a1,int a2) {
		System.out.println("д���롣����"+a1+"-->"+a2);
	}
	/*ֻ��һ��
	 * public void abillities(int a,int b) {
	 *
		System.out.println("д���롣����"+(a+b));
	}*/
	
}
