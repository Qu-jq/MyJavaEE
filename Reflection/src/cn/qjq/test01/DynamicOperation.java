package cn.qjq.test01;

import cn.qjq.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态操作：构造器，方法，属性
 * Created by qjq on 2019/12/22 20:59
 */
public class DynamicOperation {
    public static void main(String[] args) {
        String path = "cn.qjq.bean.User";
        try {
            Class<User> clazz = (Class<User>) Class.forName(path);
            //1.操作构造器
            User user = (User) clazz.newInstance();
            //其实是调用了User的无参构造器，这就要求User类中必须声明了无参构造器
            System.out.println(user);
            //调用含参构造器
            Constructor c = clazz.getConstructor(int.class,String.class,int.class);
            User user1 = (User) c.newInstance(18,"小渠1",1001);
            System.out.println(user1.getName());
            //2.操作方法
            User user2 = (User) clazz.newInstance();
            //直接调用的方法
            user2.setName("小渠2");
            System.out.println(user2.getName());
            //通过反射API调用方法
            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.invoke(user2,"小渠3");//激活方法
            System.out.println(user2.getName());//上面两行相当于user2.setName("小渠3");

            //3.操作属性
            User user3 = (User) clazz.newInstance();
            Field nameField = clazz.getDeclaredField("name");
            //field.set(user3,"小渠6");//不能直接设置，name为private类型
            nameField.setAccessible(true);//这个属性不用做安全检查啦，可以直接访问，也可以作用在私有方法上
            nameField.set(user3,"小渠6");
            System.out.println(user3.getName());//通过方法调用
            System.out.println(nameField.get(user3));//通过反射调用
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
