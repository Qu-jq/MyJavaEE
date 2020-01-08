package cn.qjq.bean;

/**
 * 用户信息类
 */
public class User {
    private int age;
    private String name;
    private int id;
    //alt+insert快捷键生成，shift多选
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public User(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public User() {
    }
}
