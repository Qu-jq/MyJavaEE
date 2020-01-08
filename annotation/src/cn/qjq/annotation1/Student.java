package cn.qjq.annotation1;

import java.util.Set;

/**
 * 只需要会给各个类和变量注解就行
 * 解析的任务一般都是框架完成的
 *
 */

@qjqTable("tb_student") //括号内对应数据表的名字
public class Student {
    @qjqField(collumnName = "sname",type = "varchar",lenth = 10)
    private String name;
    @qjqField(collumnName = "id",type = "int",lenth = 3)
    private int id;
    @qjqField(collumnName = "age",type = "int",lenth = 3)
    private int age;
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
