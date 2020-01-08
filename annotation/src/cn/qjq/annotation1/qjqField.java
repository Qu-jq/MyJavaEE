package cn.qjq.annotation1;
/**
 *属性的注解
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface qjqField {
    String collumnName();
    String type();
    int lenth();//需要设置数据表的属性
}
