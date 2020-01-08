package cn.qjq.test01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过Class的API获取对应类的名字，属性，方法，构造器
 * Created by qjq on 2019/12/22 19:51
 */
public class GetInfos {
    public static void main(String[] args) {
        String path = "cn.qjq.bean.User";
        try {
            Class clazz = Class.forName(path);
            //获得名字
            String cname = clazz.getName();//获得包名+类名cn.qjq.bean.User
            System.out.println(cname);
            String cname2 = clazz.getSimpleName();//获得类名User
            System.out.println(cname2);
            //获得属性Field
            Field[] fields = clazz.getFields();//获得全部属性
            System.out.println(fields.length);//结果为0，因为只能获得公开的属性，private不能获取
            Field[] fields1 = clazz.getDeclaredFields();//获得全部声明的属性
            for (Field temp :
                    fields1) {
                System.out.println("属性："+temp);
            }
            Field field = clazz.getDeclaredField("name");//获得具体的属性
            System.out.println("获得具体属性："+field);

            //获得方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method temp :
                    methods) {
                System.out.println("方法："+temp);
            }
            //方法无传递参数时，可以直接写
            Method method = clazz.getDeclaredMethod("getName");
            //有传递参数时，要声明参数类型的Class对象
            Method method1 = clazz.getMethod("setName", String.class);
            //

            //获得构造器
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor temp :
                    constructors) {
                System.out.println("构造器："+temp);
            }
            Constructor constructor = clazz.getConstructor(int.class,String.class,int.class);
            System.out.println("获得指定的构造器："+constructor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
