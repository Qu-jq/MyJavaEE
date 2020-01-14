package cn.qjq.jdbctest;

import java.sql.*;

/**
 *测试事务的基本功能
 * 测试事务的原子性：事务中有一条语句执行失败，自动回滚到第一条语句之前的数据状态。
 * Created by qjq on 2020/1/13 20:22
 */
public class demo06 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            connection.setAutoCommit(false);//JDBC中默认自动提交事务，所以此处设置为false
            ps = connection.prepareStatement("INSERT INTO users(username,age) VALUES('小区',15)");
            ps.execute();
            System.out.println("插入小区记录");
            //延时
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ps = connection.prepareStatement("INSERT INTO users(username,age) VALUES('小hua',15,hu)");//插入错误数据
            ps.execute();
            System.out.println("插入小hua记录");
            connection.commit();

        } catch (ClassNotFoundException | SQLException e) {
            try {
                connection.rollback();//回滚操作
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //先开的后关
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
