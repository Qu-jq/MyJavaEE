package cn.qjq.annotation1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE})   //表明注解的使用范围：方法和类
@Retention(RetentionPolicy.RUNTIME)                     //表明注解的使用周期：在运行时有效
public @interface qjqAnnotation {
    String value();//当只有一个参数成员时，一般设置为value
    int age() default 18;//可以设置默认值
}
