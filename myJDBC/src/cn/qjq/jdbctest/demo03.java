package cn.qjq.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *测试PreparedStatement基本用法
 * Created by qjq on 2020/1/13 20:22
 */
public class demo03 {
    public static void main(String[] args) {

        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            //使用PreparedStatement接口执行sql
                //第一种插入数据方式
            String sql = "INSERT INTO users(username,age) VALUES('小区',15)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();

                //第二种插入数据方式
            String sql2 = "INSERT INTO users(username,age,data) VALUES(?,?,?)";//?为占位符
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            /*ps2.setString(1,"小花");//参数索引是从1开始的
            ps2.setInt(2,14);
            ps2.setDate(3,new java.sql.Date(System.currentTimeMillis()));*/
                //第三种方式，直接传递对象，上一种方式较为复杂，需要设置具体的参数类型
            ps2.setObject(1,"小明");
            ps2.setObject(2,12);
            ps2.setObject(3,new java.sql.Date(System.currentTimeMillis()));
            ps2.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
