package cn.qjq.sorm;


import java.sql.Date;

/**
 * Created by qjq on 2020/1/18 13:12
 */
public class Emp {
    private Integer id;
    private String empname;
    private double salary;
    private Date birthday;
    private Integer age;
    private Integer deptId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Emp(Integer id, String empname, double salary, Date birthday, Integer age, Integer deptId) {
        this.id = id;
        this.empname = empname;
        this.salary = salary;
        this.birthday = birthday;
        this.age = age;
        this.deptId = deptId;
    }

    public Emp(String empname, double salary, Integer age) {
        this.empname = empname;
        this.salary = salary;
        this.age = age;
    }
    //必须要有空构造器
    public Emp() {
    }
}
