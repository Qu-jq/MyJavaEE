package cn.qjq.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��Java�еĸ��ֽṹ�����ԡ���������������������ӳ���һ����Java����
 * 1����ȡclass����
 * ���ַ�ʽ���Ƽ�  Class.forName("����.����")   --��������ǰ����϶ȵ�
 * 2�����Զ�̬��������
 * Iphone iphone3 = (Iphone)clz.getConstructor().newInstance();
 * @author qjq
 *2019��12��1��10:16:36
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Iphone iphone = new Iphone();
		//1.����.getClass()   ----��һ���ֻ�������ֱ����
		Class clz = iphone.getClass();
		//2.��.class         -----�Ҹ��ڲ��Ĺ���ʦ�õ�ͼֽ
		clz = Iphone.class;
		//3.Class.forName("����.����")  ----�Լ�ȥ͵ͼֽ
		clz = Class.forName("cn.qjq.server.basic.Iphone");
		Iphone iphone2 = (Iphone)clz.newInstance();//��ʱ�������Ƽ�ʹ��
		System.out.println(iphone2);
		//�Ƽ�
		clz = Class.forName("cn.qjq.server.basic.Iphone");
		Iphone iphone3 = (Iphone)clz.getConstructor().newInstance();
		System.out.println(iphone3);
		
	}

}
class Iphone{
	//jdk1.9Ҫ��Ҫ�пյĹ�����
	public Iphone(){
		
	}
}