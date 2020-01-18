package cn.qjq.sorm;

import cn.qjq.jdbctest.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 将多条记录封装成Object
 * Created by qjq on 2020/1/18 11:49
 */
public class demo02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<Object[]>();//创建数组列表
        try {
            connection = JDBCUtil.getMysqlConn();
            ps = connection.prepareStatement("SELECT age,empname,salary FROM emp WHERE id > ?;");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                Object[] objs = new Object[3];
                objs[0] = rs.getObject(1);
                objs[1] = rs.getObject(2);
                objs[2] = rs.getObject(3);
                list.add(objs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }
        for(Object[] objs:list){
            System.out.println(""+objs[0]+objs[1]+objs[2]);
        }
    }
}
