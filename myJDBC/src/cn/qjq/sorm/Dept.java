package cn.qjq.sorm;

/**
 * Created by qjq on 2020/1/18 13:18
 */
public class Dept {
    private Integer id;
    private String deptname;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dept(Integer id, String deptname, String address) {
        this.id = id;
        this.deptname = deptname;
        this.address = address;
    }
    //必须要有空构造器
    public Dept() {
    }
}
