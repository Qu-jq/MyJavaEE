package cn.qjq;
/**
 * ��̬�ۼ���ʼ��  �ۼ���ʼ�� 
 * @author Administrator
 *2019��11��4��10:58:07
 */
public class TestAggergateInitialize {
	static void hide(BerylliumSphere[] b) {
		System.out.println("Hiding : "+b.length+" sphere(s)");
	}
	public static void main(String[] args) {
		hide(new  BerylliumSphere[] {new BerylliumSphere(),new BerylliumSphere()});//ʹ�ö�̬�ۼ���ʼ��
		BerylliumSphere[] a = new BerylliumSphere[] {new BerylliumSphere(),new BerylliumSphere()};
		hide(a);
		//�ۼ���ʼ��
		BerylliumSphere[] b = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
		hide(b);
		//hide({new BerylliumSphere(),new BerylliumSphere()});//�������
		
	}

}
class BerylliumSphere{
	
}
