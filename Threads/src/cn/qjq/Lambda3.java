package cn.qjq;
/**
 * lambda����ʽ���+����ֵ
 * 
 * @author qjq
 *2019��11��19��16:00:46
 */
public class Lambda3 {
	public static void main(String[] args) {
		Work3 w = (int a1,int a2) -> {
			System.out.println("д����");
			return a1+a2;
		};
		System.out.println(w.abillities(12,14));
		
		w= (a1,a2) -> a1+a2;
		System.out.println(w.abillities(2,4));
		
	}

}
//�ӿ�ֻ����һ��δʵ�ֵķ���������ʹ��lambda
interface Work3{
	int abillities(int a,int b);
}

/*class Programmer3 implements Work3{
	@Override
	public int abillities(int a1,int a2) {
		System.out.println("д����");
		return a1+a2;
	}
	
}*/
