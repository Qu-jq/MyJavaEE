package cn.qjq.annotation1;
/**
 * 了解常用的三个注解
 * @Override
 * @SuppressWarnings
 * @Deprecated
 */

import java.util.ArrayList;
import java.util.List;

public class AnnotationTest1 {
    //重写方法的注释
    @Override
    public String toString() {
        System.out.println("hhh");
        return "hhh";
    }
    //压住警告
    @SuppressWarnings("all")
    public void test001(){
        List Arr = new ArrayList();
        List Arr2 = new ArrayList();
    }
    //不鼓励使用注释
    @Deprecated
    public void test002(){
        System.out.println("test002");
    }

    public static void main(String[] args) {
        AnnotationTest1 a = new AnnotationTest1();
        a.toString();
        a.test001();
        a.test002();
    }

}
