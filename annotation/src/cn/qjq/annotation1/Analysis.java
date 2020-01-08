package cn.qjq.annotation1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static java.lang.Class.forName;

public class Analysis {
    public static void main(String[] args) {
        try {
            Class clzz = forName("cn.qjq.annotation1.Student");
            //获得类的所有注解
            Annotation[] annotations = clzz.getAnnotations();
            for(Annotation annotation :annotations){
                System.out.println(annotation);
            }
            //获得类指定的注解
            qjqTable stu = (qjqTable) clzz.getAnnotation(qjqTable.class);
            System.out.println(stu.value());
            //获得属性的注解
            Field f = clzz.getDeclaredField("age");
            qjqField fields = f.getAnnotation(qjqField.class);
            System.out.println(fields.collumnName()+"-->"+fields.type()+"-->"+fields.lenth());

            //获得表名、字段信息，拼出DDL语句，然后使用JDBC执行这个SQL，在数据表中生成数据表
            //这部分工作，后续完成
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
