package cn.qjq;
/**
 * lambda����ʽ���+�޲���
 * 
 * @author qjq
 *2019��11��19��16:00:46
 */
public class Lambda {
	public static void main(String[] args) {
		Work w = ()-> {
			System.out.println("д���롣����");
		};
		w.abillities();
		
		
	}

}
//�ӿ�ֻ����һ��δʵ�ֵķ���������ʹ��lambda
interface Work{
	void abillities();
}

class Programmer implements Work{
	@Override
	public void abillities() {
		System.out.println("д���롣����");
	}
	/*ֻ��һ��
	 * public void abillities(int a,int b) {
	 *
		System.out.println("д���롣����"+(a+b));
	}*/
	
}
