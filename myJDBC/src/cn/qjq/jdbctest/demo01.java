package cn.qjq.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *测试与数据库建立连接
 * Created by qjq on 2020/1/13 20:22
 */
public class demo01 {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接，实际很耗时，这是Connection对象管理的一个要点）
            //实际开发中，为提高效率，使用连接池来管理连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
