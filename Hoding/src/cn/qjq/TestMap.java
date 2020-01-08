package cn.qjq;

import java.util.*;

/**
 * Map的使用
 * @author Administrator
 *2019年11月2日13:34:40
 */
public class TestMap {
	public static Map <String,List<Dog>> petPeople = new HashMap<String,List<Dog>>();
	static {
		petPeople.put("慧慧", Arrays.asList(new Cat("xiaomi")));
		petPeople.put("小渠", Arrays.asList(new Cat("xiaohua")));
		petPeople.put("小渠", Arrays.asList(new Cat("xiaogou")));//将xiaohua覆盖为xiaogou，并没有重新创建
	}
	public static void main(String[] args) {
		System.out.println("people: "+petPeople.keySet());//输出所有键
		System.out.println("cats: "+petPeople.values());//输出所有的值
		System.out.println(petPeople.get("小渠"));//得到键对应的值
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


