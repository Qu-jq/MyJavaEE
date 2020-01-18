package cn.qjq.sorm;

import cn.qjq.jdbctest.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 将一条记录封装成Object
 * Created by qjq on 2020/1/18 11:49
 */
public class demo01 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        Object[] objs = null;
        try {
            connection = JDBCUtil.getMysqlConn();
            ps = connection.prepareStatement("SELECT age,empname,salary FROM emp WHERE id = 1;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                objs = new Object[3];
                objs[0] = rs.getObject(1);
                objs[1] = rs.getObject(2);
                objs[2] = rs.getObject(3);
                System.out.println(""+objs[0]+objs[1]+objs[2]);//字符串拼接输出
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
