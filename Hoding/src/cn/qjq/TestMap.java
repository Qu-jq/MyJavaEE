package cn.qjq;

import java.util.*;

/**
 * Map��ʹ��
 * @author Administrator
 *2019��11��2��13:34:40
 */
public class TestMap {
	public static Map <String,List<Dog>> petPeople = new HashMap<String,List<Dog>>();
	static {
		petPeople.put("�ۻ�", Arrays.asList(new Cat("xiaomi")));
		petPeople.put("С��", Arrays.asList(new Cat("xiaohua")));
		petPeople.put("С��", Arrays.asList(new Cat("xiaogou")));//��xiaohua����Ϊxiaogou����û�����´���
	}
	public static void main(String[] args) {
		System.out.println("people: "+petPeople.keySet());//������м�
		System.out.println("cats: "+petPeople.values());//������е�ֵ
		System.out.println(petPeople.get("С��"));//�õ�����Ӧ��ֵ
		System.out.println(petPeople.getClass());
		for(String s:petPeople.keySet()) {
			System.out.println("people: "+s);
			for(Dog d:petPeople.get(s))
				System.out.println("cat: "+d);
		}
	}

}

class Dog{

}

class Cat extends Dog{
	private String s;
	Cat(String s){
		this.s = s;
	}
	public String toString() {
		return s;
	}
}


