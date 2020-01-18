package cn.qjq.sorm;

import cn.qjq.jdbctest.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用Javabean对象封装一条记录
 * 使用List<Javabean>封装多条记录
 * Created by qjq on 2020/1/18 12:30
 */
public class demo04 {
    /**
     * 使用Javabean对象封装一条记录
     */
    public static void test01(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Emp emp = null;
        try {
            connection = JDBCUtil.getMysqlConn();
            ps = connection.prepareStatement("SELECT empname,age,salary FROM emp WHERE id = 1;");
            rs = ps.executeQuery();
            while(rs.next()){
               emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        System.out.println(emp.getEmpname()+"--"+emp.getAge()+"--"+emp.getSalary());

    }

    /**
     * 使用List<Javabean>封装多条记录
      */
    public static void test02(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> lists = new ArrayList<Emp>();
        try {
            connection = JDBCUtil.getMysqlConn();
            ps = connection.prepareStatement("SELECT empname,age,salary FROM emp WHERE id > ?;");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
                lists.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }
        for (Emp emp :
                lists) {
            System.out.println(emp.getEmpname()+"--"+emp.getAge()+"--"+emp.getSalary());
        }



    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        test02();
    }
}
