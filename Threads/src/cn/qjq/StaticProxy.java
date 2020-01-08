package cn.qjq;
/**
 * ��̬����
 * �����ӿ�
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * @author qjq
 *2019��11��19��14:43:23
 */
public class StaticProxy {
	public static void main(String[] args) {
		new MarryCompany(new You()).happyMary();
	}

}
//�����ӿ�
interface Marry{
	void happyMary();
}

//��ʵ��ɫ
class You implements Marry{
	@Override
	public void happyMary() {
		System.out.println("You are very happy...");
	}
}
//����
class MarryCompany implements Marry{
	private Marry target;
	MarryCompany(Marry target){
		this.target = target;
	}
	@Override
	public void happyMary() {
		prepare();
		this.target.happyMary();
		after();
	}
	private void prepare() {
		System.out.println("׼��������");
	}
	private void after() {
		System.out.println("��ʰ������");
	}
}


