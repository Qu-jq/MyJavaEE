package cn.qjq.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把Java中的各种结构（属性、方法、构造器、类名）映射成一个个Java对象
 * 1、获取class对象
 * 三种方式：推荐  Class.forName("包名.类名")   --更加灵活，与前类耦合度低
 * 2、可以动态创建对象
 * Iphone iphone3 = (Iphone)clz.getConstructor().newInstance();
 * @author qjq
 *2019年12月1日10:16:36
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Iphone iphone = new Iphone();
		//1.对象.getClass()   ----有一个手机样例，直接造
		Class clz = iphone.getClass();
		//2.类.class         -----找个内部的工程师拿到图纸
		clz = Iphone.class;
		//3.Class.forName("包名.类名")  ----自己去偷图纸
		clz = Class.forName("cn.qjq.server.basic.Iphone");
		Iphone iphone2 = (Iphone)clz.newInstance();//过时啦，不推荐使用
		System.out.println(iphone2);
		//推荐
		clz = Class.forName("cn.qjq.server.basic.Iphone");
		Iphone iphone3 = (Iphone)clz.getConstructor().newInstance();
		System.out.println(iphone3);
		
	}

}
class Iphone{
	//jdk1.9要求要有空的构造器
	public Iphone(){
		
	}
}