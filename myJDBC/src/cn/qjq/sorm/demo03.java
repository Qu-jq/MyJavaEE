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
 * 使用map封装一条记录
 * 使用List<map>封装多条记录
 * Created by qjq on 2020/1/18 12:30
 */
public class demo03 {
    /**
     * 使用map封装一条记录
     */
    public static void test01(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Object> maps = new HashMap<String,Object>();//使用Map封装一条记录
        try {
            connection = JDBCUtil.getMysqlConn();
            ps = connection.prepareStatement("SELECT empname,age,salary FROM emp WHERE id = 1;");
            rs = ps.executeQuery();
            while(rs.next()){
                maps.put("empname",rs.getObject(1));
                maps.put("age",rs.getObject(2));
                maps.put("salary",rs.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        for(String key:maps.keySet()){
            System.out.print(key+"--"+maps.get(key)+"\t");
        }

    }

    /**
     * 使用List<map>封装多条记录
      */
    public static void test02(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
        try {
            connection = JDBCUtil.getMysqlConn();
            ps = connection.prepareStatement("SELECT empname,age,salary FROM emp WHERE id > ?;");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String,Object> maps = new HashMap<String,Object>();
                maps.put("empname",rs.getObject(1));
                maps.put("age",rs.getObject(2));
                maps.put("salary",rs.getObject(3));
                lists.add(maps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }
        for (Map<String,Object> map :
                lists) {
            for(String key:map.keySet()){
                System.out.print(key+"--"+map.get(key)+"\t");
            }
            System.out.println();
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
